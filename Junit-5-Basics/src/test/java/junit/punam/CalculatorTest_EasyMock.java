package junit.punam;

import static org.junit.jupiter.api.Assertions.*;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest_EasyMock {
	
	Calculator c = null;
	CalculatorService service = EasyMock.createMock(CalculatorService.class);
	
	@BeforeEach
	public void setUp() {
		c = new Calculator(service);
	}

	@Test
	void addTwoNumberTest() {
		
		EasyMock.expect(service.add(2, 3)).andReturn(5);
		EasyMock.expect(service.add(-2, -3)).andReturn(-5);
		EasyMock.expect(service.add(-2, 3)).andReturn(1);
		EasyMock.replay(service);
		
		assertEquals(5,c.addTwoNumber(2, 3));
		assertEquals(-5,c.addTwoNumber(-2, -3));
		assertEquals(1,c.addTwoNumber(-2, 3));
		//assertEquals(1,c.addTwoNumber(1, 0)); //will throw assertion error
		EasyMock.verify(service);
	}

}
