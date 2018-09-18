package astro;

import astro.json.Assignment;
import astro.json.AstroResponse;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class AstroClientTest {
    private Logger logger = Logger.getLogger(AstroClientTest.class.getName());

    private AstroClient client = new AstroClient();

    @Test
    void getSync() {
        AstroResponse response = assertTimeoutPreemptively(
                Duration.ofSeconds(2),
                () -> client.getSync());

        int num = response.getNumber();
        List<Assignment> assignments = response.getPeople();

        assertEquals("success", response.getMessage());
        assertEquals(num, assignments.size());
        assignments.forEach(assignment ->
                                    assertAll(() -> assertTrue(assignment.getName().length() > 0),
                                              () -> assertTrue(assignment.getCraft().length() > 0)));

        logResponse(num, assignments);
    }

    @Test
    void getAsync() {
        AstroResponse response = assertTimeoutPreemptively(
                Duration.ofSeconds(2),
                () -> client.getAsync());

        int num = response.getNumber();
        List<Assignment> assignments = response.getPeople();

        assertEquals("success", response.getMessage());
        assertEquals(num, assignments.size());

        logResponse(num, assignments);
    }

    private void logResponse(int num, List<Assignment> assignments) {
        logger.info(String.format("There are %d people in space", num));
        assignments.forEach(person -> logger.info(
                () -> String.format("%s aboard %s",
                                    person.getName(),
                                    person.getCraft())));
    }
}