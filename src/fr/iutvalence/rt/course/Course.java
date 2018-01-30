package fr.iutvalence.rt.course;

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
    private final Classement          m_classement = new Classement();

    /** Add a new runner. */
    public void add(final String nom, final String prenom) {
        this.m_coureurs.add(new Coureur(nom, prenom, this));
    }

    /** Start the race. */
    public void gogogo() {
        for (final Coureur coureur : this.m_coureurs) {
            new Thread(coureur, coureur.toString()).start();
        }
    }

    /** Called by a runner ending the race. */
    protected void arrive(Coureur c) {
        this.m_classement.arrive(c);
    }

    /** Display the current ranking. */
    public void afficherClassement() {
        this.m_classement.affiche();
    }

    @Override
    public String toString() {
        return String.format("Course %s", Arrays.toString(this.m_coureurs.toArray()));
    }
}
