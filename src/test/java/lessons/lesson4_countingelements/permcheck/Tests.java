package lessons.lesson4_countingelements.permcheck;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

public class Tests {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private static final long TIMEOUT_LIMIT = 6000;

    Solution testSolution = new Solution();

    @Test
    public void example1Test() {
        int[] input = {4, 1, 3, 2};
        int expected = 1;
        resultAndPerformanceTest(input,expected);
    }

    @Test
    public void example2Test() {
        int[] input = {4,1,3};
        int expected = 0;
        resultAndPerformanceTest(input,expected);
    }

    @Test
    public void shouldRaiseExceptionIfArrayIsEmptyTest() {
        int[] input = {};
        int expected = 0;
        exception.expect(IllegalArgumentException.class);
        resultAndPerformanceTest(input,expected);
    }

    @Test
    public void shouldRaiseExceptionIfArrayLengthGreaterThan100000Test() {
        int[] input = new int[100001];
        for (int i = 0; i < input.length; i++) {
            input[i] = i+1;
        }
        int expected = 0;
        exception.expect(IllegalArgumentException.class);
        resultAndPerformanceTest(input,expected);
    }

    @Test
    public void shouldReturnZeroIfMinElementDifferentThanOneTest() {
        int[] input = {2,4,3,5};
        int expected = 0;
        resultAndPerformanceTest(input,expected);
    }

    @Test
    public void shouldReturnZeroIfMaxElementDifferentThanArrayLengthTest() {
        int[] input = {4,3,6,2,7,1};
        int expected = 0;
        resultAndPerformanceTest(input,expected);
    }

    @Test
    public void shouldReturnZeroIfArrayDoesNotHaveEachElementOnceAndOnlyOnceTest() {
        int[] input = {1,2,2,4,5};
        int expected = 0;
        resultAndPerformanceTest(input,expected);
    }

    @Test
    public void shouldReturnOneIfArrayIsAPermutationTest() {
        int[] input = {2,3,4,1,5};
        int expected = 1;
        resultAndPerformanceTest(input,expected);
    }

    @Test
    public void shouldReturnOneIfArrayLengthEqualTo100000Test() {
        int[] input = new int[100000];
        for (int i = 0; i < input.length; i++) {
            input[i] = i+1;
        }
        int expected = 1;
        resultAndPerformanceTest(input,expected);
    }

    private void resultAndPerformanceTest(int[] input, int expected) {
        long startTime = System.currentTimeMillis();
        int actual = testSolution.solution(input);
        long stopTime = System.currentTimeMillis();

        long elapsedTime = stopTime - startTime;

        Assert.assertThat(actual, is(equalTo(expected)));
        Assert.assertThat("elapsed time", elapsedTime, is(lessThan(TIMEOUT_LIMIT)));
    }
}
