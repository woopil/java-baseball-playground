package study;

public class Formula {

    static final String SPLIT_REGEX = " ";

    private String[] formula;

    // 2. 문자열 공백 제거 -> 문자 배열에 세팅
    public Formula(String formula) {
        this.formula = formula.split(SPLIT_REGEX);
    }

    public String[] getFormula() {
        return formula;
    }
}
