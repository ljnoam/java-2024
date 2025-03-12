package application;

import java.sql.Timestamp;

public class User {
    private int id;
    private String name;
    private String email;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public User(int id, String name, String email, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Timestamp getCreatedAt() { return createdAt; }
    public Timestamp getUpdatedAt() { return updatedAt; }

    @Override
    public String toString() {
        return "User [ID=" + id + ", Name=" + name + ", Email=" + email + "]";
    }
}
