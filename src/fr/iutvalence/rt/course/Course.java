package fr.iutvalence.rt.course;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * A race.
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public final class Course {
    /** All the runners of the race. */
    private final Collection<Coureur> m_coureurs   = new LinkedList<>();
    /** Ranking of the race. */
    private final Classement          m_classement = new Classement();

    /** Race starting. */
    private long m_debutCourse;

    /** Add a new runner. */
    public void add(final String nom, final String prenom) {
        this.m_coureurs.add(new Coureur(nom, prenom, this));
    }

    /** Register the date of the race' starting. */
    public void debutCourse() {
        this.m_debutCourse = System.currentTimeMillis();
    }

    /** Start the race (and wait its end before returning). */
    public void gogogo() {
        final Collection<Thread> coureurs = new LinkedList<>();

        for (final Coureur coureur : this.m_coureurs) {
            final Thread coureurThread = new Thread(coureur, coureur.toString());
            coureurThread.start();
            coureurs.add(coureurThread);
        }

        for (final Thread coureur : coureurs) {
            try {
                coureur.join();
            }
            catch (final InterruptedException ignore) {
                /* NOTHING */
            }
        }
    }

    /** Display the current ranking. */
    public void afficherClassement() {
        this.m_classement.affiche();
    }

    /**
     * Save the ranking in a file.
     *
     * @param nomFichier filename
     *
     * @throws IOException can't write the file (I/O exception)
     */
    public void sauvegarderClassement(final String nomFichier) throws IOException {
        this.m_classement.sauvegarder(nomFichier);
    }

    /** Called by a runner ending the race. */
    void arrive(final Coureur coureur) {
        this.m_classement.arrive(coureur, this.tempsEcouleDepuisDebutCourse());
    }

    /** Get the current race duration. */
    private long tempsEcouleDepuisDebutCourse() {
        return System.currentTimeMillis() - this.m_debutCourse;
    }

    @Override
    public String toString() {
        return String.format("Course %s", Arrays.toString(this.m_coureurs.toArray()));
    }
}
