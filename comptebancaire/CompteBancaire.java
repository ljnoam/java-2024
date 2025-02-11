package comptebancaire;

public class CompteBancaire {
    // Attributs privés
    private double solde;
    private final String titulaire;

    // Constructeur
    public CompteBancaire(String titulaire, double soldeInitial) {
        this.titulaire = titulaire;
        this.solde = soldeInitial;
    }

    // Méthode pour obtenir le titulaire
    public String getTitulaire() {
        return titulaire;
    }

    // Méthode pour déposer de l'argent
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println(montant + " € déposés. Nouveau solde : " + solde + " €");
        } else {
            System.out.println("Le montant à déposer doit être positif.");
        }
    }

    // Méthode pour retirer de l'argent
    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println(montant + " € retirés. Nouveau solde : " + solde + " €");
        } else if (montant > solde) {
            System.out.println("Fonds insuffisants. Solde actuel : " + solde + " €");
        } else {
            System.out.println("Le montant à retirer doit être positif.");
        }
    }
}
