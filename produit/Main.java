package produit;

public class Main {
    public static void main(String[] args) {
        // Création d'objets Livre et DVD
        Produit livre = new Livre("Java Programming", 20.0);
        Produit dvd = new DVD("Inception", 15.0);

        // Afficher les informations
        livre.afficherInfos(); // Affiche : Produit : Java Programming, Prix TTC : 21.0 euros
        dvd.afficherInfos();   // Affiche : Produit : Inception, Prix TTC : 18.0 euros
    }
}
