package br.com.lucas.screenmatch;

import br.com.lucas.screenmatch.model.DadosSerie;
import br.com.lucas.screenmatch.service.ConsumoAPI;
import br.com.lucas.screenmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primeiro projeto spring sem web!");

		ConsumoAPI consumo = new ConsumoAPI();

		String json = consumo.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");

		System.out.println(json);

//		json  = consumo.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);

		ConverterDados conversor = new ConverterDados();
		DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie);
	}
}
