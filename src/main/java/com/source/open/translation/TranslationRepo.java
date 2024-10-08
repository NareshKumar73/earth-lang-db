package com.source.open.translation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepo extends JpaRepository<Translation, Long> {

    Optional<Translation> findByLocaleAndKey(String locale, String key);
}
