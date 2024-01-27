package com.example.vehicule.repository.annonce;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.vehicule.model.annonce.Annonce;

public interface AnnonceRepository extends MongoRepository<Annonce, String> {
    List<Annonce> findByStatusAndEstValide(int status, int estValide);

    List<Annonce> findByProprietaire(String proprietaire);

    Optional<Annonce> findById(String id);
}