package com.nombreempresa.screenplay.googletranslate.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features = {"src/test/resources/features/translate_text.feature"},
        glue = {"com.nombreempresa.screenplay.googletranslate.stepdefinitions"},
        snippets = SnippetType.CAMELCASE)
public class TranslateText {

}
