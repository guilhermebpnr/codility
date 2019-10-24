package lessons.lesson4_countingelements.missinginteger;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

public class Tests {

    public static final long TIMEOUT_LIMIT = 6000L;
    private Solution testSolution = new Solution();

    @Test
    public void example1Test() {
        int[] a =  {1, 3, 6, 4, 1, 2};

        int expected = 5;

        long startTime = System.currentTimeMillis();
        int actual = testSolution.solution(a);
        long stopTime = System.currentTimeMillis();

        long elapsedTime = stopTime - startTime;

        Assert.assertThat(expected, is(equalTo(actual)));
        Assert.assertThat("elapsedTime", elapsedTime, is(lessThan(6000L)));
    }



    @Test
    public void example2Test() {
        int[] a =  {1,2,3};
        int expected = 4;

        long startTime = System.currentTimeMillis();
        int actual = testSolution.solution(a);
        long stopTime = System.currentTimeMillis();

        long elapsedTime = stopTime - startTime;

        Assert.assertThat(actual, is(equalTo(expected)));
        Assert.assertThat(elapsedTime, is(lessThan(TIMEOUT_LIMIT)));
    }

    @Test
    public void example3Test() {
        int[] a =  {-1, -3};
        int expected = 1;

        long startTime = System.currentTimeMillis();
        int actual = testSolution.solution(a);
        long stopTime = System.currentTimeMillis();

        long elapsedTime = stopTime - startTime;

        Assert.assertThat(actual, is(equalTo(expected)));
        Assert.assertThat(elapsedTime, is(lessThan(TIMEOUT_LIMIT)));
    }

    @Test
    public void extremeValuesTest() {
        int[] a =  {-1000000, 1000000};
        int expected = 1;

        long startTime = System.currentTimeMillis();
        int actual = testSolution.solution(a);
        long stopTime = System.currentTimeMillis();

        long elapsedTime = stopTime - startTime;

        Assert.assertThat(actual, is(equalTo(expected)));
        Assert.assertThat(elapsedTime, is(lessThan(TIMEOUT_LIMIT)));
    }

    @Test
    public void chaoticSequenceTest() {
        int[] a =  {-1, 3, 6, -4, 1, 2, -10, 3, 60, -43, 10, 21};
        int expected = 4;

        long startTime = System.currentTimeMillis();
        int actual = testSolution.solution(a);
        long stopTime = System.currentTimeMillis();

        long elapsedTime = stopTime - startTime;

        Assert.assertThat(actual, is(equalTo(expected)));
        Assert.assertThat(elapsedTime, is(lessThan(TIMEOUT_LIMIT)));
    }

    @Test
    public void hugeChaoticSequenceTest() {
        final int MAX_POSITIVE_VALUE = 1000000;
        int[] a = new int[MAX_POSITIVE_VALUE * 2 + 1];
        int expected = new Random().nextInt(MAX_POSITIVE_VALUE);

        for (int i = 0; i < a.length; i++) {
            if (i%2 == 0 && i/2 != expected) {
                a[i] = i/2;
            }
            else {
                a[i] = new Random().nextInt(MAX_POSITIVE_VALUE) - MAX_POSITIVE_VALUE;
            }
        }

        long startTime = System.currentTimeMillis();
        int actual = testSolution.solution(a);
        long stopTime = System.currentTimeMillis();

        long elapsedTime = stopTime - startTime;

        Assert.assertThat(actual, is(equalTo(expected)));
        Assert.assertThat(elapsedTime, is(lessThan(TIMEOUT_LIMIT)));
    }
}
