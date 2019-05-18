package com.example.calc3;

public class DoCalc {
    public class FakeTuple {
        public double n1;
        public double n2;
        public char symbol;
        private boolean is_symbol(char c) {
            if(c == '+' || c == '-' || c == '×' || c== '÷'){
                return true;
            } else {
                return false;
            }
        }
        public void BigBang(String expression) {
            int length = expression.length();
            int i = 0;
            for( ; i < length; ++i){
                if(is_symbol(expression.charAt(i))){
                    break;
                }
            }

            n1 = Double.parseDouble(expression.substring(0,i));
            symbol = expression.charAt(i);
            n2 = Double.parseDouble(expression.substring(i+1));
        }
    }
    private FakeTuple faketuple;
    private String Calc() {
        double result;

        if ('+' == faketuple.symbol) {
            result =  faketuple.n1 + faketuple.n2;
        } else if ('-' == faketuple.symbol) {
            result = faketuple.n1 - faketuple.n2;
        } else if ('×' == faketuple.symbol) {
            result = faketuple.n1 * faketuple.n2;
        } else if ('÷' == faketuple.symbol) {
            result = faketuple.n1 / faketuple.n2;
        } else {
            System.out.println("Impossible !");
            return "0.0";
        }

        if (Double.isInfinite(result)) {
            return "除零操作";
        } else {
            return String.valueOf(result);
        }
    }


    public String GetResult(String expression){
        faketuple = new FakeTuple();
        faketuple.BigBang(expression);
        return Calc();
    }
}

