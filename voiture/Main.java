package voiture;

import transport.Transport;

public class Main {
    public static void main(String[] args) {
        // Création d'une voiture
        Transport voiture = new Voiture("Tesla", "Model S", "Noir");

        // Appel des méthodes
        voiture.deplacer(); // Appelle la méthode deplacer() de Voiture
        ((Voiture) voiture).demarrer(); // Appelle la méthode demarrer() de Voiture
        ((Voiture) voiture).klaxonner(); // Appelle la méthode klaxonner() de Voiture
    }
}
