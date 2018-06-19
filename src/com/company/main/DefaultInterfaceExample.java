package com.company.main;

public class DefaultInterfaceExample {

    public static void main(String[] args) {
        int value = 100;

        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * value);
            }
        };

        System.out.printf("value after calculating sqrt of %d %s", value ,formula.calculate(5));
        System.out.println();
        System.out.printf("value after absolute of %d %s", value ,formula.absolute(-value));
        System.out.println();
        System.out.printf("is Value Positive ? %s", Formula.isPositive(value));

    }

    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(a);
        }

        default double absolute(int a) {
            return Math.abs(a);
        }

        static boolean isPositive(int a) {
            return a > 0;
        }
    }
}
