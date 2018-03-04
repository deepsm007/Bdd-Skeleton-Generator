/**
 * 
 */
package com.deepsm007.bdd.Bdd_Skeleton_Generator.methods;

/**
 * This class contains final constants required in the application.
 * 
 * @author Deep Mistry
 *
 */
public final class RunnerConstants {

	public static final String PLACEHOLDER = "$(FeatureName)";
	public static final String TESTRUNNER = "TestRunner";
	public static final String FEATURE_EXTENSION = ".feature";
	public static final String OUTPUT = "Output";
	public static final String CONSOLE_DATA = "You can implement missing steps with the snippets below:";
	public static final String STEPS = "Steps";
	public static final String RUNNER_DATA = "import org.junit.runner.RunWith;\nimport cucumber.api.CucumberOptions;\nimport cucumber.api.junit.Cucumber;\nimport cucumber.api.testng.AbstractTestNGCucumberTests;\n@RunWith(Cucumber.class)\n@CucumberOptions(dryRun = false, monochrome = true, format = { \"pretty\", \"html:target/cucumber\",\"json:target/cucumber$(FeatureName).json\" }, features = \"Features/$(FeatureName).feature\")\npublic class $(FeatureName)TestRunner extends AbstractTestNGCucumberTests {\n}";
	public static final String STEP_DATA = "import cucumber.api.PendingException;\nimport cucumber.api.Scenario;\nimport cucumber.api.java.After;\nimport cucumber.api.java.Before;\nimport cucumber.api.java.en.Given;\nimport cucumber.api.java.en.Then;\nimport cucumber.api.java.en.When;\n\npublic class $(FeatureName)Steps {\n$(content)\n}";
}