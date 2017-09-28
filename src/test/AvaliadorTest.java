package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class AvaliadorTest {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("PlayStation 3");
		
		leilao.propoe(new Lance(maria, 250.00));
		leilao.propoe(new Lance(joao, 300.00));
		leilao.propoe(new Lance(jose, 400.00));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(400.00, leiloeiro.getMaiorDeTodos(), 0.00001);
		assertEquals(250.00, leiloeiro.getMenorDeTodos(), 0.00001);
	}
	
	@Test
	public void deveRetornarAMediaDosLances(){
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("PlayStation 3");
		
		leilao.propoe(new Lance(joao, 300.00));
		leilao.propoe(new Lance(jose, 400.00));
		leilao.propoe(new Lance(maria, 500.00));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(400.00, leiloeiro.getMedia(), 0.00001);
	}

}
