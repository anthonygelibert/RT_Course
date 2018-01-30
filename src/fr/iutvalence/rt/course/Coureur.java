package fr.iutvalence.rt.course;

import java.util.Random;

/**
 * A runner (identified by its first and last names).
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public final class Coureur extends Thread {
    /** Current position for the next winner. */
    private static int    position = 1;
    /** Runner's last name. */
    private final  String nom;
    /** Runner's first name. */
    private final  String prenom;

    /** Create a new runner. */
    public Coureur(final String nom, final String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Display a specific message when a runner ends the race.<br>
     * <b>Warning! This method update <i>position</i> value.</b>
     *
     * @param c the runner ending its race
     */
    public static void affichePosition(final Coureur c) {
        System.out.println(c + " arrive en " + Coureur.position + "éme position... ");
        System.out.println("Pour " + c + "...");
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Les hip hip 	HOURRA!");
        Coureur.position++;
    }

    @Override
    public void run() {
        final Random random = new Random(System.currentTimeMillis());
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            }
            catch (final InterruptedException e) {
                /* NOTHING */
            }
            System.out.printf("%dm par %s%n", i * 10, this);
        }
        System.out.printf("%s a fini la course%n", this);
        Coureur.affichePosition(this);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.nom, this.prenom);
    }
}
