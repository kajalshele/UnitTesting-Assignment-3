package QualityKioskTraining.CalculatorOperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Addition {
	
	
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
	public void reInitialise() {
		answer=0;
	}
	
	@Test(groups="SmokeTest")
	public void additionWithPositiveNumber() {
		answer=operation.addition(43,56);
	Assert.assertEquals(answer,99,"Addition Not Work With Positive Number");
	}

	@Test
	public void additionWithNegativeNumber() {
		answer=operation.addition(-20, -30);
		Assert.assertEquals(answer, -50,"Addition not work with Negative number");
	}
	
	@AfterClass
	public void close() {
		operation=null;
	}
	
	@BeforeSuite
	@Parameters({"ResultId"})
	public void createFolder(String folderName) {
		try {
			Files.createDirectories(Paths.get("./TDDReports/"+folderName));
		} catch (IOException e) {
			System.out.println("There is problem  to create folder");
				}
	}
	
	@AfterSuite
	@Parameters({"ResultId"})
	public void copyFile(String folderName) {
		try {
			Files.copy(Paths.get(".\\target\\surefire-reports\\emailable-report.html"),Paths.get("./TDDReports/"+folderName+"/Report.html"),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Not able to perform task");
				}
	}
}
