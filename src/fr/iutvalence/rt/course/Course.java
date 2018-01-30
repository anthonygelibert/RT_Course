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
    private final Collection<Coureur> coureurs = new LinkedList<>();

    /** Add a new runner. */
    public void add(final String nom, final String prenom) {
        this.coureurs.add(new Coureur(nom, prenom));
    }

    /** Start the race. */
    public void gogogo() {
        for (Coureur c : this.coureurs) {
            c.start();
        }
    }
}
