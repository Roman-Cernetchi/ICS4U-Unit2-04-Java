/*
 * This program solves the Towers of Hanoi problem with the user-inputted
 * amount of rings.
 *
 * @author  Roman Cernetchi
 * @version 1.0
 * @since   2021-12-06
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class contains the solution to the Towers of Hanoi.
 * */
final class TowerOfHanoi {

    /**
    * Prevents instantiation.
    * Throw an exception IllegalStateException when called.
    *
    * @throws IllegalStateException
    *
    */
    private TowerOfHanoi() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Uses recursion to complete the hanoi algorithm and move all the rings to
     * the final rod.
     *
     * @param ring the amount of rings, but also the ring currently being
     *     moved.
     * @param fromPole is the initial pole
     * @param toPole is the final pole
     * @param midPole is the middle pole
     * @throws IOException if there is anything wrong with the user input.
     * @throws NumberFormatException if the user input cannot be turned into
     *     an integer.
     * */
    public static void hanoi(final int ring, final char fromPole,
            final char toPole, final char midPole) {

        final String toPoleString = " to Pole ";

        if (ring > 1) {
            hanoi(ring - 1, fromPole, midPole, toPole);

            System.out.println("Move disk " + ring + " from Pole "
                    + fromPole + toPoleString + toPole);

            hanoi(ring - 1, midPole, toPole, fromPole);
        } else if (ring == 1) {
            System.out.println("Move disk 1 from Pole "
                    + fromPole + toPoleString + toPole);
        } else {
            System.out.println("Please enter a number higher than 0.");
        }
    }

    /**
     * Solves the towers of hanoi.
     *
     * @param args No args will be used.
     * @throws IOException if there is anything wrong with the user input.
     * @throws NumberFormatException if the user input cannot be turned into
     *     an integer.
     * */
    public static void main(final String[] args) {

        final char fromPole = 'A';
        final char toPole = 'B';
        final char midPole = 'C';

        try {
            System.out.print("Choose the amount of rings: ");

            final String ringsString = new BufferedReader(
                    new InputStreamReader(System.in)
            ).readLine();

            final int rings = Integer.parseInt(ringsString);

            System.out.print("\n");

            hanoi(rings, fromPole, toPole, midPole);
        } catch (NumberFormatException | IOException exception) {
            System.out.println("Please enter an integer.");
        }

        System.out.println("\nDone.");
    }
}
