package com.source.open.translation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {

    @Autowired
    private TranslationRepo translationRepo;

    public String getMessage(String key, String locale) {
        Optional<Translation> translation = translationRepo.findByLocaleAndKey(locale, key);
        return translation.map(Translation::getMessage).orElse(null);
    }
}
