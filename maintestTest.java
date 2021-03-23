package Mathprovider;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class maintestTest {
	
    Main maintestTest;
	
	@BeforeEach
	public void test_calculate_first_tax_rate()throws Exception {
		
		 maintestTest = new Main(); //create a new object referencing to Main.java
	}
		
	@Test
	@DisplayName("Case 0 - Normal Income - Separate Preferred") //Test if outcome is Separate Taxation
	public void testmain()throws Exception {
		
		System.out.println("STARTING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println();
			
		assertEquals("The result should be (separate) ..", 1690, maintestTest.main(200000, 150000));
		System.out.println("------------------------------------------------------------------------");
		
		assertEquals("The result should be (separate) ..", 67920, maintestTest.main(300000, 600000));
		System.out.println("------------------------------------------------------------------------");

		assertEquals("The result should be (separate) ..", 108500, maintestTest.main(450000, 700000));
		System.out.println("------------------------------------------------------------------------");

		assertEquals("The result should be (separate) ..", 93980, maintestTest.main(200000, 800000));
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println();
		System.out.println("ENDING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("==============================********==================================");
				
	}

	@Test
	@DisplayName("Case 1 - One No Tax - Joint Preferred") //Test if outcome is Joint Assessment is preferred
	public void test1()throws Exception {
		
		System.out.println("STARTING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println();
			
		assertEquals("The result should be (joint) ..", 103210, maintestTest.main(100000, 900000));
		System.out.println("------------------------------------------------------------------------");
		
		assertEquals("The result should be (joint) ..", 208440, maintestTest.main(1500000, 120000));
		System.out.println("------------------------------------------------------------------------");

		assertEquals("The result should be (joint) ..", 288595, maintestTest.main(2000000, 90000));
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println();
		System.out.println("ENDING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("==============================********==================================");
	}
	
	@Test
	@DisplayName("Case 2 - No Income") //Test if outcome is zero
	public void test2()throws Exception {
		
		System.out.println("STARTING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println();
			
		assertEquals("The result should be ..", 0, maintestTest.main(0, 0));
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println();
		System.out.println("ENDING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("==============================********==================================");
	}
	
	@Test
	@DisplayName("Case 3 - Low Income") //Test if low income result in zero tax payable
	public void test3()throws Exception {
		
		System.out.println("STARTING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println();
			
		assertEquals("The result should be ..", 0, maintestTest.main(95000, 130000));
		System.out.println("------------------------------------------------------------------------");
		
		assertEquals("The result should be ..", 0, maintestTest.main(100000, 120000));
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println();
		System.out.println("ENDING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("==============================********==================================");
	}
	
	@Test
	@DisplayName("Case 4 - both Standard Tax Rate - Same Results under Two Systems") //Test if both applied standard tax rate
	public void test4()throws Exception {
		
		System.out.println("STARTING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println();
			
		assertEquals("The result should be ..", 969600, maintestTest.main(2500000, 4000000));
		System.out.println("------------------------------------------------------------------------");
		
		assertEquals("The result should be ..", 1644600, maintestTest.main(5000000, 6000000));
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println();
		System.out.println("ENDING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("==============================********==================================");
	}
	
	@Test
	@DisplayName("Case 5 - both Standard Tax Rate - Different Results under Two Systems") //Test if both applied standard tax rate
	public void test5()throws Exception {
		
		System.out.println("STARTING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println();
			
		assertEquals("The result should be (separate) ..", 523780, maintestTest.main(3500000, 200000));
		System.out.println("------------------------------------------------------------------------");
		
		assertEquals("The result should be (separate)..", 447510, maintestTest.main(3000000, 150000));
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println();
		System.out.println("ENDING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("==============================********==================================");
	}
	
	@Test
	@DisplayName("Case 6 - MPF is not required") //Test if MPF is zero
	public void test6()throws Exception {
		
		System.out.println("STARTING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println();
		
		assertEquals("The result should be ..", 0, maintestTest.main(50000, 70000));
		System.out.println("------------------------------------------------------------------------");
	
		assertEquals("The result should be ..", 0, maintestTest.main(25000, 60000));
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println();
		System.out.println("ENDING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("==============================********==================================");
	}
	
	@Test
	@DisplayName("Case 7 - Maximum MPF deduction") //Test if  MPF is at the maximum value of $18,000
	public void test7()throws Exception {
		
		System.out.println("STARTING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println();
		
		assertEquals("The result should be (separate)..", 66000, maintestTest.main(400000, 500000));
		System.out.println("------------------------------------------------------------------------");
		
		assertEquals("The result should be (separate)..", 372000, maintestTest.main(700000, 2000000));
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println();
		System.out.println("ENDING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("==============================********==================================");
	}
	
	@Test
	@DisplayName("Case 8 - One No Income, One normal Income") //Test if outcome is join assessment under extreme condition
	public void test8()throws Exception {
		
		System.out.println("STARTING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println();
		
		assertEquals("The result should be(joint) ..", 19060, maintestTest.main(0, 500000));
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println();
		System.out.println("ENDING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("==============================********==================================");
	}
	
	@Test
	@DisplayName("Case 9 - One No Income, One extremely high Income - Standard Tax rate") //Test if standard tax rate is used under extreme condition
	public void test9()throws Exception {
		
		System.out.println("STARTING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println();
		
		assertEquals("The result should be(joint) ..", 2997300, maintestTest.main(0, 20000000));
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println();
		System.out.println("ENDING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("==============================********==================================");
	}

	@RepeatedTest(value = 2)
	@DisplayName("Repeated Test - Normal Cases") //Test if the results are the same after running two times
	public void testtwice()throws Exception {
		
		System.out.println("STARTING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println();
	
		assertEquals("The result should be (separate) ..", 1690, maintestTest.main(200000, 150000));
		System.out.println("------------------------------------------------------------------------");

		assertEquals("The result should be (joint) ..", 288595, maintestTest.main(2000000, 90000));
		System.out.println("------------------------------------------------------------------------");
		
		assertEquals("The result should be ..", 969600, maintestTest.main(2500000, 4000000));
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println();
		System.out.println("ENDING TEST: " + new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("==============================********==================================");
	}
	
	
}
