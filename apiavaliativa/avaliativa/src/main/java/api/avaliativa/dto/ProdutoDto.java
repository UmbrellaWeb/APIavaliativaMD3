package api.avaliativa.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {

    @NotBlank
    private String nome;

    @NotNull
    private Double preco;
}