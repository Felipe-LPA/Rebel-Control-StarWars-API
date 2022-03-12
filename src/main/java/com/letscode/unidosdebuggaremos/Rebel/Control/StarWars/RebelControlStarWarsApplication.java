package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.BancoRebel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RebelControlStarWarsApplication {
	public static BancoRebel bancoRebel = new BancoRebel();
	public static void main(String[] args) {
		SpringApplication.run(RebelControlStarWarsApplication.class, args);
	}

}
