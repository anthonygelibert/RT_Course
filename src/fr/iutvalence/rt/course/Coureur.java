package fr.iutvalence.rt.course;

import java.util.Random;

public class Coureur extends Thread {

	private static int position = 1;
	private final String nom;
	private final String prenom;

	public Coureur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public static void affichePosition(Coureur c) {
		System.out.println(c + " arrive en " + Coureur.position + "éme position... ");
		System.out.println("Pour " + c + "...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Les hip hip 	HOURRA!");
		Coureur.position++;
	}

	@Override
	public void run() {
		Random random = new Random(System.currentTimeMillis());
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000 + random.nextInt(1000));
			} catch (InterruptedException e) {
				/* NOTHING */
			}
			System.out.println(i * 10 + "m par " + this);
		}
		System.out.println(this + " a fini la course");
		Coureur.affichePosition(this);
	}

	@Override
	public String toString() {
		return this.nom + " " + this.prenom;
	}
}
