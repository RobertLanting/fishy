package nl.hu.bep.FishySystem.controller;


import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;
import nl.hu.bep.FishySystem.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Key;
import java.util.ArrayList;
import java.util.Calendar;


@Controller
public class UserController {

    final static private Key key = MacProvider.generateKey();
    private Aquarium aquarium;


    private String createToken(String username, String role) throws JwtException {
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE, 30);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration.getTime())
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    private Eigenaar validateUser(Cookie[] cookies) {
        for (Cookie c : cookies) {
            if (c.getName().equals("token")) {
                try {
                    Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(c.getValue()).getBody();
                    return AquariumManager.getEigenaar(claims.getSubject());
                } catch (SignatureException e) {
                    return null;
                }
            }
        }
        return null;
    }

    private Boolean validateAdmin(Cookie[] cookies) {
        for (Cookie c : cookies) {
            if (c.getName().equals("token")) {
                try {
                    Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(c.getValue()).getBody();
                    if (claims.getSubject().equals("admin")); {
                        return true;
                    }
                } catch (SignatureException e) {
                    return false;
                }
            }
        }
        return false;
    }

    private void eraseCookie(HttpServletRequest req, HttpServletResponse resp, String name) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
    }

    @RequestMapping({"/login"})
    public String login(@RequestParam(required = false) String regvoornaam,
                        @RequestParam(required = false) String regachternaam,
                        @RequestParam(required = false) String voornaam,
                        @RequestParam(required = false) String achternaam,
                        Model model, HttpServletResponse response, HttpServletRequest request) {

        eraseCookie(request,response,"token");

        if (regachternaam != null & regvoornaam != null) {
            for (Eigenaar e : AquariumManager.getAlleEigenaren()) {
                if (e.getVoornaam().equals(regvoornaam) || e.getAchternaam().equals(regachternaam)) {
                    model.addAttribute("error", "voornaam of achternaam is al in gebruik");
                    return "register";
                }
            }

            AquariumManager.addEigenaar(new Eigenaar(regvoornaam, regachternaam));;

            return "login";
        }

        if (Eigenaar.login(voornaam, achternaam)) {
            String token = createToken(voornaam, "eigenaar");
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);

            if (voornaam.equals("admin")) {
                model.addAttribute("eigenaren", AquariumManager.getAlleEigenaren());
                return "admin";
            }
            return "homepage";
        }

        return "login";
    }

    @RequestMapping({"/home"})
    public String home(Model model,HttpServletRequest request) {

        aquarium = null;
        Eigenaar eigenaar = validateUser(request.getCookies());

        model.addAttribute("naam",eigenaar.getVoornaam() + " " + eigenaar.getAchternaam());
        model.addAttribute("aquaria",eigenaar.getAquaria());
        model.addAttribute("toebehoren", eigenaar.getToebehoren());

        return "homepage";
    }


    @RequestMapping({"/register"})
    public String register( Model model) {
        return "register";
    }

    @RequestMapping({"/aquarium"})
    public String aquarium( Model model) {
        return "aquarium";
    }

    @RequestMapping({"/bewoner"})
    public String bewoner(@RequestParam(required = false) String aquarium,
                          Model model, HttpServletRequest request) {

        Eigenaar eigenaar = validateUser(request.getCookies());
        setAquarium(eigenaar.vindAquarium(aquarium));
        return "bewoner";


    }

    @RequestMapping({"/ornament"})
    public String ornament(@RequestParam(required = false) String aquarium,
                          Model model, HttpServletRequest request) {

        Eigenaar eigenaar = validateUser(request.getCookies());
        setAquarium(eigenaar.vindAquarium(aquarium));
        return "ornament";

    }

    @RequestMapping({"/toebehoren"})
    public String toebehoren(@RequestParam(required = false) String aquarium,
                           Model model, HttpServletRequest request) {
        return "toebehoren";

    }

    @RequestMapping({"/addaquarium"})
    public String addaquarium(@RequestParam(required = false) String naam,
                              @RequestParam(required = false) Integer lengte,
                              @RequestParam(required = false) Integer breedte,
                              @RequestParam(required = false) Integer hoogte,
                              @RequestParam(required = false) String bodem,
                              @RequestParam(required = false) String water,
                              Model model, HttpServletRequest request) {

        Eigenaar eigenaar = validateUser(request.getCookies());

        if (naam != null) {
            eigenaar.voegAquariumToe(new Aquarium(naam, lengte, breedte, hoogte, bodem, water));
        }
        return "homepage";
    }

    @RequestMapping({"/addbewoner"})
    public String addbewoner(@RequestParam(required = false) String soortnaam,
                              @RequestParam(required = false) String kleurnaam,
                              @RequestParam(required = false) Integer aantal,
                              @RequestParam(required = false) Boolean groepsdier,
                              @RequestParam(required = false) String type,
                              Model model, HttpServletRequest request) {

        if (soortnaam != null) {
            if (groepsdier == null) {
                groepsdier = false;
            }
            aquarium.voegBewonerToe(new Bewoner(soortnaam, kleurnaam, aantal, groepsdier, type));
        }
        return "homepage";
    }

    @RequestMapping({"/addornament"})
    public String addornament(@RequestParam(required = false) String naam,
                             @RequestParam(required = false) String omschrijving,
                             @RequestParam(required = false) String kleur,
                             @RequestParam(required = false) Boolean kanopluchtpomp,
                             Model model, HttpServletRequest request) {

        if (naam != null) {
            if (kanopluchtpomp == null) {
                kanopluchtpomp = false;
            }
            aquarium.voegOrnamentToe(new Ornament(naam, omschrijving, kleur, kanopluchtpomp));
        }
        return "homepage";
    }

    @RequestMapping({"/addtoebehoren"})
    public String addtoebehoren(@RequestParam(required = false) String model,
                              @RequestParam(required = false) String omschrijving,
                              HttpServletRequest request) {

        Eigenaar eigenaar = validateUser(request.getCookies());

        if (model != null) {
            eigenaar.voegToebehorenToe(new Toebehoren(model,omschrijving));
        }
        return "homepage";
    }

    @RequestMapping({"/removebewoner"})
    public String removebewoner(@RequestParam(required = false) String aquarium,
                                @RequestParam(required = false) String soortnaam,
                             Model model, HttpServletRequest request) {

        Eigenaar eigenaar = validateUser(request.getCookies());
        setAquarium(eigenaar.vindAquarium(aquarium));

        if (soortnaam != null) {
            this.aquarium.verwijderBewoner(soortnaam);
        }
        return "homepage";
    }

    @RequestMapping({"/removeornament"})
    public String removeornament(@RequestParam(required = false) String aquarium,
                                 @RequestParam(required = false) String naam,
                                Model model, HttpServletRequest request) {

        Eigenaar eigenaar = validateUser(request.getCookies());
        setAquarium(eigenaar.vindAquarium(aquarium));

        if (naam != null) {
            this.aquarium.verwijderOrnament(naam);
        }
        return "homepage";
    }

    @RequestMapping({"/removeaquarium"})
    public String removeaquarium(@RequestParam(required = false) String aquarium,
                                Model model, HttpServletRequest request) {

        Eigenaar eigenaar = validateUser(request.getCookies());

        if (aquarium != null) {
            eigenaar.verwijderAquarium(aquarium);
        }
        return "homepage";
    }

    @RequestMapping({"/removetoebehoren"})
    public String removetoebehoren(@RequestParam(required = false) String toebehoor,
                                 Model model, HttpServletRequest request) {

        Eigenaar eigenaar = validateUser(request.getCookies());

        if (toebehoor != null) {
            eigenaar.verwijdertoebehoor(toebehoor);
        }
        return "homepage";
    }

    @RequestMapping({"/removeeigenaar"})
    public String removeeigenaar(@RequestParam(required = false) String eigenaar,
                                   Model model, HttpServletRequest request) {

        if(validateAdmin(request.getCookies())) {
            AquariumManager.verwijderEigenaar(eigenaar);
        }

       return "admin";
    }



    @RequestMapping({"/admin"})
    public String admin( Model model,HttpServletRequest request) {
        if (validateAdmin(request.getCookies())) {
            model.addAttribute("eigenaren", AquariumManager.getAlleEigenaren());
            return "admin";
        }

        return "login";
    }


    @RequestMapping({"/"})
    public String start(Model model) {
        return "login";
    }

    public void setAquarium(Aquarium aquarium) {
        this.aquarium = aquarium;
    }
}
