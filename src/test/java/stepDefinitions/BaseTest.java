package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	private static int scenarioRN = 0;
	static int datacn = 0;

	// This method reads data from config.properties file
	public static String configMethod(String prop) throws FileNotFoundException, IOException {

		Properties prop1 = new Properties();
		prop1.load(new FileInputStream("config.properties"));
		return prop1.getProperty(prop);
	}

	public static void openBrowser() throws FileNotFoundException, IOException {
		String browser = BaseTest.configMethod("browser");
		if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();

			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			// String projectPath = System.getProperty("user.dir");
			// System.setProperty("webdriver.chrome.driver",
			// projectPath+"/src/test/resources/Drivers/chromedriver.exe");
			driver = new EdgeDriver(options);
		} else if (browser.equalsIgnoreCase("chrome")) {
			String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
			// WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Browser is opened");

	}

	public String excelReader(String scenario, String value) throws FileNotFoundException, IOException {
		String ExcelFile = BaseTest.configMethod("EXCELFILE");
		String SheetName = BaseTest.configMethod("SheetName");
		String excelData = "";
		try {

			String projectPath = System.getProperty("user.dir");
			File file = new File(projectPath + "//src//test//resources//TestData//" + ExcelFile);
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb;
			wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(SheetName);
			Iterator<Row> ri = sheet.iterator();

			while (ri.hasNext()) {
				Row row = ri.next();
				Iterator<Cell> ci = row.iterator();

				while (ci.hasNext()) {
					Cell cell = ci.next();
					if ((cell.getStringCellValue()).replaceAll("\\s", "")
							.equalsIgnoreCase(scenario.replaceAll("\\s", ""))) {
						scenarioRN = row.getRowNum();
//					excelData = excelDataReader(scenarioRN,value);
//					wb.close();
//					fis.close();
					}
				}
			}
			excelData = excelDataReader(scenarioRN, value);
			wb.close();
			fis.close();
			if (scenarioRN == 0) {
				System.out.println("Scenario name is not found!!");
			}

		} catch (IOException e) {

		}
		return excelData;

	}

	static String excelDataReader(int scenarioRow, String value) throws FileNotFoundException, IOException {

		int datarn = scenarioRow - 1;

		String ExcelFile = BaseTest.configMethod("EXCELFILE");
		String SheetName = BaseTest.configMethod("SheetName");

		String ValueToReturn = "";
		try {

			String projectPath = System.getProperty("user.dir");
			File file = new File(projectPath + "//src//test//resources//TestData//" + ExcelFile);
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb;
			wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(SheetName);
			Iterator<Row> ri = sheet.iterator();

//		int Scenario_rn;
			while (ri.hasNext()) {
				Row row = ri.next();
				Iterator<Cell> ci = row.iterator();

				while (ci.hasNext()) {

					Cell cell = ci.next();

					if (datarn == row.getRowNum()) {
						if (cell.getStringCellValue().equalsIgnoreCase(value)) {
							datacn = cell.getColumnIndex();
						}
					}

					if (scenarioRN == row.getRowNum() && datacn == cell.getColumnIndex()) {

						ValueToReturn = cell.getStringCellValue();

					}

				}

			}
			if (datacn == 0) {
				System.out.println("No Test Data Found with Header as : " + value);
			}
			wb.close();
			fis.close();
		} catch (IOException e) {

		}
		return ValueToReturn;
	}

	protected void TakeSS(String FileName) {
		String projectPath = System.getProperty("user.dir");
//		File file= new File(projectPath+"\\src\\test\\resources\\TestData\\"+screenshots);
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(f, new File(projectPath + "//target//screenshots//" + FileName + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static float convertingStringToFloat(String str) {
		DecimalFormat df = new DecimalFormat("0.00");
		String roundedNumber = df.format(Float.parseFloat(str));
		return Float.parseFloat(roundedNumber);
					}

}
