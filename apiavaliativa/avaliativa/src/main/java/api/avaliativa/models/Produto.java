package api.avaliativa.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TB_PRODUTOS")
@Getter
@Setter
// Criando tabela de produto
// e gerando os getters e setters para manipulação dos dados
public class Produto{
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Integer id;
    
    
    @Column(name = "nome_Produto")
    private String nome;

    
    @Column(name = "Preço_Produto")
    private Double preco;
}