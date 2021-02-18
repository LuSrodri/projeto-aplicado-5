package com.pa4.pa4.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import com.pa4.pa4.model.Produto;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class ProdutoRepository {
    
    private List<Produto> produtos;
    private int nextId;

    @PostConstruct
    public void cadastro()
    {

        Produto p = new Produto();

        p.setID_Produto(1);
        p.setNome("Fone");
        p.setPreco_Custo(10.00);
        p.setPreco_Venda(30.00);
        p.setCategoria("Eletronico");
        p.setMarca("Ching Ling");
        p.setLote(18500);
        p.setOrigem("China");
        p.setAltura(0.0);
        p.setLargura(0.0);
        p.setComprimento(1.0);
        p.setPeso(0.05);
        p.setValidade(null);
        p.setID_FornecedorP(1);

        produtos = new ArrayList<Produto>();
        produtos.add(p);
        nextId=2;

    }
    
    public List<Produto> getAllProdutos(){
        return produtos;
    }

    //Liberação de cors global
    @Configuration
    @EnableWebMvc
    public class WebConfig extends WebMvcConfigurerAdapter {

      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
      }
    }

    public Produto getProdutoById( int id){
        for (final Produto aux : produtos) 
            if(aux.getID_Produto() == id)
                return aux;

        return null;
    }

	public Produto salvar(Produto produto) {
        produto.setID_Produto(nextId++);
        produtos.add(produto);
        return produto;
    }
    
    public void remove(Produto produto){
        produtos.remove(produto);
    }

    public Produto update(Produto produto){
        Produto aux = getProdutoById(produto.getID_Produto());
        if(aux != null){
            aux.setPreco_Custo(produto.getPreco_Custo());
            aux.setPreco_Venda(produto.getPreco_Venda());
        }
        return aux;
    }
}
