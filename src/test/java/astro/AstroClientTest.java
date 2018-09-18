package astro;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class AstroClientTest {
    private AstroClient client = new AstroClient();

    @Test
    void getSync() throws IOException, InterruptedException {
        String response = client.getSync();
        System.out.println(response);
    }

    @Test
    void getAsync() throws ExecutionException, InterruptedException {
        String response = client.getAsync();
        System.out.println(response);
    }
}