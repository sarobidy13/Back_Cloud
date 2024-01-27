package com.example.vehicule.controller.annonce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backcloud.api.APIResponse;
import com.example.vehicule.model.annonce.Annonce;
import com.example.vehicule.service.annonce.AnnonceService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {
    @Autowired
    private AnnonceService annonceService;

    @GetMapping("/nonvendues")
    public ResponseEntity<APIResponse> getAnnoncesNonVendues() {
        try {
            List<Annonce> nonVendu = annonceService.getAnnoncesNonVendues();
            return ResponseEntity.ok(new APIResponse("", nonVendu));
        } catch (Exception e) {
            // TODO: handle exception
            APIResponse response = new APIResponse("Erreur lors de la création du besoin: " + e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/proprietaire/{proprietaire}")
    public ResponseEntity<APIResponse> getAnnoncesByProprietaire(@PathVariable String proprietaire) {
        try {
            List<Annonce> annonces = annonceService.getAnnoncesByProprietaire(proprietaire);
            return ResponseEntity.ok(new APIResponse("", annonces));
        } catch (Exception e) {
            APIResponse response = new APIResponse(
                    "Erreur lors de la récupération des annonces pour le propriétaire: " + e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertAnnonce(@RequestBody Annonce annonce) {
        try {
            Annonce insertedAnnonce = annonceService.insertAnnonce(annonce);
            return ResponseEntity.ok(new APIResponse("Annonce insérée avec succès", insertedAnnonce));
        } catch (Exception e) {
            APIResponse response = new APIResponse("Erreur lors de l'insertion de l'annonce: " + e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> update(@PathVariable String id, @RequestBody Annonce annonce) {
        try {
            annonceService.update(id, annonce);
            return ResponseEntity.ok(new APIResponse("Annonce update avec succès, ID: ", true));

        } catch (Exception e) {
            // TODO: handle exception
            APIResponse response = new APIResponse("Erreur lors de la création annonce: " + e.getMessage(), false);
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getAnnonceById(@PathVariable String id) {
        try {
            Annonce annonce = annonceService.findById(id);
            return ResponseEntity.ok(new APIResponse("", annonce));
        } catch (EntityNotFoundException e) {
            APIResponse response = new APIResponse("Annonce non trouvée avec l'ID : " + id, false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (Exception e) {
            APIResponse response = new APIResponse("Erreur lors de la récupération de l'annonce : " + e.getMessage(),
                    false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
