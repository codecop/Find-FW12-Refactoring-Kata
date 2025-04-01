package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class IntegrationTest {

    @Nested
    class FindWTest {
        FindW finder = new FindW("w.dat");

        @Test
        void shouldFindOne() throws IOException {
            String r = finder.find(OneTwo.ONE);

            assertEquals("14", r);
        }

        @Test
        void shouldFindTwo() throws IOException {
            String r = finder.find(OneTwo.TWO);

            assertEquals("9", r);
        }

    }

    @Nested
    class FindFTest {
        FindF finder = new FindF("f.dat");

        @Test
        void shouldFindOne() throws IOException {
            String r = finder.find(OneTwo.ONE);

            assertEquals("Aston_Villa", r);
        }

        @Test
        void shouldFindTwo() throws IOException {
            String r = finder.find(OneTwo.TWO);

            assertEquals("Arsenal", r);
        }

    }

}
