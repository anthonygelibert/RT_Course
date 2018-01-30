package fr.iutvalence.rt.course;

import java.util.HashMap;
import java.util.Map;

/**
 * Ranking of the race.
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public final class Classement {
    /** Ranking of the race (position -> runner). */
    private final Map<Integer, Coureur> m_classement = new HashMap<>();
    /** Current position for the next winner. */
    private       int                   m_position   = 1;

    /** Add the given runner to the ranking. */
    public synchronized void arrive(final Coureur coureur) {
        this.m_classement.put(this.m_position, coureur);
        this.m_position++;
    }

    public void affiche() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String resultat = "Classement de la course (" + this.m_classement.size() + " participant(s))\n";
        resultat += "------------------------------------------------------\n\n";
        for (Map.Entry<Integer, Coureur> position : this.m_classement.entrySet()) {
            resultat += position.getKey() + ". " + position.getValue() + "\n";
        }
        return resultat;
    }
}
