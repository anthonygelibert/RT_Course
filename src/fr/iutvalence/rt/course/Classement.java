package fr.iutvalence.rt.course;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    private final Map<Integer, CoupleCoureurTemps> m_classement = new HashMap<>(20);

    /** Current position for the next winner. */
    private int m_position = 1;

    /** Add the given runner to the ranking. */
    public synchronized void arrive(final Coureur coureur, final long tempsCourse) {
        this.m_classement.put(this.m_position, new CoupleCoureurTemps(coureur, tempsCourse));
        this.m_position++;
    }

    /** Display the current ranking. */
    public void affiche() {
        System.out.println(this);
    }

    /**
     * Dump the ranking in a file.
     *
     * @param filename name of the written file
     */
    public void sauvegarder(final String filename) throws IOException {
        try (final PrintWriter pw = new PrintWriter(new FileWriter(filename), true)) {
            pw.write(this.toString());
        }
    }

    @Override
    public String toString() {
        final StringBuilder resultat = new StringBuilder();
        resultat.append(" -------------------------------------------\n");
        resultat.append(String.format("| Classement de la course (%d participants) |\n", this.m_classement.size()));
        resultat.append(" -------------------------------------------\n\n");
        for (final Map.Entry<Integer, CoupleCoureurTemps> position : this.m_classement.entrySet()) {
            resultat.append(String.format("%d. %s\n", position.getKey(), position.getValue()));
        }
        return resultat.toString();
    }
}
