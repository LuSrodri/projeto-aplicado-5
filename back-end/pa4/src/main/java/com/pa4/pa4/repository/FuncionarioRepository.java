package com.pa4.pa4.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import com.pa4.pa4.model.Funcionario;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class FuncionarioRepository {

    private List<Funcionario> funcionarios;
    private int nextId;

    @PostConstruct
    public void cadastro() {

        Funcionario p = new Funcionario();

        p.setID_Funcionario(1);
        p.setNome("Fulano");
        p.setCPF("1000");
        p.setRG("885");
        p.setRua("Rua 1");
        p.setNumero(1);
        p.setBairro("Centro");
        p.setComplemento("Perto da praça");
        p.setCEP("90000");
        p.setCidade("Mairinque");
        p.setUF("SP");
        p.setPais("Brasil");
        p.setTelefone("33333333");
        p.setCelular("933333333");
        p.setEmail("Fulano@facens.br");
        p.setAdmissao("2019");
        p.setSalario(1000.0);

        funcionarios = new ArrayList<Funcionario>();
        funcionarios.add(p);
        nextId = 2;

    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarios;
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

    public Funcionario getFuncionarioById( int id) {
        for (final Funcionario aux : funcionarios)
            if (aux.getID_Funcionario() == id)
                return aux;

        return null;
    }

    public Funcionario salvar(Funcionario funcionario) {
        funcionario.setID_Funcionario(nextId++);
        funcionarios.add(funcionario);
        return funcionario;
    }

    public void remove(Funcionario func) {
        funcionarios.remove(func);
    }

    public Funcionario update(Funcionario funcionario) {
        Funcionario aux = getFuncionarioById(funcionario.getID_Funcionario());

        if (aux != null) {
            aux.setRua(funcionario.getRua());
            aux.setNumero(funcionario.getNumero());
            aux.setBairro(funcionario.getBairro());
            aux.setComplemento(funcionario.getComplemento());
            aux.setCEP(funcionario.getCEP());
            aux.setCidade(funcionario.getCidade());
            aux.setUF(funcionario.getUF());
            aux.setPais(funcionario.getPais());
            aux.setTelefone(funcionario.getTelefone());
            aux.setCelular(funcionario.getCelular());
            aux.setEmail(funcionario.getEmail());
            aux.setSalario(funcionario.getSalario());
        }

        return aux;
    }
}
