package com.valuablecode.kata;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

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
        assertThat(sut.add("2"), equalTo(2));

        assertThat(sut.add("1,2"), equalTo(3));
        assertThat(sut.add("2,3"), equalTo(5));

        assertThat(sut.add("1,2,3,4"), equalTo(10));
    }

}
