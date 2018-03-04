/**
 * 
 */
package com.deepsm007.bdd.Bdd_Skeleton_Generator.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import com.deepsm007.bdd.Bdd_Skeleton_Generator.methods.FileHandler;
import com.deepsm007.bdd.Bdd_Skeleton_Generator.methods.GenerateJavaClass;
import com.deepsm007.bdd.Bdd_Skeleton_Generator.methods.RunnerConstants;
import com.deepsm007.bdd.Bdd_Skeleton_Generator.methods.ScanDirectory;

/**
 * This class is use to run the application to generate step definition and
 * runner class for Behaviour Driven Development using the feature files.
 * 
 * @author Deep Mistry
 *
 */
public class Main {
	static final Logger log = Logger.getLogger(Main.class);
	static String consoleData;
	static String stepContent;
	static String runnercontent;

	/**
	 * This method is the entry point of the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Scan for feature files
		log.info("Scanning for Feature files...");
		ScanDirectory.search(new File("."), RunnerConstants.FEATURE_EXTENSION);

		for (File s : ScanDirectory.listOfFiles) {
			// Generate Test Runner
			runnercontent = RunnerConstants.RUNNER_DATA;
			runnercontent = FileHandler.replacePlaceholder(RunnerConstants.PLACEHOLDER, runnercontent,
					FilenameUtils.removeExtension(s.getName()));
			GenerateJavaClass.generateFile(FilenameUtils.removeExtension(s.getName()), RunnerConstants.TESTRUNNER,
					runnercontent);

			try {
				// Generate Data for Step file from console
				consoleData = "";
				consoleData = FileHandler.runProcess("java -cp " + System.getProperty("java.class.path")
						+ " cucumber.api.cli.Main -m -g StepDefinition " + s.getCanonicalPath());
				if (consoleData.length() == 0) {
					log.error("Error in file --> " + s.getName());
					continue;
				}
				stepContent = RunnerConstants.STEP_DATA;
				stepContent = FileHandler.replacePlaceholder(RunnerConstants.PLACEHOLDER, stepContent,
						FilenameUtils.removeExtension(s.getName()));
				consoleData = consoleData.substring(consoleData.indexOf("@")).trim();
				stepContent = FileHandler.replacePlaceholder("$(content)", stepContent, consoleData);

				// Generate Step file
				GenerateJavaClass.generateFile(FilenameUtils.removeExtension(s.getName()), RunnerConstants.STEPS,
						stepContent);

			} catch (Exception e) {
				log.error("Error --> " + e);
			}
		}
//		System.exit(0);
	}
}
