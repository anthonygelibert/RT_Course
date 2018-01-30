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
    public static void main(final String[] args) {
        Course c = new Course();
        c.add("BENEFICE", "Claire");
        c.add("CHABALIER", "Colin");
        c.add("CRETON", "Laurence");
        c.add("DUCCINI", "Christian");
        c.add("FOURTY", "Nicolas");
        c.add("GENON-CATALOT", "Denis");
        c.add("JAMONT", "Jean-Paul");
        c.add("MICHEL", "Frederic");
        c.add("NOURIGAT", "Genevieve");
        c.add("PASTORINO", "Luc");
        c.gogogo();
        System.out.println("*************************");
    }

}
