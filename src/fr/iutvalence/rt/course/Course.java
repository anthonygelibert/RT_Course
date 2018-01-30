package fr.iutvalence.rt.course;

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
    private final Collection<Coureur> m_coureurs = new LinkedList<>();

    /** Add a new runner. */
    public void add(final String nom, final String prenom) {
        this.m_coureurs.add(new Coureur(nom, prenom));
    }

    /** Start the race. */
    public void gogogo() {
        for (final Coureur coureur : this.m_coureurs) {
            coureur.start();
        }
    }
}
