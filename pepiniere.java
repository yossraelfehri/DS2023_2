package EX2;

public class pepiniere {

    private plante[] inventaire;
    private final int MAX_PLANTES = 1000;
    private int nombreDePlantes;

    public pepiniere() {
        inventaire = new plante[MAX_PLANTES];
        nombreDePlantes = 0;
    }

    public void ajoutPlante(plante plante) {
        if (nombreDePlantes < MAX_PLANTES) {
            inventaire[nombreDePlantes] = plante;
            nombreDePlantes++;
        } else {
            System.out.println("erreur");
        }
    }

    public double totalAbsorptionTotaleCO2() {
    	double absorptionTotaleCO2 = 0;
    	for (int i = 0; i<nombreDePlantes ; i++ ) {
    		if (inventaire[i] instanceof arbre) {
    			absorptionTotaleCO2 = absorptionTotaleCO2*((arbre)inventaire[i]).absorptionCO2();
    		}
    	}
    	return absorptionTotaleCO2;
    }
    
    public int compterArbresCaduques() {
        int count = 0;
        for (int i = 0; i < nombreDePlantes; i++) {
            if (inventaire[i] instanceof arbre) {
            	arbre Arbre = (arbre)inventaire[i];
            	if ("Caduque".equals(Arbre.getTypeFeuillage())) {
            		count++;
            	}
            }
        }
        return count;
    }

    public void afficherInventaire() {
        for (int i = 0; i < nombreDePlantes; i++) {
            inventaire[i].description();
            if (inventaire[i] instanceof fleur) {
                ((fleur) inventaire[i]).fleurir();
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Pépinière GREEN HANDS");
        pepiniere pépinière = new pepiniere();
        fleur rose = new fleur(null, 30, 12, 15.99, "Rouge", 2);
        fleur tulipe = new fleur("Tulipe", 20, 8, 12.99, "Jaune", 4);
        arbre chêne = new arbre("Chêne", 200, 60, 89.99, "Caduque");
        arbre sapin = new arbre("Sapin", 150, 30, 59.99, "Persistant");
        rose.setNom("Rose");
        System.out.println("la "+rose.getNom()+" a le couleur "+rose.getCouleur());
        pépinière.ajoutPlante(rose);
        pépinière.ajoutPlante(tulipe);
        pépinière.ajoutPlante(chêne);
        pépinière.ajoutPlante(sapin);
        pépinière.afficherInventaire();
        System.out.println("Total Aborption CO2        "+   pépinière.totalAbsorptionTotaleCO2());
        System.out.println("Nombre d'arbres Caduques dans la pépinière : " + pépinière.compterArbresCaduques());
       
    }
}
