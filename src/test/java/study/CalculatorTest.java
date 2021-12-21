package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @Test
    @DisplayName("계산된 값이 나오는지 테스트")
    void calculateTest(){
        Calculator calculator = new Calculator(new Formula("2 + 3 * 4 / 2"));
        int result = calculator.calculate();
        assertThat(10).isEqualTo(result);
    }

    @Test
    @DisplayName("0 으로 나눌 시 IllegalArgumentException 테스트")
    void divideExceptionTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(new Formula("2 + 2 * 10 / 0"));
            int result = calculator.calculate();
            assertThat(2).isEqualTo(result);
        });
    }

    @DisplayName("plus, minus, multiply, divide 테스트")
    @ParameterizedTest
    @CsvSource(value = {"+:12", "-:8", "*:20", "/:5"}, delimiter = ':')
    void operatorTest(String value, String result){
        // 10, 2 -> 4칙 연산 테스트
        assertThat(Operator.findOperator(value).operate(10, 2)).isEqualTo(Integer.parseInt(result));
    }
}