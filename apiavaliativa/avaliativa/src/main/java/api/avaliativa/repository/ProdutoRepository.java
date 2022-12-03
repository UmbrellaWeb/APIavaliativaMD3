package api.avaliativa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import api.avaliativa.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Integer> {
    
}