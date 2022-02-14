package com.OrangeHRM.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/FeatureFiles",
        glue = "com/OrangeHRM/StepDefinitions",
        dryRun = false,
        tags = "@Working",
        plugin = {"pretty","html:src/Reports/CucumberReport.html"}
)

public class TestRunner {
}
