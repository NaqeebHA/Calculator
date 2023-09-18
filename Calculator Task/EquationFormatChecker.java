import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquationFormatChecker {
private final List<String> operatorSet = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

// 0 for valid equation, 1 for invalid equation, 2 for invalid number
public boolean checkValidity(ArrayList<Integer> numbers, ArrayList<String> operators) {
    int length = numbers.size() + operators.size();

    // checking if either List is empty or length is valid
    if (numbers.isEmpty() || operators.isEmpty() || length < 3 || length == 4 || length > 5) {
        return false;
    }

    // check if operatorsList contains + - * /
    for (String operator : operators) {
        if (!operatorSet.contains(operator)) {
            return false;
        }
    }
    
    // check if input contains numbers less the 1 or more than 10
    for ( int i = 0; i < numbers.size(); i++ ) {
        if (numbers.get(i) < 1 || numbers.get(i) > 10) {
            return false;
        }
    }
    return true;
}
}