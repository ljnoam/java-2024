package produit;

public class DVD extends Produit {
    public DVD(String nom, double prixHT) {
        super(nom, prixHT);
    }

    @Override
    public double calculerPrix() {
        return prixHT * 1.20; // Prix TTC avec 20% de TVA
    }
}
