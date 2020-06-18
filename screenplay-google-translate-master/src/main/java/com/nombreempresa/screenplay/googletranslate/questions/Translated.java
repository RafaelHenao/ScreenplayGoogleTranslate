package com.nombreempresa.screenplay.googletranslate.questions;

import com.nombreempresa.screenplay.googletranslate.userinterfaces.GoogleTranslateHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("text translated")
public class Translated implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return GoogleTranslateHomePage.TEXT_AREA_FOR_TARGET_LANGUAGE.resolveFor(actor).getText();
    }

    public static Translated text() {
      return new Translated();
    }
}
