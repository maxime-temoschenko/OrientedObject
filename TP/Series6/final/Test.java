public class Test {

    public static void main(String[] args) throws TransportAccessException  {
        Bus b = new Bus(3, 8);
        /*
         * In this case, main doesn't handle any exception, it stops the program directly
         * 
         * 
         */
  

        String[] stops = { "Opéra", "Pont d'Avroy", "Charlemagne", "Av. Blonden", "Guillemins", "Pl. Général Leman",
                "Monument Gramme", "Pont du Val Benoït", "R. du Chêne", "Mairie d'Angleur", "Belle Jardinière",
                "Tennis Club", "Beau Hêtre", "Parc industriel", "Orchidée Blanche", "Eglise", "Mésanges",
                "R. de L'Aunaie",
                "Amphithéâtres", "Chimie", "Physique", "Polytech", "R. des Pôles", "Barbecue - Golf",
                "Education Physique",
                "C.H.U. - Botanique" };

        SeatedPassenger sp1 = new SeatedPassenger("Nori");
        SeatedPassenger sp2 = new SeatedPassenger("Fili");
        SeatedPassenger sp3 = new SeatedPassenger("Dori");
        SeatedPassenger sp4 = new SeatedPassenger("Bofur");
        SeatedPassenger sp5 = new SeatedPassenger("Gloin");

        UncrowdedPassenger up1 = new UncrowdedPassenger("Dwalin");
        UncrowdedPassenger up2 = new UncrowdedPassenger("Thorin");
        UncrowdedPassenger up3 = new UncrowdedPassenger("Balin");
        
        sp1.requestTransport(b, 2);
        sp2.requestTransport(b, 5);
        sp3.requestTransport(b, 9);

        b.nextStop(stops[0]);

        sp4.requestTransport(b, 3);
        
        up1.requestTransport(b, 2);
    
      
        b.nextStop(stops[1]);
        
        sp5.requestTransport(b, 2);

        up2.requestTransport(b, 7);

        b.nextStop(stops[2]);
        b.nextStop(stops[3]);

        up3.requestTransport(b, 2);
           

        for (int i = 0; i<7; i++) b.nextStop(stops[i+4]);

        System.out.println("The bus reached his terminus.");   

    }

}