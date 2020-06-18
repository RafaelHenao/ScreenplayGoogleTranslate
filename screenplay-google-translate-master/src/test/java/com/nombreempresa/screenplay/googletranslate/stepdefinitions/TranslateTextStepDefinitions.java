package com.nombreempresa.screenplay.googletranslate.stepdefinitions;

import com.nombreempresa.screenplay.googletranslate.exceptions.CreationTranslationModelException;
import com.nombreempresa.screenplay.googletranslate.questions.Translated;
import com.nombreempresa.screenplay.googletranslate.userinterfaces.GoogleTranslateHomePage;
import com.nombreempresa.screenplay.googletranslate.model.builder.TranslationBuilder;
import com.nombreempresa.screenplay.googletranslate.tasks.Translate;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.Is.is;

public class TranslateTextStepDefinitions {

    private static final String NOMBREPERSONA = "NombrePersona";
    private GoogleTranslateHomePage googleTranslateHomePage;

    @Before
    public void prepareStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^I want to translate$")
    public void iWantToTranslate() throws Exception {
        theActorCalled(NOMBREPERSONA).wasAbleTo(
                Open.browserOn(googleTranslateHomePage)
        );
    }

    @When("^I translate the text (.*) from the (.*) to the (.*)$")
    public void translateText(String text, String sourceLanguage, String targetLanguage) throws CreationTranslationModelException {
        theActorInTheSpotlight().attemptsTo(
                Translate.translate(TranslationBuilder.theText(text).from(sourceLanguage).to(targetLanguage))
        );
    }

    @Then("^should see that the translated text is (.*)$")
    public void shouldSeeThatTheTranslatedTextIs(String translatedText) throws Exception {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(Translated.text(), is(translatedText)));
    }

}
