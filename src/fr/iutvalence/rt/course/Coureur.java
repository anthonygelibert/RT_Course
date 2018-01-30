package fr.iutvalence.rt.course;

import java.util.Random;

/**
 * A runner (identified by its first and last names).
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public final class Coureur implements Runnable {
    /** Current position for the next winner. */
    private static int s_position = 1;

    /** Runner's last name. */
    private final String m_nom;
    /** Runner's first name. */
    private final String m_prenom;

    /** Create a new runner. */
    public Coureur(final String nom, final String prenom) {
        this.m_nom = nom;
        this.m_prenom = prenom;
    }

    /**
     * Display a specific message when a runner ends the race.<br>
     * <b>Warning! This method update <i>position</i> value.</b>
     *
     * @param coureur the runner ending its race
     */
    public static void affichePosition(final Coureur coureur) {
        System.out.printf("%s arrive en %déme position... %n", coureur, Coureur.s_position);
        System.out.printf("Pour %s...%n", coureur);
        try { Thread.sleep(500); }
        catch (final InterruptedException e) { /* NOTHING */ }
        System.out.println("Les hip hip 	HOURRA!");
        Coureur.s_position++;
    }

    @Override
    public void run() {
        final Random random = new Random(System.currentTimeMillis());
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            }
            catch (final InterruptedException ignore) { /* NOTHING */ }
            System.out.printf("%dm par %s%n", i * 10, this);
        }
        System.out.printf("%s a fini la course%n", this);
        Coureur.affichePosition(this);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.m_nom, this.m_prenom);
    }
}
