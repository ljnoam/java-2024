package animal;

public class Main {
    public static void main(String[] args) {
        // Création d'objets polymorphiques
        Animal animal1 = new Chien();
        Animal animal2 = new Chat();

        // Appel de la méthode redéfinie
        animal1.faireDuBruit(); // Affiche : Le chien aboie : Woof Woof !
        animal2.faireDuBruit(); // Affiche : Le chat miaule : Meow Meow !
    }
}
