package com.pa4.pa4.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import com.pa4.pa4.model.Cliente;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class ClienteRepository {

    private List<Cliente> clientes;
    private int nextId;

    @PostConstruct
    public void cadastro() {

        Cliente p = new Cliente();

        p.setID_Cliente(1);
        p.setNome("Cleiton");
        p.setCPF("0010085");
        p.setRG("8885888");
        p.setRua("Rua 1");
        p.setNumero(1);
        p.setBairro("Centro");
        p.setComplemento(null);
        p.setCEP("777777");
        p.setCidade("Sorocaba");
        p.setUF("SP");
        p.setPais("Brasil");
        p.setTelefone("77777777");
        p.setCelular("977777777");
        p.setEmail("Cleiton@facens.br");

        clientes = new ArrayList<Cliente>();
        clientes.add(p);
        nextId = 2;

    }

    public List<Cliente> getAllClientes() {
        return clientes;
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

    public Cliente getClienteById(final int id) {
        for (final Cliente aux : clientes)
            if (aux.getID_Cliente() == id)
                return aux;

        return null;
    }

    public Cliente salvar(Cliente cliente) {
        cliente.setID_Cliente(nextId++);
        clientes.add(cliente);
        return cliente;
    }

    public void remove(Cliente cli) {
        clientes.remove(cli);
    }

    public Cliente update(Cliente cliente) {
        Cliente aux = getClienteById(cliente.getID_Cliente());

        if (aux != null) {
            aux.setRua(cliente.getRua());
            aux.setNumero(cliente.getNumero());
            aux.setBairro(cliente.getBairro());
            aux.setComplemento(cliente.getComplemento());
            aux.setCEP(cliente.getCEP());
            aux.setCidade(cliente.getCidade());
            aux.setUF(cliente.getUF());
            aux.setPais(cliente.getPais());
            aux.setTelefone(cliente.getTelefone());
            aux.setCelular(cliente.getCelular());
            aux.setEmail(cliente.getEmail());
        }

        return aux;
    }

}
