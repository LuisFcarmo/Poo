package produtos.example.demo.service;
import produtos.example.demo.model.Produto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private static final String CSV_FILE_PATH = "produtos.csv";

    public List<Produto> getTodosProdutos() {
        List<Produto> produtos = new ArrayList<>();

        ClassPathResource resource = new ClassPathResource(CSV_FILE_PATH);

        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String linha;

            reader.readLine();

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {
                    String id = dados[0];
                    String nome = dados[1];
                    Double preco = Double.parseDouble(dados[2]);
                    String descricao = dados[3];
                    Integer estoque = Integer.parseInt(dados[4]);

                    Produto produto = new Produto(id, nome, preco, descricao, estoque);
                    produtos.add(produto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler o arquivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao converter número do CSV: " + e.getMessage());
        }
        return produtos;
    }
}