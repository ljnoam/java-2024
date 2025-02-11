package comptebancaire;

public class Main {
    public static void main(String[] args) {
        // Création d'un compte bancaire
        CompteBancaire compte = new CompteBancaire("Alice", 1000);

        // Dépôts et retraits
        compte.deposer(500);
        compte.retirer(300);
        compte.retirer(2000); // Fonds insuffisants
    }
}

