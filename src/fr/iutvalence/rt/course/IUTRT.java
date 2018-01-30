package fr.iutvalence.rt.course;

/**
 * Small class to illustrate the project.
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public final class IUTRT {
    /**
     * Main method.
     *
     * @param args unused
     */
    public static void main(final String... args) {
        final Course course = new Course();
        course.add("BENEFICE", "Claire");
        course.add("CHABALIER", "Colin");
        course.add("CRETON", "Laurence");
        course.add("DUCCINI", "Christian");
        course.add("FOURTY", "Nicolas");
        course.add("GENON-CATALOT", "Denis");
        course.add("JAMONT", "Jean-Paul");
        course.add("MICHEL", "Frederic");
        course.add("NOURIGAT", "Genevieve");
        course.add("PASTORINO", "Luc");
        course.gogogo();

        try {
            Thread.sleep(20000);
        }
        catch (final InterruptedException ignore) {
            /* NOTHING */
        }
        course.afficherClassement();
    }

}
