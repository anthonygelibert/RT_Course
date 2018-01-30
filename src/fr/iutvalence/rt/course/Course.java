package fr.iutvalence.rt.course;

import java.util.Collection;
import java.util.LinkedList;

/**
 * A race.
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public class Course {
    /** All the runners of the race. */
    private Collection<Coureur> coureurs = new LinkedList<Coureur>();

    /** Add a new runner. */
    public void add(String nom, String prenom) {
        this.coureurs.add(new Coureur(nom, prenom));
    }

    /** Start the race. */
    public void gogogo() {
        for (Coureur c : this.coureurs) {
            c.start();
        }
    }
}
