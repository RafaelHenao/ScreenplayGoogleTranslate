package com.nombreempresa.screenplay.googletranslate.model;

import com.nombreempresa.screenplay.googletranslate.exceptions.CreationTranslationModelException;
import com.nombreempresa.screenplay.googletranslate.util.Validate;

public class Translation {

    private final String text;
    private final String sourceLanguage;
    private final String targetLanguage;

    public Translation(String text, String sourceLanguage, String targetLanguage) {
        this.text = text;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        isValid();
    }

    private void isValid() {
        if (Validate.isEmptyOrNull(text) ||
                Validate.isEmptyOrNull(sourceLanguage) ||
                Validate.isEmptyOrNull(targetLanguage)) {
            throw new CreationTranslationModelException(this);
        }
    }

    public String getText() {
        return text;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }
}
