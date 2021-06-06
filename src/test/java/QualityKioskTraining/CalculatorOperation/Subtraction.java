package QualityKioskTraining.CalculatorOperation;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Subtraction {
	CalculatorOperation operation;
	int answer;
	
	@BeforeClass
	public void init() {
		operation=new CalculatorOperation();
	}
	
	@BeforeGroups("SmokeTest")
	public void beforeGroup() {
		operation=new CalculatorOperation();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void reInitialised() {
		answer=0;
	}
	
	@Test(groups="SmokeTest")
	public void subtractionWithPositiveNumber() {
		answer=operation.subtraction(45,5);
		Assert.assertEquals(answer, 40,"Subtraction not work with Positive Number");
	}
	
	@Test
	public void subtractionWithNegativeNumber() {
		answer=operation.subtraction(-4,-2);
		Assert.assertEquals(answer, -2,"Subtraction not work with Negative Number");
	}
	
	@AfterClass
	public void tearDown() {
		operation=null;
	}


}
