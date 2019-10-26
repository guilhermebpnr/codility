package lessons.lesson5_prefixsums.passingcars;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import utils.Utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class Tests {

    private static final long TIMEOUT = 6000;

    private Solution testSolution = new Solution();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void example1Test() {
        int[] input = {0, 1, 0, 1, 1};
        int expected = 5;
        int actual = testSolution.solution(input);
        Assert.assertThat(actual, is(equalTo(expected)));
    }

    @Ignore
    @Test
    public void overOneBillionPassingCarsShouldReturnMinusOneTest() {
        int[] input = new int[1000000002];
        input[0] = 0;
        for (int i = 1; i < input.length; i++) {
            input[i] = 1;
        }

        int actual = testSolution.solution(input);
        int expected = -1;

        Assert.assertThat(actual, is(equalTo(expected)));
        Utils<Solution, int[], Integer> utils = new Utils<>();
        utils.resultAndPerformanceTest(testSolution, input, expected, TIMEOUT);
    }

    @Test
    public void emptyArrayShouldRaiseExceptionTest() {
        int[] input = {};
        exception.expect(IllegalArgumentException.class);
        testSolution.solution(input);
    }

    @Test
    public void arrayWithMoreThan100000ElementsShouldRaiseExceptionTest() {
        int[] input = new int[100001];
        exception.expect(IllegalArgumentException.class);
        testSolution.solution(input);
    }

    @Test
    public void arrayWithElementsDifferentThanZeroAndOneShouldRaiseExceptionTest() {
        int[] input = {0, 1, 0, 2, 0, 1, 1};
        exception.expect(IllegalArgumentException.class);
        testSolution.solution(input);
    }
}
