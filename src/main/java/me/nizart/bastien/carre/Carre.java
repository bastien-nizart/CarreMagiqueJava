package me.nizart.bastien.carre;

/**
 * Classe représentant un objet de type carré.
 * Un carré est ici un ensemble de ligne.
 * Il possède autant de ligne, qu'il existe d'occurrence à ces lignes.
 *
 * @author bastien
 * @version 1
 */
public class Carre {
	/**
	 * dimension du carré
	 */
	private int dimension;
	/**
	 * listes des lignes à ajouter au carré
	 */
	private Ligne[] lignes;

	/**
	 * Constructeur principal du carré.
	 * @param dimension dimension du carré
	 * @param entrees listes des lignes à ajouter au carré
	 */
	Carre(int dimension, Ligne[] entrees) {
		this.dimension = dimension;
		this.lignes = new Ligne[dimension];

		for (int ligne=0; ligne<dimension; ligne++) {
			this.lignes[ligne] = entrees[ligne];
		}
	}

	/**
	 * Cette méthode va vérifier que le carré possède bien tous les nombres voulus.
	 * Soit les nombres de 1 à n^2.
	 * @return boolean condition remplie
	 */
	public boolean chiffreUnique() {
		for (int i=1; i<=dimension*dimension; i++) {
			boolean test = false;
			for (Ligne ligne : lignes) {
				if (ligne.possedeNombre(i)) {
					test = true;
				}
			}

			if (!test) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Cette méthode va renvoyer la somme des termes d'une colonne.
	 * Colonne donnée en entrée.
	 * @param colonne id de la colonne à sélectionner.
	 * @return int somme de la colonne spécifiée
	 */
	public int getSommeColonne(int colonne){
		int somme = 0;
		for (Ligne ligne : this.lignes) {
			somme += ligne.getColonne(colonne);
		}

		return somme;
	}

	/**
	 * Cette méthode va renvoyer la somme des termes des deux diagonales.
	 * Sous la forme d'un tableau d'entier.
	 * @return int[] sommes des diagonales
	 */
	public int[] getSommesDiagonales(){
		int[] sommes = new int[2];
		sommes[0] = 0;
		sommes[1] = 0;

		// Première diagnole
		for (int i = 0; i < dimension; i++) {
			sommes[0] += lignes[i].getColonne(i);
		}

		// Seconde diagnole
		for (int i = 0; i < dimension; i++) {
			sommes[1] += lignes[i].getColonne(dimension-1-i);
		}

		return sommes;
	}

	/**
	 * Cette méthode va afficher graphiquement le carré.
	 */
	public void afficher() {
		for (Ligne ligne : this.lignes) {
			System.out.println(ligne.toString());
		}
	}

	/**
	 * Cette méthode permet de trouver la "constante magique".
	 * À partir de la formule ci-dessous.
	 * (n(n*n-1))/2
	 * @param dimension nombre de chiffres dans une ligne.
	 * @return int constante magique.
	 */
	public static int trouverConstanteMagique(int dimension) {
		return (dimension*(dimension*dimension+1))/2;
	}

	/**
	 * Cette méthode va vérifier si notre carré est magique.
	 * Avec l'aide des deux conditions suivantes :
	 * - sommes(diagonale) = sommes(colonne) = sommes(ligne)
	 * - il existe dans ce carré tous les nombres de 1 à n*n
	 *
	 * @return boolean la vérification de la condition
	 */
	public boolean estMagique() {
		int constanteMagique = Carre.trouverConstanteMagique(this.dimension);

		if (!this.chiffreUnique()) {
			return false;
		}

		// Diagonales
		if ((getSommesDiagonales()[0] != constanteMagique) || (getSommesDiagonales()[1] != constanteMagique)) {
			return false;
		}

		// Colonnes
		for (int i = 0; i < dimension; i++) {
			if (this.getSommeColonne(i) != constanteMagique) {
				return false;
			}
		}

		// Lignes
		for (int i = 0; i < dimension; i++) {
			if (this.lignes[i].getSommeLigne() != constanteMagique) {
				return false;
			}
		}

		return true;
	}
}
