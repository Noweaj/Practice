package main;

import java.util.ArrayList;

class Calculator{
	
	public int evaluate(String expression) {		
		String[] numbers = expression.split("[+]|/|-|[*]");
		String[] operations = expression.split("1|2|3|4|5|6|7|8|9|0");
		ArrayList<String> operation = new ArrayList<>();
		for(int i=0; i<operations.length; i++) {
			if(!operations[i].equals("")) {
				operation.add(operations[i]);
			}
		}
		
		int sum = Integer.parseInt(numbers[0]);
		for(int i=1; i<numbers.length; i++) {
			switch(operation.get(i-1)) {
				case "+":
					sum += Integer.parseInt(numbers[i]);
					break;
				case "-":
					sum -= Integer.parseInt(numbers[i]);
					break;
				case "*":
					sum *= Integer.parseInt(numbers[i]);
					break;
				case "/":
					sum /= Integer.parseInt(numbers[i]);
					break;
				default:
					break;
			}
		}
		return sum;
	}
	
}

public class CalculatorMain {
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		String problem = "111+22+33";
		int sum = calculator.evaluate(problem);
		
		System.out.println(problem+" = "+sum);
	}

}
