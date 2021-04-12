package br.edu.infnet.callcenter;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.infnet.callcenter.domain.Chamado;
import br.edu.infnet.callcenter.domain.Cliente;
import br.edu.infnet.callcenter.domain.Defeito;
import br.edu.infnet.callcenter.domain.Produto;
import br.edu.infnet.callcenter.domain.Solucao;
import br.edu.infnet.callcenter.repositories.ChamadoRepository;
import br.edu.infnet.callcenter.repositories.ClienteRepository;
import br.edu.infnet.callcenter.repositories.DefeitoRepository;
import br.edu.infnet.callcenter.repositories.ProdutoRepository;
import br.edu.infnet.callcenter.repositories.SolucaoRepository;

@SpringBootApplication
public class CallcenterApiApplication implements CommandLineRunner {

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private DefeitoRepository defeitoRepository;
	
	@Autowired
	private SolucaoRepository solucaoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CallcenterApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Populando banco para testes
		Defeito df1 = new Defeito(null,"Pc não está ligando","Ao realizar o procedimento de ligar o pc, o pc não dá sinal de vida");
		Solucao sl1 = new Solucao(null,"Ligar na tomada","O pc precisa de energia para funcionar, por isso deve ser plugado na tomada.");
		Chamado ch1 = new Chamado(df1,sl1);
		
		Cliente cl1 = new Cliente("12332112321", "Fábio Nazário", "fabio.nazario@gmail.com", "22934285");
		Cliente cl2 = new Cliente("52421144477", "Rogéria Leandro", "rogeria.leandro@gmail.com", "99998874");
		
	
		Produto pd1 = new Produto(null, new Date(), "1111122221111222", "Notebook", cl1);
		
		ch1.setDefeito(df1);
		ch1.setSolucao(sl1);
		ch1.setProduto(pd1);
		
		pd1.setCliente(cl1);
		
		
		df1.getChamados().addAll(Arrays.asList(ch1));
		sl1.getChamados().addAll(Arrays.asList(ch1));
		pd1.getChamados().addAll(Arrays.asList(ch1));
		cl1.getProdutos().addAll(Arrays.asList(pd1));
		
		clienteRepository.saveAll(Arrays.asList(cl1,cl2));	
		produtoRepository.saveAll(Arrays.asList(pd1));
		solucaoRepository.saveAll(Arrays.asList(sl1));
		defeitoRepository.saveAll(Arrays.asList(df1));		
		chamadoRepository.saveAll(Arrays.asList(ch1));
	}

	
	
}
