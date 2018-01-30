package fr.iutvalence.rt.course;

import java.util.Random;

/**
 * A runner (identified by its first and last names).
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public final class Coureur implements Runnable {
    /** Runner's last name. */
    private final String m_nom;
    /** Runner's first name. */
    private final String m_prenom;
    /** Race in which the runner is registered. */
    private final Course m_course;

    /** Create a new runner. */
    public Coureur(final String nom, final String prenom, final Course course) {
        this.m_nom = nom;
        this.m_prenom = prenom;
        this.m_course = course;
    }

    @Override
    public void run() {
        final Random random = new Random(System.currentTimeMillis());
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            }
            catch (final InterruptedException ignore) {
                /* NOTHING */
            }
            System.out.printf("%dm par %s%n", i * 10, this);
        }
        System.out.printf("%s a fini la course%n", this);
        this.m_course.arrive(this);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.m_nom, this.m_prenom);
    }
}
