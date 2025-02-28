import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValideSaisieTest {

    @Test
    void testPrenomLocataire_ValidInput() {
        // Simulate user typing "Marie\n"
        ByteArrayInputStream input = new ByteArrayInputStream("Marie\n".getBytes());
        System.setIn(input);

        // Capture console output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Call the method (it will use Clavier.lireString())
        ValideSaisie.prenomLocataire();

        // Print the captured output to manually check what's happening
        System.out.println("Captured Output:\n" + output.toString());

        // Verify that "Le prénom est invalide!" was NOT printed
        assertTrue(!output.toString().contains("Le prénom est invalide!"),
                "No error should appear for a valid name.");
    }

    @Test
    void testPrenomLocataire_InvalidThenValidInput() {
        // Simulate user entering "A\nMarie\n" (first invalid, then valid)
        ByteArrayInputStream input = new ByteArrayInputStream("A\nMarie\n".getBytes());
        System.setIn(input);

        // Capture console output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Call the method
        ValideSaisie.prenomLocataire();

        // Print the captured output to manually check what's happening
        System.out.println("Captured Output:\n" + output.toString());

        // Verify that an error message appeared for the invalid name
        assertTrue(output.toString().contains("Le prénom est invalide!"),
                "Should show an error message for 'A' before accepting 'Marie'.");
    }
}
