package TestNgBasics;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgFirstclass {

	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("Beforesuite");
	}


	@BeforeTest
	public void beforetest()
	{
		System.out.println("Beforetest");
	}

	@AfterTest
	public void aftertest()
	{
		System.out.println("aftertest");
	}

	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Beforeclass");
	}

	@AfterClass
	public void Afterclass()
	{
		System.out.println("Afterclass");
	}

	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("BeforeMethod");
	}

	@AfterMethod
	public void aftermethod()
	{
		System.out.println("afterMethod");
	}

	@Test
	public void testcase1()
	{

		System.out.println("First Testcase");
	}

	@Test
	public void testcase2()
	{
		System.out.println("second Testcase");
	}
}
