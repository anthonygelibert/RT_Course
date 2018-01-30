package fr.iutvalence.rt.course;

import java.util.Collection;
import java.util.LinkedList;

public class Course {
	private Collection<Coureur> coureurs = new LinkedList<Coureur>();

	public void add(String nom, String prenom) {
		this.coureurs.add(new Coureur(nom, prenom));
	}

	public void gogogo() {
		for (Coureur c : this.coureurs) {
			c.start();
		}
	}
}
