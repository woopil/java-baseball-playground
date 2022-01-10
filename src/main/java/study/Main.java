package study;

public class Main {

    public static void main(String[] args) {
        // 1. 문자열 공백 제거
        final Calculator calculator = new Calculator(new Formula("2 + 3 * 4 / 2"));

        System.out.println("result = " + calculator.calculate());
    }
}