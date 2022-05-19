package me.nizart.bastien.carre;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LigneTest {
	private Ligne ligneTest;

	@BeforeEach
	void initLigneTest() {
		this.ligneTest = new Ligne(3, new int[] {2, 3, 4});
	}

	@AfterEach
	void deleteLigneTest() {
		Ligne ligneTest = null;
	}

	@Test
	@DisplayName("Vérifie la méthode getColonne")
	void getColonne(){
		assertEquals(3, ligneTest.getColonne(1));
	}

	@Test
	@DisplayName("Test de l'exception de getColonne")
	void getColonneException() {
		assertThrows(IndexOutOfBoundsException.class, () -> ligneTest.getColonne(188766));
	}

	@Test
	@DisplayName("Vérifie la méthode getValeurs")
	void getValeurs() {
		assertArrayEquals(new int[] {2, 3, 4}, ligneTest.getValeurs());
	}

	@Test
	@DisplayName("Vérifie la méthode getSommeLigne")
	void getSommeLigne() {
		assertEquals(9, ligneTest.getSommeLigne());
	}

	@Test
	@DisplayName("Vérifie la méthode toString")
	void toStringTest() {
		assertEquals(" 2 3 4", ligneTest.toString());
	}

	@Test
	@DisplayName("Vérifie la méthode possedeNombre (true)")
	void possedeNombreTrue() {
		assertEquals(true, ligneTest.possedeNombre(3));
	}

	@Test
	@DisplayName("Vérifie la méthode possedeNombre (false)")
	void possedeNombreFalse() {
		assertEquals(false, ligneTest.possedeNombre(33));
	}
}