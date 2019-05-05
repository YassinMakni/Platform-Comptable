package org.comptabilite.AMC.exchangeForm.Requests;

import java.util.Set;

public class SignUpForm {

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse ;
    private String telephone ;
    private String nomSociete ;
    private String matricule ;
    private String telSociete ;
    private String numRegistreCommerce ;
    private String secteurActivite ;
    private String adresseSociete ;
    private String emailSociete ;
    private Set<String> role;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getTelSociete() {
        return telSociete;
    }

    public void setTelSociete(String telSociete) {
        this.telSociete = telSociete;
    }

    public String getNumRegistreCommerce() {
        return numRegistreCommerce;
    }

    public void setNumRegistreCommerce(String numRegistreCommerce) {
        this.numRegistreCommerce = numRegistreCommerce;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public String getAdresseSociete() {
        return adresseSociete;
    }

    public void setAdresseSociete(String adresseSociete) {
        this.adresseSociete = adresseSociete;
    }

    public String getEmailSociete() {
        return emailSociete;
    }

    public void setEmailSociete(String emailSociete) {
        this.emailSociete = emailSociete;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public static class SignUpFormAdmin {
    }
}
