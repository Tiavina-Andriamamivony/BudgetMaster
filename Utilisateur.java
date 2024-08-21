package org.Zavatra;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Utilisateur {
    private String nom;
    private double budgetMensuel;
    private List<Depense> listeDesDepenses;

    public Utilisateur(String nom, double budgetMensuel, List<Depense> listeDesDepenses) {
        this.nom = nom;
        this.budgetMensuel = budgetMensuel;
        this.listeDesDepenses = listeDesDepenses;
        verify();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getBudgetMensuel() {
        return budgetMensuel;
    }

    public void setBudgetMensuel(double budgetMensuel) {
        this.budgetMensuel = budgetMensuel;
    }

    public List<Depense> getListeDesDepenses() {
        return listeDesDepenses;
    }

    public void setListeDesDepenses(List<Depense> listeDesDepenses) {
        this.listeDesDepenses = listeDesDepenses;
    }

    void ajouterDepense(String description, double montant, Categorie categorie, LocalDate date) {
        listeDesDepenses.add(new Depense(description, montant, categorie,date));
    }
    void afficherDepense(){
        for (Depense depense : listeDesDepenses) {
            System.out.println(depense.getDescription()+"a pour montant "+depense.getMontant()+" et de catégorie "+ depense.getCategorie());
        }
    }
    void afficherParCategorie(Categorie categorie){
        for (Depense depense : listeDesDepenses) {
            if(depense.getCategorie().equals(categorie)){
                System.out.println(depense.getDescription()+"a pour categorie "+categorie);
            }
        }
    }
    double TotalDesDepenses(){
        LocalDate date = LocalDate.now();
        Month month = date.getMonth();
        double total = 0;
        for (Depense depense : listeDesDepenses) {
            if (depense.getDateDAjout().getMonth().equals(month)) {
                total += depense.getMontant();
            }
        }
        return total;
    }
    double BudgetRestant(){
        double depense = TotalDesDepenses();
        return budgetMensuel - depense;
    }
    boolean verify(){
        double depense = TotalDesDepenses();
        if (budgetMensuel < depense ) {
            System.out.println("Vos dépenses sont trop élevé.");
            return false;
        }
        return true;
    }
       List<Categorie> getTopCategories(){
        List<Categorie> categories = new ArrayList<>(3);
           List<Depense> Nourriture_et_restauration = new ArrayList<>();
           List<Depense> Transport = new ArrayList<>();
           List<Depense> Divertissement = new ArrayList<>();
           List<Depense> Services_publics = new ArrayList<>();
           List<Depense> Autres = new ArrayList<>();
           List<List<Depense>> preview = new ArrayList<>();
            preview.add(Nourriture_et_restauration);
            preview.add(Transport);
            preview.add(Divertissement);
            preview.add(Services_publics);
            preview.add(Autres);
           for (Depense depense : listeDesDepenses) {
            if (depense.getCategorie().equals(Categorie.Nourriture_et_restauration)) {
                Nourriture_et_restauration.add(depense);
            }
            if (depense.getCategorie().equals(Categorie.Transport)){
                Transport.add(depense);
            }
            if (depense.getCategorie().equals(Categorie.Divertissement)) {
                Divertissement.add(depense);
            }
            if (depense.getCategorie().equals(Categorie.Services_publics)) {
                Services_publics.add(depense);
            }
            if (depense.getCategorie().equals(Categorie.Autres)) {
                Autres.add(depense);
            }
        }
           Arrays.stream(preview.stream().toArray()).sorted()
            return categories;
       }

}
