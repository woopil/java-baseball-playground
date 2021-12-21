package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
    }

    @Test
    @DisplayName("Set Test")
    void Set사이즈() {
        final int size = numbers.size();
        System.out.println("size = " + size);
    }

    @Test
    @DisplayName("contains Test")
    void contains() {
        // when
        final boolean result1 = numbers.contains(1);
        final boolean result2 = numbers.contains(2);
        final boolean result3 = numbers.contains(3);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("ParameterizedTest 중복 제거")
    void ParameterizedTest_isTrue(int num) throws Exception {
        // when
        final boolean contains = numbers.contains(num);
        // then
        assertThat(contains).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = { "1:true", "2:true", "3:true", "4:false", "5:false"},delimiter = ':')
    @DisplayName("CsvSource 중복 제거")
    void ParameterizedTest_CsvSource(Integer inputNum, boolean expected) throws Exception {
        // when
        final boolean result = numbers.contains(inputNum);
        // then
        assertEquals(expected,result);
    }
}