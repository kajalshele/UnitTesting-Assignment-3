package QualityKioskTraining.CalculatorOperation;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Multiplication {
	CalculatorOperation operation;
	int answer;

	@BeforeClass
	public void init() {
		operation = new CalculatorOperation();
	}

	@BeforeGroups("SmokeTest")
	public void beforeGroup() {
		operation=new CalculatorOperation();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void reInitialised() {
		answer = 0;
	}

	@Test(groups="SmokeTest")
	public void multiplicationWithPositiveNumber() {
		answer = operation.multiplication(5, 5);
		Assert.assertEquals(answer, 25, "Multiplication not work with Positive Number");
	}

	@Test	
	public void multiplicationWithNegativeNumber() {
		answer = operation.multiplication(-4, -2);
		Assert.assertEquals(answer, 8, "Multiplication not work with Negative Number");
	}

	@AfterClass
	public void tearDown() {
		operation = null;
	}

}
