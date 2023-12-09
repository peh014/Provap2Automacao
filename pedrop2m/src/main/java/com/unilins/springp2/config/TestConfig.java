package com.unilins.springp2.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.unilins.springp2.entities.*;
import com.unilins.springp2.repositories.*;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private  ClienteRepository clienteRep;
	
	@Autowired
	private CarroRepository carroRep;
	
	@Autowired
	private AluguelRepository aluguelRepository; 
	
	public  void run(String... args) throws Exception{
		// TODO Auto-generated method stub
		Cliente cliente1 = new Cliente(null,"pedro henrique", "123.456.789-00", "(14) 12345-4321", "123456");
		Cliente cliente2 = new Cliente(null,"andre xavier", "354.454.651-00", "(14) 99999-8888", "123456");
		Cliente cliente3 = new Cliente(null,"ana oliveira", "231.242.345-11", "(14) 77774-77777", "123456");
		Cliente cliente4 = new Cliente(null,"bia santos", "654.666.777-88", "(14) 33333-2222", "123456");
		Cliente cliente5 = new Cliente(null,"igor ferreira", "999.888.777-66", "(14) 11111-4444", "123456");
		clienteRep.saveAll(Arrays.asList(cliente1,cliente2,cliente3,cliente4,cliente5));

		Carro carro1 = new Carro(null, "Toyota", "Corolla", "ABC1234", (float) 150.0);
		Carro carro2 = new Carro(null, "Honda", "Civic", "DEF5678", (float) 170.0);
		Carro carro3 = new Carro(null, "Chevrolet", "Onix", "GHI9012", (float) 130.0);
		Carro carro4 = new Carro(null, "Ford", "Focus", "JKL3456", (float) 160.0);
		Carro carro5 = new Carro(null, "Volkswagen", "Gol", "MNO7890", (float) 140.0);
		carroRep.saveAll(Arrays.asList(carro1,carro2,carro3,carro4,carro5));

		Aluguel aluguel1 = new Aluguel(carro1,cliente1,  "23/11/2023","15/07/2023", (float) 130.5);
		Aluguel aluguel2 = new Aluguel(carro4,cliente2, "04/12/2023","15/08/2023", (float) 140.5);
		Aluguel aluguel3 = new Aluguel(carro3, cliente5, "01/12/2023","15/09/2023",(float) 150);
		aluguelRepository.saveAll(Arrays.asList(aluguel1, aluguel2,aluguel3));


	}
}