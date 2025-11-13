package atv7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CroosOrigin
@SpringBootApplication
@RestController
public class api {

    public static void main(String[] args) {
        SpringApplication.run(api.class, args);
    }

    @GetMapping("/produtos")
    public List<Produto> produtos(){
        List<Produto> produtos = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("produtos.csv"))){
            String linha =  reader.readLine();

            while((linha = reader.readLine()) != null){
                String colunas[] = linha.split(",");

                String id = colunas[0];
                String nome = colunas[1];
                double preco = Double.parseDouble(colunas[2]);
                String descricao = colunas[3];
                int estoque = Integer.parseInt(colunas[4]);

                produtos.add(new Produto(id, nome, preco, descricao, estoque));
            }


        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return produtos;
    }
}
