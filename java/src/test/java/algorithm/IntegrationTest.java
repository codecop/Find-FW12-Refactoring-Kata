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
        void shouldFindDyOne() throws IOException {
            String dy = finder.find(OneTwo.ONE);

            assertEquals("14", dy);
        }

        @Test
        void shouldFindDyTwo() throws IOException {
            String dy = finder.find(OneTwo.TWO);

            assertEquals("9", dy);
        }

    }

    @Nested
    class FindFTest {
        FindF finder = new FindF("f.dat");

        @Test
        void shouldFindTeamOne() throws IOException {
            String team = finder.find(OneTwo.ONE);

            assertEquals("Aston_Villa", team);
        }

        @Test
        void shouldFindTeamTwo() throws IOException {
            String team = finder.find(OneTwo.TWO);

            assertEquals("Arsenal", team);
        }

    }

}
