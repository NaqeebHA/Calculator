import java.util.ArrayList;

public class Calculator {
private ArrayList<Double> CalcNumbersList = new ArrayList<>();
private ArrayList<String> CalcOperatorsList;


public double calculateEquation(ArrayList<Integer> numbersList, ArrayList<String> operatorsList) {

    for (int i = 0; i < numbersList.size(); i++) {
       CalcNumbersList.add(i, numbersList.get(i).doubleValue());
       // change the int values into double values for calculation
    }
    CalcOperatorsList = operatorsList;

    for (int i = 0; i < CalcOperatorsList.size(); i++) {
        if (CalcOperatorsList.get(i).equals("*")) {
            CalcNumbersList.set(i + 1, CalcNumbersList.get(i) * CalcNumbersList.get(i + 1));
            CalcOperatorsList.set(i, "+");
            CalcNumbersList.set(i, 0D);
        }
        if (CalcOperatorsList.get(i).equals("/")) {
            double result = CalcNumbersList.get(i) / CalcNumbersList.get(i + 1);
            CalcNumbersList.set(i + 1, CalcNumbersList.get(i) / CalcNumbersList.get(i + 1));
            CalcOperatorsList.set(i, "+");
            CalcNumbersList.set(i, 0D);
        }
    }

    Double accumulator = CalcNumbersList.get(0);

    for (int i = 0; i < CalcOperatorsList.size(); i++) {
        if (CalcOperatorsList.get(i).equals("+")) {
            accumulator += CalcNumbersList.get(i+1);
        }
        if (CalcOperatorsList.get(i).equals("-")) {
            accumulator -= CalcNumbersList.get(i+1);
        }
    }
    return accumulator;
}

public ArrayList<Double> getNumberList() {
    return CalcNumbersList;
}

public ArrayList<String> getOperatorList() {
    return CalcOperatorsList;
}
}