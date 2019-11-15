package Task;

import Tasks.OpenTaskLibrary;
import org.testng.annotations.*;
import Libraries.Parameters;
import Libraries.*;

public class OpenTasks
{
	Browser oBrowser;
	OpenTaskLibrary oOpenTaskLibrary;
	Parameters oParameters, oClassParameters;
	ClassReport oClassReport;

	String className[] = this.getClass().getName().toUpperCase().split("\\."); // Package Name

	@BeforeMethod
	public void InitailSetup()	
	{
		oParameters = new Parameters();
		oParameters.SetParameters("CLASSNAME", className[1]);
	}

	@BeforeClass
	public void InitailSetup1()
	{
		oClassParameters = new Parameters();
		oClassParameters.SetParameters("CLASSNAME", className[1]);
		oClassReport = new ClassReport(oClassParameters);
	}

	@Test()
	public void CCM_VR_Soarian_Codes_HCPCS_CPT()
	{
		oParameters.SetParameters("TESTNAME", Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase());

		try
		{	
			oBrowser = new Browser(oParameters);
			oOpenTaskLibrary = new OpenTaskLibrary(Browser.driver, Browser.oReport, oParameters);

			oOpenTaskLibrary.createTask();
		}
		catch (Exception e)
		{
			System.out.println("Exception Caught" + e);
		}
	}


	@AfterMethod
	public void FinalSetup()
	{
		oBrowser.cleanup();
		oClassReport.AddClassResult(oParameters.GetParameters("TESTNAME"), oParameters.GetParameters("TestStatus"), oParameters.GetParameters("HTML_REPORT_NAME"));
		//Browser.oAuraSetup.ALM_JIRA_Update(oParameters);
	}

	@AfterClass
	public void FinalSetup1()	
	{
		oClassReport.cleanup();
	}
}