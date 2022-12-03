package api.avaliativa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.avaliativa.dto.*;
import api.avaliativa.models.Produto;
import api.avaliativa.service.ProdutoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/Produto")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProdutoCrontroller {

    final ProdutoService produtoService;

    public ProdutoCrontroller(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    
    @PostMapping
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDto produtodto){
        var produto = new Produto();
        BeanUtils.copyProperties(produtodto, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllproduto(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
        
    }
    @PutMapping
    public ResponseEntity<Object> editarproduto(@PathVariable (value = "id") Integer id, @RequestBody @Valid ProdutoDto produtoDto){
        Optional<Produto> produtoOptional = produtoService.findById(id);
        if (!produtoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        var produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);
        produto.setId(produtoOptional.get().getId());


        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produto));
    }
}