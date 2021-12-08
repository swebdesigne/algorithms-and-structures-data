package algorithm.greedy;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GreedyTest {
    @Test
    public void execute() {
            int[] expected = {10, 5};
            assertThat(new Greedy().execute(new int[] {10, 5, 2, 1},
                    50, 35), is(expected));
    }
}