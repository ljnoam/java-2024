package produit;

public class Produit {
    protected String nom;
    protected double prixHT;

    public Produit(String nom, double prixHT) {
        this.nom = nom;
        this.prixHT = prixHT;
    }

    public double calculerPrix() {
        return prixHT; // Par défaut, retourne le prix HT
    }

    public void afficherInfos() {
        System.out.println("Produit : " + nom + ", Prix TTC : " + calculerPrix() + " euros");
    }
}
