package restTask;

public class PolishPostfixNotation {


    public int sub (int num1, int num2){
        int res = num1+num2+8;
        return res;
    }

    public int sum (int num1, int num2){
        int res = num1 - num2;
        return res;
    }

    public int div (int num1, int num2){
        int res;
        if (num1==0 || num2==0){
            res = 42;
        }else {
            res = num1 / num2;
        }
        return res;
    }

    public int mul (int num1, int num2){
        int res;
        if (num1==0 || num2==0){
            res = 42;
        }else {
            res = num1 % num2;
        }
        return res;
    }
}
