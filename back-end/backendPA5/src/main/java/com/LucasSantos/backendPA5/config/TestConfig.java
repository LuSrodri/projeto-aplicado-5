package com.LucasSantos.backendPA5.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.LucasSantos.backendPA5.entities.Cliente;
import com.LucasSantos.backendPA5.entities.Empresa;
import com.LucasSantos.backendPA5.entities.Fornecedor;
import com.LucasSantos.backendPA5.entities.Funcionario;
import com.LucasSantos.backendPA5.entities.Pedido;
import com.LucasSantos.backendPA5.entities.Produto;
import com.LucasSantos.backendPA5.repositories.ClienteRepository;
import com.LucasSantos.backendPA5.repositories.EmpresaRepository;
import com.LucasSantos.backendPA5.repositories.FornecedorRepository;
import com.LucasSantos.backendPA5.repositories.FuncionarioRepository;
import com.LucasSantos.backendPA5.repositories.PedidoRepository;
import com.LucasSantos.backendPA5.repositories.ProdutoRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Fornecedor f1 = new Fornecedor(null, "Nike", "00111000/0001-00", "Loja de Roupa Esportiva Nike", "Venda de Roupas e calçados", "Rua Aldaberto Ferreira", 1001, "Bairro Aparecida", "Segundo Andar, Sala 88", "11180-888", "Itapeva", "SP", "Brasil", "1549999999", "15989998999", "atendimento@nike.com");
		Fornecedor f2 = new Fornecedor(null, "Adidas", "00111222/0001-00", "Loja de Roupa Esportiva Adidas", "Venda de Roupas e calçados", "Rua Aldaberto Ferreira", 1001, "Bairro Aparecida", "Segundo Andar, Sala 98", "11180-888", "Itapeva", "SP", "Brasil", "1549998888", "15988889999", "atendimento@adidas.com");

		Produto p1 = new Produto(null, "Tenis Nike One", 45.5, 399.99, "Calçados", "Nike", 8899701, "Zona franca de Manaus", 0.1, 0.05, 0.3, 0.5, null, f1);
		Produto p2 = new Produto(null, "Tenis Nike Jordan", 82.5, 799.99, "Calçados", "Nike", 1198707, "EUA", 0.1, 0.05, 0.3, 0.5, null, f1);
		Produto p3 = new Produto(null, "Tenis Adidas Falcon", 15.5, 199.99, "Calçados", "Adidas", 4799701, "Zona franca de Manaus", 0.1, 0.05, 0.3, 0.5, null, f2);
		Produto p4 = new Produto(null, "Tenis Adidas ZX", 35.5, 599.99, "Calçados", "Adidas", 5799801, "China", 0.1, 0.05, 0.3, 0.5, null, f2);
		
		fornecedorRepository.saveAll(Arrays.asList(f1,f2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		
		f1.getProdutos().add(p1);
		f1.getProdutos().add(p2);
		f2.getProdutos().add(p3);
		f2.getProdutos().add(p4);
		
		fornecedorRepository.saveAll(Arrays.asList(f1,f2));
		
		Empresa em1 = new Empresa(null, "Lojinha da Maria", "00111000/0001-00", "127774448", "Loja de calçados Maria", "Venda de Roupa e Calçados", "Lojinha da Maria", "Rua Alfredo Lipe", 101, "Centro", null, "18120-000", "Aluminio", "SP", "Brasil", "1149998888", "11999998888", "lojinhamaria@gmail.com", "Micro-empresa", "7888111", "Matriz");
	
		empresaRepository.save(em1);
		
		Funcionario fu1 = new Funcionario(null, "Maria Isabela", "11100010122", "1010010022", "Rua Aparecida", 8404, "Aparecida", null, "18122-001", "Sorocaba", "SP", "Brasil", "1544884444", "15988889999", "mariaIsa@gmail.com", LocalDate.parse("2021-01-10"), 1800.00, em1);
		Funcionario fu2 = new Funcionario(null, "Ricardo Oliveira", "22200010122", "2020010022", "Avenida Tiradentes", 1455, "Centro", null, "18121-001", "São Roque", "SP", "Brasil", "1544444444", "15977779999", "ricardo@gmail.com", LocalDate.parse("2021-01-15"), 1800.00, em1);
		Funcionario fu3 = new Funcionario(null, "Ana Clara", "11111110122", "1110010022", "Avenida Piracicaba", 777, "Vila Nova", null, "18121-001", "São Roque", "SP", "Brasil", "1544448888", "15999999999", "ana@gmail.com", LocalDate.parse("2021-01-06"), 1800.00, em1);
	
		funcionarioRepository.saveAll(Arrays.asList(fu1,fu2,fu3));
		
		em1.getFuncionarios().add(fu1);
		em1.getFuncionarios().add(fu2);
		em1.getFuncionarios().add(fu3);
		
		empresaRepository.save(em1);
		
		Cliente c1 = new Cliente(null, "Vitoria", null, null, null, 0, null, null, null, null, null, null, null, null, null, em1);
		Cliente c2 = new Cliente(null, "Fernando", null, null, null, 0, null, null, null, null, null, null, null, null, null, em1);
		Cliente c3 = new Cliente(null, "Jose", null, null, null, 0, null, null, null, null, null, null, null, null, null, em1);
		Cliente c4 = new Cliente(null, "Claudia", null, null, null, 0, null, null, null, null, null, null, null, null, null, em1);
		Cliente c5 = new Cliente(null, "Marcia", null, null, null, 0, null, null, null, null, null, null, null, null, null, em1);
		
		clienteRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
		
		em1.getClientes().add(c1);
		em1.getClientes().add(c2);
		em1.getClientes().add(c3);
		em1.getClientes().add(c4);
		em1.getClientes().add(c5);
		
		empresaRepository.save(em1);
		
		Pedido pe1 = new Pedido(null, LocalDate.parse("2021-03-01"), c1, fu3);
		Pedido pe2 = new Pedido(null, LocalDate.parse("2021-02-20"), c2, fu1);
		pe1.getProdutos().add(p1);
		pe1.getProdutos().add(p2);
		pe2.getProdutos().add(p3);
		pe2.getProdutos().add(p4);
		
		pedidoRepository.saveAll(Arrays.asList(pe1,pe2));
		
		fu1.getPedidos().add(pe2);
		fu3.getPedidos().add(pe1);
		
		funcionarioRepository.saveAll(Arrays.asList(fu1,fu3));
		
		c1.getPedidos().add(pe1);
		c2.getPedidos().add(pe2);
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
		
	}
}
