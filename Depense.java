package org.Zavatra;


import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Depense {
    private String description;
    private double montant;
    private Categorie categorie;
    private LocalDate dateDAjout;

    public Depense(String description, double montant, Categorie categorie) {
        this.description = description;
        this.montant = montant;
        this.categorie = categorie;
    }

    public Depense(String description, double montant, Categorie categorie, LocalDate dateDAjout) {
        this.description = description;
        this.montant = montant;
        this.categorie = categorie;
        this.dateDAjout = dateDAjout;
    }

    public LocalDate getDateDAjout() {
        return dateDAjout;
    }

    public void setDateDAjout(LocalDate dateDAjout) {
        this.dateDAjout = dateDAjout;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
