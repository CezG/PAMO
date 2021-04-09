package com.bmicalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void check_rateBmi() {
        BMI bmi = new BMI(new Person(67, 178));
        assertEquals("normal", bmi.rateBmi());
    }

    @Test
    public void check_valueBmi() {
        BMI bmi = new BMI(new Person(67, 178));
        assertEquals(21.146, bmi.getValue(), 2);
    }
}