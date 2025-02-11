package personne;

public class Person {
    private String nom;
    private int age;

    // Constructeurs
    public Person() {
        this.nom = "";
        this.age = 0;
    }

    public Person(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Méthode se présenter
    public void sePresenter() {
        System.out.println("Je m'appelle " + nom + " et j'ai " + age + " ans.");
    }
}
