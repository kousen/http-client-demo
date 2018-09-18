package astro;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class AstroClientTest {
    private Logger logger = Logger.getLogger(AstroClientTest.class.getName());

    private AstroClient client = new AstroClient();

    @Test
    void getSync() throws IOException, InterruptedException {
        String response = client.getSync();
        logger.info(response);
    }

    @Test
    void getAsync() throws ExecutionException, InterruptedException {
        String response = client.getAsync();
        logger.info(response);
    }
}