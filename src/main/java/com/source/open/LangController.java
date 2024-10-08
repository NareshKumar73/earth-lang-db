package com.source.open;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.source.open.exception.EmptyNameException;

@RestController
public class LangController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name", required = false) String name, Locale locale) {
        if (name == null || name.trim().isEmpty()) {
            throw new EmptyNameException("error.empty.name");
        }

        // Get the greeting message in the appropriate language
        String greetingMessage = messageSource.getMessage("greeting.message", new Object[]{name}, locale);
        return greetingMessage;
    }
}
