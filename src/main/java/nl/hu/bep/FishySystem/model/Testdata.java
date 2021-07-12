package nl.hu.bep.FishySystem.model;

public class Testdata {



    public static void maaktestdata() {
        System.out.println("test");
        Eigenaar eigenaar = new Eigenaar("jos", "reenen");
        AquariumManager.addEigenaar(eigenaar);

        eigenaar.voegToebehorenToe(new Toebehoren("Tetra","intern filter"));
        eigenaar.voegToebehorenToe(new Toebehoren("geen","intern filter"));

        Aquarium aquarium0 = new Aquarium("Aquarium0",30,60,30, "zand", "zoet");

        aquarium0.voegOrnamentToe(new Ornament("grieks", "standbeeld", "grijs", false));
        aquarium0.voegOrnamentToe(new Ornament("grieks", "speer", "bruin", true));

        Aquarium aquarium1 = new Aquarium("Aquarium1",30,60,30, "grind", "zoet");

        aquarium1.voegOrnamentToe(new Ornament("spongebob", "poppetje", "geel", true));
        aquarium1.voegOrnamentToe(new Ornament("ananashuis", "huis van spongebob", "oranje", true));
        aquarium1.voegOrnamentToe(new Ornament("gezonken schip", "kapot schip", "wit", false));

        aquarium1.voegBewonerToe(new Bewoner("Kardinaal Tetra","bruin",7,true,"vis"));
        aquarium1.voegBewonerToe(new Bewoner("corydora","wit",6,true,"vis"));
        aquarium1.voegBewonerToe(new Bewoner("japonica","roze",5,false,"garnaal"));
        aquarium1.voegBewonerToe(new Bewoner("helena","bruin",2,true,"slak"));

        Aquarium aquarium2 = new Aquarium("Aquarium2",30,60,30, "aarde", "zout");

        aquarium2.voegOrnamentToe(new Ornament("ijskasteel", "kasteel van elsa", "blauw", true));

        aquarium2.voegBewonerToe(new Bewoner("corydora","wit",2,true,"vis"));
        aquarium2.voegBewonerToe(new Bewoner("Kardinaal Tetra","bruin",5,true,"vis"));
        aquarium2.voegBewonerToe(new Bewoner("CPO","rood",1,false,"kreeft"));

        eigenaar.voegAquariumToe(aquarium0);
        eigenaar.voegAquariumToe(aquarium1);
        eigenaar.voegAquariumToe(aquarium2);

        Eigenaar admin = new Eigenaar("admin", "123");
        AquariumManager.addEigenaar(admin);
    }
}
