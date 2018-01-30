package fr.iutvalence.rt.course;

import java.time.Duration;

/**
 * Tuple (runner, duration of the race).
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public final class CoupleCoureurTemps {
    /** Runner. */
    private final Coureur m_coureur;
    /** Duration of the race. */
    private final long    m_tempsCourse;

    /** Create a new tuple. */
    public CoupleCoureurTemps(final Coureur coureur, final long tempsCourse) {
        this.m_coureur = coureur;
        this.m_tempsCourse = tempsCourse;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.m_coureur, Duration.ofMillis(this.m_tempsCourse));
    }
}
