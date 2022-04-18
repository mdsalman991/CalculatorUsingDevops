package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class calculator {

    public static final Logger logger = LogManager.getLogger(calculator.class);

    public calculator() {}

    public static void main(String[] args) {
        calculator cal = new calculator();
        Scanner scanner = new Scanner(System.in);
        double x1, x2;

        do{
            System.out.println("Calculator Program...");
            System.out.println("Available Operations to Perform\n1 - Square Root of input_var\n2 - Factorial of input_var\n3 - Natural Log of input_var\n4 - input_var Power base\nPress Any Other key to Exit");
            int input_var;

            try{
                input_var = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            if (input_var < 1 || input_var > 4){
                return;
            }

            try{
                System.out.println("Enter input_var");
                x1 = scanner.nextDouble();
            } catch (InputMismatchException error) {
                return;
            }

            switch(input_var){
                case 1:
                    System.out.println("Square root of input_var = " + calculator.sqt(x1));
                    break;
                case 2:
                    System.out.println("Factorial of input_var =" + calculator.factorial(x1));
                    break;
                case 3:
                    System.out.println("Natural log of input_var =" + calculator.log(x1));
                    break;
                case 4:
                    try {
                        System.out.print("Enter base");
                        x2 = scanner.nextDouble();
                    } catch (InputMismatchException error){
                        return;
                    }
                    System.out.println("input_var power base = " + calculator.power(x1, x2));
                    break;
                default:
                    System.out.print("Closing");
                    return;
            }
        }while(true);
    }


    public static double sqt(double i){
        double temp = 0;
        try {
            logger.info("[SQRT] - " + i);
            if (i < 0) {
                temp = Double.NaN;
                throw new ArithmeticException("Cannot find square root of -ve numbers");
            } else {
                temp = Math.sqrt(i);
            }
        } catch (ArithmeticException error){
            logger.error("[EXCEPTION - SQRT] - Cannot find sqrt of -ve numbers");
        } finally {
            logger.info("[RESULT - SQRT] = " + temp);
        }
        return temp;
    }

    public static double factorial(double i){
        logger.info("[FACTORIAL] - " + i );
        double temp = 1.0;
        for (int t = 1; t<= i; t++){
            temp *= t;
        }
        logger.info("[RESULT - FACTORIAL] = " + temp);
        return temp;
    }
    public static double log(double i){
        Double temp = 0.0;
        try {
            logger.info("[LOG] - " + i);
            if (i < 0){
                temp = Double.NaN;
                throw new ArithmeticException("Cannot find log of negative numbers");
            }
            else if (i == 0){
                temp = Double.NEGATIVE_INFINITY;
                throw new ArithmeticException("Log of 0 is negative infinity");
            }
            else {
                temp = Math.log(i);
            }
        } catch (ArithmeticException error){
            logger.error("[EXCEPTION - log] - inout is less than or equal to zero");
        } finally {
            logger.info("[RESULT - LOG] = " + temp);
        }
        return temp;
    }
    public static double power(double i, double j){
        logger.info("[POWER] - " + i + ", " + j );
        double temp = Math.pow(i,j);
        logger.info("[RESULT - POWER] = " + temp);
        return temp;
    }

}