package study;

import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern REG_EXP = Pattern.compile("^[0-9]*$");
    private Formula formula;

    Calculator(Formula formula){
        this.formula = formula;
    }

    // 초기 값 세팅
    int result = 0;
    Operator currentOperator = Operator.ADD;

    // 3. 계산
    public int calculate(){

        for(String input : formula.getFormula()){
            if(REG_EXP.matcher(input).find()){
                result = currentOperator.operate(result, Integer.parseInt(input));
                continue;
            }
            currentOperator = Operator.findOperator(input);
        }
        return result;
    }

}
