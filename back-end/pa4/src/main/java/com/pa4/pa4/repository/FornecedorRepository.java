package com.pa4.pa4.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import com.pa4.pa4.model.Fornecedor;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class FornecedorRepository {

    private List<Fornecedor> fornecedores;
    private int nextId;

    @PostConstruct
    public void cadastro() {

        Fornecedor p = new Fornecedor();

        p.setID_Fornecedor(1);
        p.setNome("Fulano");
        p.setCNPJ("5000");
        p.setRazao_Social("Lindas Roupas");
        p.setRamo_Atividade("Roupas");
        p.setRua("Rua 1");
        p.setNumero(1);
        p.setBairro("Centro");
        p.setComplemento("Ao lado do shoping");
        p.setCEP("5558888");
        p.setCidade("Araras");
        p.setUF("SP");
        p.setPais("Brasil");
        p.setTelefone("88888888");
        p.setCelular("988888888");
        p.setEmail("fulano1@facens.br");

        fornecedores = new ArrayList<Fornecedor>();
        fornecedores.add(p);
        nextId = 2;
    }

    public List<Fornecedor> getAllFornecedores() {
        return fornecedores;
    }

    // Liberação de cors global
    @Configuration
    @EnableWebMvc
    public class WebConfig extends WebMvcConfigurerAdapter {

      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
      }
    }
    public Fornecedor getFornecedorById(int id) {
        for (final Fornecedor aux : fornecedores)
            if (aux.getID_Fornecedor() == id)
                return aux;

        return null;
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        fornecedor.setID_Fornecedor(nextId++);
        fornecedores.add(fornecedor);
        return fornecedor;
    }

    public void remove(Fornecedor fornec) {
        fornecedores.remove(fornec);
    }

    public Fornecedor update(Fornecedor fornecedor) {
        Fornecedor aux = getFornecedorById(fornecedor.getID_Fornecedor());

        if (aux != null) {
            aux.setRua(fornecedor.getRua());
            aux.setNumero(fornecedor.getNumero());
            aux.setBairro(fornecedor.getBairro());
            aux.setComplemento(fornecedor.getComplemento());
            aux.setCEP(fornecedor.getCEP());
            aux.setCidade(fornecedor.getCidade());
            aux.setUF(fornecedor.getUF());
            aux.setPais(fornecedor.getPais());
            aux.setTelefone(fornecedor.getTelefone());
            aux.setCelular(fornecedor.getCelular());
            aux.setEmail(fornecedor.getEmail());
        }

        return aux;
    }

}
