package pl.javastart.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.javastart.common.Lang;
import pl.javastart.constraint.NotBadWord;

public class BadWordValidator implements ConstraintValidator<NotBadWord, String> {

    private Lang[] languages;

    @Override
    public void initialize(NotBadWord annotation) {
        this.languages = annotation.lang();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valid = true;
        for(Lang lang: languages) {
            if(lang == Lang.PL)
                valid &= plFilter(value);
            if(lang == Lang.EN)
                valid &= enFilter(value);
        }
        return valid;
    }

    private boolean plFilter(String text) {
        List<String> badWords = Arrays.asList("kurka", "cholercia");
        return generalFilter(text, badWords);
    }

    private boolean enFilter(String text) {
        List<String> badWords = Arrays.asList("fak");
        return generalFilter(text, badWords);
    }

    private boolean generalFilter(String text, List<String> badWords) {
        List<String> found = badWords
                                .stream()
                                .filter(word -> text
                                                .toLowerCase()
                                                .contains(word))
                                .collect(Collectors.toList());
        return found.isEmpty();
    }
}