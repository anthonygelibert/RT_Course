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
    private final Map<Integer, Coureur> m_classement = new HashMap<>(20);

    /** Current position for the next winner. */
    private int m_position = 1;

    /** Add the given runner to the ranking. */
    public synchronized void arrive(final Coureur coureur) {
        this.m_classement.put(this.m_position, coureur);
        this.m_position++;
    }

    /** Display the current ranking. */
    public void affiche() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        final StringBuilder resultat = new StringBuilder();
        resultat.append(" -------------------------------------------\n");
        resultat.append(String.format("| Classement de la course (%d participants) |\n", this.m_classement.size()));
        resultat.append(" -------------------------------------------\n\n");
        for (final Map.Entry<Integer, Coureur> position : this.m_classement.entrySet()) {
            resultat.append(String.format("%d. %s\n", position.getKey(), position.getValue()));
        }
        return resultat.toString();
    }
}
