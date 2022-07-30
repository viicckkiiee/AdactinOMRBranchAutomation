package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
/**
 * 
 * @author Vikki
 * @CreationDate 26/06/2022
 * @Description To generate Report in html format
 *
 */

public class Reporting {
	/**
	 * 
	 * @param jsonFile
	 * @CreationDate 26/06/2022
	 * @Description To generate jvm report
	 */
	public static void generateJVMReport(String jsonFile) {
		File file = new File(System.getProperty("user.dir")+"\\target");

		Configuration configuration = new Configuration(file, "AdactinOMRBranchAutomation");
		configuration.addClassifications("OS", "Windows 11");
		configuration.addClassifications("Browser", "Chrome");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);

		builder.generateReports();
	}

}
