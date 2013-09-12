package com.valuablecode.kata;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StringCalculatorTest {

    final StringCalculator sut = new StringCalculator();

    @Test
    public void adds_empty_numbers_list_to_zero() {
        assertThat(sut.add(""), equalTo(0));
    }

    @Test
    public void adds_numbers_list_to_sum_of_numbers() {
        assertThat(sut.add("1"), equalTo(1));
        assertThat(sut.add("1,2"), equalTo(3));
        assertThat(sut.add("2,3"), equalTo(5));
        assertThat(sut.add("1,2,3,4"), equalTo(10));
    }

    @Test
    public void add_numbers_List_to_sum_of_numbers_when_newline_delimiter() {
        assertThat(sut.add("1,2\n3"), equalTo(6));
    }

    @Test
    public void add_ignores_large_numbers() {
        assertThat(sut.add("999,1000,1001"), equalTo(1999));
    }

    @Test
    public void add_numbers_List_to_sum_of_numbers_when_simple_custom_delimiter() {
        assertThat(sut.add("//;\n1;2"), equalTo(3));
        assertThat(sut.add("//x\n1x2x3"), equalTo(6));
        assertThat(sut.add("//***\n1***2***3***4"), equalTo(10));
    }

    @Test
    public void add_numbers_List_to_sum_of_numbers_when_multiple_custom_delimiters() {
        assertThat(sut.add("//[***]\n1***2"), equalTo(3));
        assertThat(sut.add("//[;][xx]\n1;2xx3"), equalTo(6));
        assertThat(sut.add("//[x][y]\n1x2y3x4"), equalTo(10));
    }

    @Test
    public void add_fails_for_negative_numbers() {
        try {
            sut.add("1,-2,3,-4");
            fail();
        } catch (RuntimeException expected) {
            assertThat(expected.getMessage(),
                    both(containsString("negatives not allowed")).and(containsString("[-2, -4]")));
        }

    }

}
