package com.example.vehicule.model.annonce;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "annonce")
public class Annonce {

    @Id
    private String id;

    private String titre;
    private String description;
    private String categorie;
    private String marque;
    private double prix;
    private Date dateAjout;
    private Date dateVente;
    private int status;
    private String image;
    private String proprietaire;
    private List<Favori> favoris;
    private int estValide;

    public Annonce() {
    }

    public Annonce(String titre, String description, String categorie, String marque, double prix,
            Date dateAjout, Date dateVente, int status, String image, String proprietaire,
            List<Favori> favoris, int estValide) {
        this.titre = titre;
        this.description = description;
        this.categorie = categorie;
        this.marque = marque;
        this.prix = prix;
        this.dateAjout = dateAjout;
        this.dateVente = dateVente;
        this.status = status;
        this.image = image;
        this.proprietaire = proprietaire;
        this.favoris = favoris;
        this.estValide = estValide;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public List<Favori> getFavoris() {
        return favoris;
    }

    public void setFavoris(List<Favori> favoris) {
        this.favoris = favoris;
    }

    public int getEstValide() {
        return estValide;
    }

    public void setEstValide(int estValide) {
        this.estValide = estValide;
    }
}
