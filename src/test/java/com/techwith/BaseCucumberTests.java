package com.techwith;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.techwith.steps")
@SelectClasspathResource("featurefiles")
@IncludeTags("ui")
public class BaseCucumberTests {

}
