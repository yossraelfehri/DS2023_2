package EX2;

public class arbre extends plante {
    public String type_Feuillage;
    private final double AbsorMoyenne = 22;

    public arbre(String nom, double hauteur, int age, double prix, String type_Feuillage) {
        super(nom, hauteur, age, prix);
        this.type_Feuillage = type_Feuillage;
    }

    public void description() {
        super.description();
        System.out.println("Type de feuillage: " + type_Feuillage);
    }

    public double absorptionCO2() {
        double absorption = AbsorMoyenne;
        if (super.hauteur > 50) {
            absorption += 3;
        }
        return absorption;
    }
    
}
