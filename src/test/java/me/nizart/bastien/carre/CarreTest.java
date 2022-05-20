package me.nizart.bastien.carre;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarreTest {
	private Carre carreTest;

	@BeforeEach
	void initLigneTest() {
		Ligne ligne1 = new Ligne(3, new int[] {8, 1, 6});
		Ligne ligne2 = new Ligne(3, new int[] {3, 5, 7});
		Ligne ligne3 = new Ligne(3, new int[] {4, 9, 2});

		this.carreTest = new Carre(3, new Ligne[] {ligne1, ligne2, ligne3});
	}

	@AfterEach
	void deleteLigneTest() {
		Carre carreTest = null;
	}

	@Test
	@DisplayName("Test affichage graphique carré")
	void affichage() {
		carreTest.afficher();
	}

	@Test
	@DisplayName("Test somme première diagonale")
	void testPremiereDiagonale() {
		int[] sommes = carreTest.getSommesDiagonales();

		assertEquals(sommes[0], 15);
	}

	@Test
	@DisplayName("Test trouver constante magique")
	void testTrouverConstanteMagique() {
		assertEquals(15, Carre.trouverConstanteMagique(3));
		assertEquals(111, Carre.trouverConstanteMagique(6));
	}

	@Test
	@DisplayName("Test que le carré est bien magique")
	void estMagique() {
		assertEquals(true, carreTest.estMagique());
	}

	@Test
	@DisplayName("Test la méthode chiffreUnique")
	void chiffreUnique() {
		assertEquals(true, carreTest.chiffreUnique());
	}
}