package TestNgBasics;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class TestNgSecondClass {

	@Test(groups="Sanity")
	public void testcase3()
	{
		System.out.println("third Testcase");
	}
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("afersuite");
	}
}
