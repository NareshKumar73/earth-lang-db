package com.source.open.config;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import com.source.open.translation.TranslationService;

@Component("messageSource")
public class DatabaseMessageSource extends AbstractMessageSource {

    private final TranslationService translationService;
    
    public DatabaseMessageSource(TranslationService translationService) {
		super();
		this.translationService = translationService;
	}

	@Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String message = translationService.getMessage(code, locale.getLanguage());
        if (message == null) {
            message = translationService.getMessage(code, Locale.ENGLISH.getLanguage());
        }
        return message != null ? new MessageFormat(message, locale) : null;
    }
}
