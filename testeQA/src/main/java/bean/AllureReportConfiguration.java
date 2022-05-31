package bean;

import java.io.File;
import java.io.IOException;

import com.google.common.collect.ImmutableMap;

public class AllureReportConfiguration {

	static String allureReportResultsFolder = "C:/relatorio/allure-report/allure-results";
	static String allureReportPropertiesFileName = "environment.properties";
	static String allureReportPropertiesFilePath = allureReportResultsFolder + "/" + allureReportPropertiesFileName;
	static String allureReportScreenshotsFolder = "C:/relatorio/allure-report/allure-results/Screenshots";

	static File allureReportPropertiesFile = new File(allureReportPropertiesFilePath);

	public static void prepareAllureResultsFolder() throws IOException {

		// step 1. delete allure results folder
		File allureResultsFolder = new File(allureReportResultsFolder);

		try {
			deleteAllureResultsFolder(allureResultsFolder);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// step 2. create allure results folder
		try {
			createAllureResultsFolder(allureResultsFolder);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// step 3. delete allure screenshots folder

		File allureSnapshotsFolder = new File(allureReportScreenshotsFolder);

		try {
			deleteAllureResultsFolder(allureSnapshotsFolder);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// step 4. create allure screenshots folder
		try {
			createAllureResultsFolder(allureSnapshotsFolder);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void deleteAllureResultsFolder(File allureResultsFolder) throws IOException {

		if (allureResultsFolder.isDirectory()) {

			// directory is empty, then delete it
			if (allureResultsFolder.list().length == 0) {

				allureResultsFolder.delete();

			} else {

				// list all the directory contents
				String files[] = allureResultsFolder.list();

				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(allureResultsFolder, temp);

					// recursive delete
					deleteAllureResultsFolder(fileDelete);
				}

				// check the directory again, if empty then delete it
				if (allureResultsFolder.list().length == 0) {
					allureResultsFolder.delete();
				}
			}

		} else {
			// if file, then delete it
			allureResultsFolder.delete();
		}
	}

	public static void createAllureResultsFolder(File allureResultsFolder) throws IOException {

		printPaths(allureResultsFolder);

		if (!allureResultsFolder.exists()) {
			if (allureResultsFolder.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
	}

	public static void printPaths(File allureResultsFolder) throws IOException {
		System.out.println("Absolute Path: " + allureResultsFolder.getAbsolutePath());
		System.out.println("Canonical Path: " + allureResultsFolder.getCanonicalPath());
		System.out.println("Path: " + allureResultsFolder.getPath());

	}

	public static void createAllureHistoryFolder(File allureHistoryFolder) throws IOException {

		if (!allureHistoryFolder.exists()) {
			if (allureHistoryFolder.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
	}

	public static void setAllureEnvironment() throws IOException {

		AllureEnvironmentWriter.allureEnvironmentWriter(
				ImmutableMap.<String, String>builder().put("Browser", "Firefox").put("Browser.Version", "92.0 (64-bit)")
						.put("URL", "https://wj-qa-automation-test.github.io/qa-test/").build(),
				System.getProperty("user.dir") + "/allure-results/");

	}
}
