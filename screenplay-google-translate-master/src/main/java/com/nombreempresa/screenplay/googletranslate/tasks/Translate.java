package com.nombreempresa.screenplay.googletranslate.tasks;

import com.nombreempresa.screenplay.googletranslate.model.Translation;
import com.nombreempresa.screenplay.googletranslate.userinterfaces.GoogleTranslateHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Translate implements Task {

    private Translation translation;

    public Translate(Translation translation) {
        this.translation = translation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(GoogleTranslateHomePage.BUTTON_TO_SELECT_SOURCE_LANGUAGE),
                Click.on(GoogleTranslateHomePage.SOURCE_LANGUAGE.of(translation.getSourceLanguage())),
                Click.on(GoogleTranslateHomePage.BUTTON_TO_SELECT_TARGET_LANGUAGE),
                Click.on(GoogleTranslateHomePage.TARGET_LANGUAGE.of(translation.getTargetLanguage())),
                Enter.theValue(translation.getText()).into(GoogleTranslateHomePage.TEXT_AREA_FOR_SOURCE_LANGUAGE)
                );
    }

    public static Translate translate(Translation translation){
        return instrumented(Translate.class, translation);
    }
}
