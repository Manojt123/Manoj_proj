package Tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import Libraries.ApplicationCentreLibrary;
import Libraries.Parameters;
import Libraries.Report;


public class OpenTaskLibrary extends ApplicationCentreLibrary
{
	public OpenTaskLibrary(WebDriver driver,Report oReport,Parameters oParameters) 
	{
		super(driver,oReport, oParameters);
	}
	
	By CreateTaskButton = By.xpath("span//[contains(text(),'Create Tasks')]");
	
	By CreateNewTasks = By.xpath("//td[contains(text(),'Create New Tasks')]");
	
	By customerfield = By.xpath("//div[@id='container']/form[@name='AddNewTasksForm']//td[@class='mainContentPadding rightPadding']//select[@name='customerId']");
	
	By EnterCustomerName = By.xpath("//div[@id='container']/form[@name='AddNewTasksForm']//td[@class='mainContentPadding rightPadding']//input[@name='customerName']");
	
	By EnterProjectName = By.xpath("//div[@id='container']/form[@name='AddNewTasksForm']//td[@class='mainContentPadding rightPadding']//input[@name='projectName']");
	
	By TaskName = By.xpath("//input[contains(@name,'task[0].name')]");
	
	By DeadlineTextbox = By.xpath("//div[@id='ext-gen6']//input[@id='task[0].deadline']");
	
	By Textbox = By.xpath("//table[@id='tasksTable']//input[@name='task[1].name']");
	
	By Create_TasksButton = By.xpath("//input[@value='Create Tasks']");
	
	public void createTask()
	{
		click_button("CREATE TASK BUTTON", CreateTaskButton);
		
		if(IsDisplayed("Create New Task Details Page", CreateNewTasks))
			oReport.AddStepResult("Create New Task Details", "Clicked on Create New Task Button and verified that New Task Detaisl Page has been displayed", "PASS");
		else
			oReport.AddStepResult("Create New Task Details", "Clicked on Create New Task Button and verified that New Task Detaisl Page has been not displayed", "FAIL");
	}
}
