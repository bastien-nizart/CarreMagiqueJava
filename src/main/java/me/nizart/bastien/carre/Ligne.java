package me.nizart.bastien.carre;

/**
 * Classe représentant un objet de type ligne.
 * Une ligne est ici un ensemble de nombre.
 *
 * @author bastien
 * @version 1
 */
public class Ligne {
	/**
	 * Listes des valeurs de la ligne
	 */
	private int[] valeurs;
	/**
	 * Nombre d'éléments dans la ligne
	 */
	private int dimension;

	/**
	 * Constructeur principal d'une ligne.
	 * @param dimension taille de la ligne.
	 * @param valeurs listes des nombres à ajouter à la ligne.
	 */
	Ligne(int dimension, int[] valeurs) {
		this.dimension = dimension;
		this.valeurs = new int[dimension];

		for (int i=0; i <dimension; i++) {
			this.valeurs[i] = valeurs[i];
		}
	}

	/**
	 * Simple getteur pour les valeurs de la ligne.
	 * @return int[] valeurs
	 */
	public int[] getValeurs() {
		return this.valeurs;
	}

	/**
	 * Cette méthode va calculer la somme des termes de la ligne.
	 * @return int somme de la ligne
	 */
	public int getSommeLigne() {
		int somme = 0;
		for (int i=0; i < dimension; i++) {
			somme += this.valeurs[i];
		}

		return somme;
	}

	/**
	 * Cette méthode va renvoyer la valeur du nombre de la colonne id.
	 * Ou lever une exception si id dépasse la taille de la ligne.
	 * @param id La colonne désirée.
	 * @return int La valeur de la colonne.
	 * @throws IndexOutOfBoundsException si l'id dépasse la taille de la ligne.
	 */
	public int getColonne(int id) throws IndexOutOfBoundsException {
		if (id >= this.dimension) {
			throw new IndexOutOfBoundsException();
		}

		return valeurs[id];
	}

	/**
	 * Cette méthode va renvoyer la représentation graphique d'une ligne.
	 * @return String représentation graphique.
	 */
	@Override
	public String toString() {
		String chaine = "";
		for (int valeur : this.valeurs) {
			chaine = chaine + " " + valeur;
		}

		return chaine;
	}

	/**
	 * Cette méthode va vérifier qu'il existe une occurrence de nb dans la ligne.
	 * @param nb nombre à chercher.
	 * @return boolean si le nombre existe ou non.
	 */
	public boolean possedeNombre(int nb) {
		for (int i=0; i < dimension; i++) {
			if (valeurs[i] == nb) {
				return true;
			}
		}

		return false;
	}
}
