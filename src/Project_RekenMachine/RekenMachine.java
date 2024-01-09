package Project_RekenMachine;
import java.util.Scanner;
import java.util.Stack;
public class RekenMachine {
    Scanner inp = new Scanner(System.in);

    public double basicExp() {
        // int j = 0;
        //Scanner inp = new Scanner(System.in);
        System.out.println("Please enter the expression , first character should be sign(+ or -)");
        String exp1 = inp.next();
        String exp = exp1.replaceAll(" ", "");
        String[] parts = exp.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");

        double result = 0.0;
        // Iterate over the parts and perform the operations
        for (int i = 0; i < parts.length; i += 2) {
            String operator = parts[i];
            double operand = Double.parseDouble(parts[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                // Add more cases for other operators if needed
                default:
                    throw new IllegalArgumentException("Unsupported operator: " + operator);
            }
        }


        return result;
    }


    public double standardExp()
    {
        System.out.println("Please enter the expression");
        String exp1 = inp.next();
        String exp = exp1.replaceAll(" ", "");
        char[] tokens = exp.toCharArray();

        // Stacks for numbers and operators
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')) {
                    sb.append(tokens[i]);
                    i++;
                }

                i--;


                numbers.push(Double.parseDouble(sb.toString()));
            }
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/' || tokens[i]== '%')
            {
                while (!operators.isEmpty() && hasPrecedence(tokens[i], operators.peek()))
                {
                    numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                }

                operators.push(tokens[i]);
            }
        }

        while (!operators.isEmpty()) {
            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    private boolean hasPrecedence(char op1, char op2) {
        return (op2 == '*' || op2 == '/') && (op1 == '+' || op1 == '-');
    }

    private  double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;

            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            case '%' :
                return a % b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    public void squareOfNumber()
    { System.out.println("Please enter the expression");
        String exp1 = inp.next();
        String exp = exp1.replaceAll(" ", "");
        String[] parts = exp.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
        double result = 0.0;
        // Iterate over the parts and perform the operations
        for (int i = 0; i < parts.length; i += 2)
        {
            String operator = parts[i];
            double operand = Double.parseDouble(parts[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;

                // Add more cases for other operators if needed
                default:
                    throw new IllegalArgumentException("Unsupported operator: " + operator);
            }
        }
        System.out.println("Please enter the power of expression");
        Integer power = inp.nextInt();

        double base = Math.pow(result, power);

        // Calculate square root of the result
        double result1 = Math.sqrt(base);

        // Print the result
        System.out.println("Result: " + result1);

    }



}

















