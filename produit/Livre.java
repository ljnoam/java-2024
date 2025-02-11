package produit;

public class Livre extends Produit {
    public Livre(String nom, double prixHT) {
        super(nom, prixHT);
    }

    @Override
    public double calculerPrix() {
        return prixHT * 1.05; // Prix TTC avec 5% de TVA
    }
}
