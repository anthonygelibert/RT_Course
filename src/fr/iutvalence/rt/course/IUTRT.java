package fr.iutvalence.rt.course;

import java.io.IOException;

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

        course.debutCourse();
        course.gogogo();
        course.afficherClassement();

        try {
            course.sauvegarderClassement("classement.txt");
        }
        catch (final IOException e) {
            System.err.println("Le classement ne peut pas être enregistré dans le fichier \"classement.txt\"");
            System.err.printf("Message d'erreur reçu : %s%n", e.getMessage());
        }
    }

}
