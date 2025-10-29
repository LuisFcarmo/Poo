package produtos.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    private String id;
    private String nome;
    private Double preco;
    private String descricao;
    private Integer estoque;
}