import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    
    Calculator calculate = new Calculator();
    EquationConverter equationConverter = new EquationConverter();
    EquationFormatChecker equationFormatChecker = new EquationFormatChecker();

boolean continueCalculation = true;
                while (continueCalculation) {
                    try {
                        System.out.print("Enter equation (Example: 1 + 4 * 5)\n=> ");
                        // take in the equation as String and pass it on to equation convertor
                        String equation = br.readLine();
                        equationConverter.setEverything(equation);
                        // checking validity of equation
                        boolean validityCheck = equationFormatChecker.checkValidity(equationConverter.getNumbersList(), equationConverter.getOperatorsList());
                        if (validityCheck) {
                            // find the answer
                            Double answer = calculate.calculateEquation(equationConverter.getNumbersList(), equationConverter.getOperatorsList());
                            System.out.println("Answer: " + answer);
                        }
                        else {
                            System.out.println("Wrong format, input formats are as below:");
                            System.out.println("1. TWO or THREE integers ranging from 1 to 10 each.");
                            System.out.println("2. Accepted operators are +, -, *, and / only");
                        }
                    } catch (NumberFormatException e1) {
                        System.out.println("Wrong format, please insert spaces between integers and operators.");
                    } 
                }
            }
}

