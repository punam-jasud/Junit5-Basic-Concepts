package junit.punam;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

//@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("When running MathUtils test cases")
class MathUtilsTest {

	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("This should run before all methods");
	}
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		mathUtils = new MathUtils();
		this.testInfo = testInfo;
		this.testReporter = testReporter;
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up");
	}
	
	@Nested
	@DisplayName("Add Method")
	@Tag("Math")
	class addTest{
		
		@Test
		@DisplayName("When adding positive numbers")
		void testAddPositive() {
			
			assertEquals(4, mathUtils.add(2, 2),"Should return correct sum");
		}
		
		@Test
		@DisplayName("When adding negative numbers")
		void testAddNegative() {
			
			assertEquals(-4, mathUtils.add(-2, -2),"Should return correct sum");
		}
		
		
	}

	
	
	@Test
	@DisplayName("Testing Subtract Method")
	@Tag("Math")
	void testSub() {
		
		//MathUtils mathUtils = new MathUtils();
		int expected  = 2;
		int actual = mathUtils.subtract(4, 2);
		assertEquals(expected, actual,() -> "Should return "+expected+" but returned "+actual);
	}
	
	@Test
	@DisplayName("Multiply Method")
	//@Disabled
	@Tag("Math")
	void testMultiply() {
		
		testReporter.publishEntry("Running "+testInfo.getDisplayName()+" with tags "+testInfo.getTags());
		
		
		//MathUtils mathUtils = new MathUtils();
		/*
		 * int expected = 8; int actual = mathUtils.multiply(4,2);
		 * assertEquals(expected, actual);
		 */
		
		
		assertAll(
				
				() -> assertEquals(4, mathUtils.multiply(2, 2)),
				() -> assertEquals(0, mathUtils.multiply(2, 0)),
				() -> assertEquals(-2, mathUtils.multiply(2, -1))
				
				
				);
		
		
		
	}
	
	@Test
	//@EnabledOnOs(OS.LINUX)
	@Tag("Math")
	void testDivide() {
		//MathUtils mathUtils = new MathUtils();
		
		boolean serverUp = false;
		assumeTrue(serverUp);
		
		assertThrows(ArithmeticException.class, ()-> mathUtils.divide(1, 0) , "Divide by zero should throw");
	}
	
	//@Test
	@RepeatedTest(3)
	@Tag("Circle")
	void testComputeCircleArea(RepetitionInfo info) {
		//MathUtils mathUtils = new MathUtils();
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),"The method should compute correct circle area");
	}
	

}
