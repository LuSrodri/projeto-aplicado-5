package com.pa4.pa4.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import com.pa4.pa4.model.Venda;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class VendaRepository {
    private List<Venda> vendas;
    private int nextId;

    @PostConstruct
    public void cadastro() {
  
      Venda p = new Venda();
  
      p.setId_Venda(1);
      p.setData("11/10/20");
      p.setId_Cliente(1);
      p.setId_Produto(1);
      
      vendas = new ArrayList<Venda>();
      vendas.add(p);
      nextId = 2;
    }
  
    public List<Venda> getAllVendas() {
      return vendas;
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
  
    public Venda getVendaById( int id) {
      for (final Venda aux : vendas)
        if (aux.getId_Venda() == id)
          return aux;
      return null;
    }
  
    public Venda salvar(Venda venda) {
  
      venda.setId_Venda(nextId++);
      vendas.add(venda);
      return venda;
    }
  
}

