package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void replace() throws Exception {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("문자열 자르기")
    void test() throws Exception {
        // given
        String str = "1,2";
        // when
        final String[] split = str.split(",");
        //then
        assertThat(split).contains("1");
    }

    @Test
    @DisplayName("문자열 특정위치 자르기")
    void test2() throws Exception{
        // given
        String str = "(1,2)";
        // when
        final String substring = str.substring(1, str.length() -1);
        // then
        assertThat(substring).isEqualTo("1,2");
    }


    @Test
    @DisplayName("특정 위치 문자 가져오기")
    void test3() throws Exception{
        // given
        String str = "abc";

        // when , then
        assertThatThrownBy(() -> str.charAt(str.length()+1))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range", String.valueOf(str.length()));
    }
}
