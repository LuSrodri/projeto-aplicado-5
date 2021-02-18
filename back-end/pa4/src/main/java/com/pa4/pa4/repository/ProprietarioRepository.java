package com.pa4.pa4.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import com.pa4.pa4.model.Proprietario;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class ProprietarioRepository {

  private List<Proprietario> proprietarios;
  private int nextId;

  @PostConstruct
  public void cadastro() {

    Proprietario p = new Proprietario();

    p.setID_Proprietario(1);
    p.setNome("Fulano");
    p.setCPF("48810775899");
    p.setRG("56062802x");
    p.setCNPJ("12111000162");
    p.setIE("nem sei oq é");
    p.setRazao_Social("Pindamonhangaba");
    p.setRamo_Atividade("Picolé");
    p.setNome_Fantasia("pikoleca");
    p.setRua("Rua primeiro de janeiro");
    p.setNumero(15);
    p.setBairro("jd capão");
    p.setComplemento("NA");
    p.setCEP("18085354");
    p.setCidade("Soroitu");
    p.setUF("SP");
    p.setPais("Brasil");
    p.setTelefone("+551533299908");
    p.setCelular("+5515991576557");
    p.setEmail("facens@facens.br");
    p.setPorte("medio");
    p.setCNAE("Não tenho nem ideia dq seja isso");
    p.setFilial(2);

    Proprietario p2 = new Proprietario();
    p2.setID_Proprietario(2);
    p2.setNome("ciclano");
    p2.setCPF("44064757989");
    p2.setRG("520658423");
    p2.setCNPJ("13222000262");
    p2.setIE("nem sei oq é tambem");
    p2.setRazao_Social("itaquatecetuba");
    p2.setRamo_Atividade("geladinho");
    p2.setNome_Fantasia("ticolé");
    p2.setRua("Rua primeiro de março");
    p2.setNumero(10);
    p2.setBairro("jd redondo");
    p2.setComplemento("Do lado da praça");
    p2.setCEP("18085435");
    p2.setCidade("Soroitu");
    p2.setUF("SP");
    p2.setPais("Brasil");
    p2.setTelefone("+551533299908");
    p2.setCelular("+5515991576557");
    p2.setEmail("facens@facens.br");
    p2.setPorte("medio");
    p2.setCNAE("Não tenho nem ideia dq seja isso");
    p2.setFilial(2);

    proprietarios = new ArrayList<Proprietario>();
    proprietarios.add(p);
    proprietarios.add(p2);
    nextId = 3;
  }

  public List<Proprietario> getAllProprietarios() {
    return proprietarios;
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

  public Proprietario getProprietarioById( int id) {
    for (final Proprietario aux : proprietarios)
      if (aux.getID_Proprietario() == id)
        return aux;
    return null;
  }

  public Proprietario salvar(Proprietario proprietario) {

    proprietario.setID_Proprietario(nextId++);
    proprietarios.add(proprietario);
    return proprietario;
  }

  public void remove(Proprietario proprietario){
    proprietarios.remove(proprietario);
  }

  public Proprietario update(Proprietario proprietario){
    Proprietario aux = getProprietarioById(proprietario.getID_Proprietario());

    if(aux != null){
      aux.setRua(proprietario.getRua());
      aux.setNumero(proprietario.getNumero());
      aux.setBairro(proprietario.getBairro());
      aux.setComplemento(proprietario.getComplemento());
      aux.setCEP(proprietario.getCEP());
      aux.setCidade(proprietario.getCidade());
      aux.setUF(proprietario.getUF());
      aux.setPais(proprietario.getPais());
      aux.setTelefone(proprietario.getTelefone());
      aux.setCelular(proprietario.getCelular());
      aux.setEmail(proprietario.getCelular());
    }
    return aux;
  }


}
