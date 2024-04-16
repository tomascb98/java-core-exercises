package com.epam.rd.autotasks.arithmeticexpressions;


public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        return new Variable(String.valueOf(value), value){
            @Override
            public String toExpressionString() {
                String valueRepresentation;
                if(evaluate()<0){
                    valueRepresentation = "(" + evaluate() + ")";
                } else {
                    valueRepresentation = String.valueOf(evaluate());
                }
                return valueRepresentation;
            }
        };
    }

    public static Expression sum(Expression... members){

        return new Expression() {
            @Override
            public int evaluate() {
                int sum = members[0].evaluate();
                for(int i= 1 ; i < members.length; i++){
                    sum += members[i].evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                String name = "(" + members[0].toExpressionString();
                for(int i= 1 ; i < members.length; i++){
                    name += " + " + members[i].toExpressionString();
                }
                name += ")";
                return name;
            }
        };
    }

    public static Expression product(Expression... members){

        return new Expression() {
            @Override
            public int evaluate() {
                int product = members[0].evaluate();
                for(int i= 1 ; i < members.length; i++){
                    product *= members[i].evaluate();
                }
                return product;
            }

            @Override
            public String toExpressionString() {
                String name = "(" + members[0].toExpressionString();
                for(int i= 1 ; i < members.length; i++){
                    name += " * " + members[i].toExpressionString();
                }
                name += ")";
                return name;
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend){

        return new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + minuend.toExpressionString() + " - " + subtrahend.toExpressionString() + ")";
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor){

        return new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate()/divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + dividend.toExpressionString() + " / " + divisor.toExpressionString() + ")";
            }
        };
    }

}
