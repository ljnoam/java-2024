package voiture;

import transport.Transport;

public class Voiture extends Vehicule implements Transport {
    private final String marque;
    private final String modele;
    private final String couleur;

    public Voiture(String marque, String modele, String couleur) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
    }

    @Override
    public void demarrer() {
        System.out.println("La voiture " + marque + " démarre.");
    }

    @Override
    public void deplacer() {
        System.out.println("La voiture " + marque + " roule sur la route.");
    }

    public String getModele() {
        return modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void klaxonner() {
        System.out.println("La voiture klaxonne !");
    }
}
