package junit.punam;

public class Calculator {

	CalculatorService service;

	public Calculator(CalculatorService service) {
		this.service = service;
	}

	public int addTwoNumber(int i, int j) {

		return (service.add(i, j));

	}

}
