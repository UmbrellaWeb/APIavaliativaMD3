package api.avaliativa.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.avaliativa.models.Produto;
import api.avaliativa.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
  
    final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    
    @Transactional
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }


    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }


    public Optional<Produto> findById(Integer id) {
        return produtoRepository.findById(id);
    }

    
}