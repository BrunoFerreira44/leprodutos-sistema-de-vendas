package br.com.bruno.leprodutos;

import br.com.bruno.leprodutos.domain.venda.Venda;
import br.com.bruno.leprodutos.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeprodutosApplication implements CommandLineRunner {

	@Autowired
	private VendaRepository repository;

	@Autowired
	@Qualifier("venda1")
	private Venda venda1;

	@Autowired
	@Qualifier("venda2")
	private Venda venda2;

	@Autowired
	@Qualifier("venda3")
	private Venda venda3;

	@Autowired
	@Qualifier("venda4")
	private Venda venda4;

	@Autowired
	@Qualifier("venda5")
	private Venda venda5;

	@Autowired
	@Qualifier("venda6")
	private Venda venda6;

	@Autowired
	@Qualifier("venda7")
	private Venda venda7;

	@Autowired
	@Qualifier("venda8")
	private Venda venda8;

	@Autowired
	@Qualifier("venda9")
	private Venda venda9;

	@Autowired
	@Qualifier("venda10")
	private Venda venda10;

	@Autowired
	@Qualifier("venda11")
	private Venda venda11;

	@Autowired
	@Qualifier("venda12")
	private Venda venda12;

	@Autowired
	@Qualifier("venda13")
	private Venda venda13;

	@Autowired
	@Qualifier("venda14")
	private Venda venda14;

	@Autowired
	@Qualifier("venda15")
	private Venda venda15;

	@Autowired
	@Qualifier("venda16")
	private Venda venda16;

	@Autowired
	@Qualifier("venda17")
	private Venda venda17;

	@Autowired
	@Qualifier("venda18")
	private Venda venda18;

	@Autowired
	@Qualifier("venda19")
	private Venda venda19;

	@Autowired
	@Qualifier("venda20")
	private Venda venda20;

	@Autowired
	@Qualifier("venda21")
	private Venda venda21;

	@Autowired
	@Qualifier("venda22")
	private Venda venda22;


	public static void main(String[] args) {
		SpringApplication.run(LeprodutosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		repository.save(venda1);
//		repository.save(venda2);
//		repository.save(venda3);
//		repository.save(venda4);
//		repository.save(venda5);
//		repository.save(venda6);
//		repository.save(venda7);
//		repository.save(venda8);
//		repository.save(venda9);
//		repository.save(venda10);
//		repository.save(venda11);
//		repository.save(venda12);
//		repository.save(venda13);
//		repository.save(venda14);
//		repository.save(venda15);
//		repository.save(venda16);
//		repository.save(venda17);
//		repository.save(venda18);
//		repository.save(venda19);
//		repository.save(venda20);
//		repository.save(venda21);
//		repository.save(venda22);
	}
}
