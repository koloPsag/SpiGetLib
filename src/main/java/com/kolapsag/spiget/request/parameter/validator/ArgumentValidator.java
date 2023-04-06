package com.kolapsag.spiget.request.parameter.validator;

import com.kolapsag.spiget.request.parameter.RequestParameter;

public class ArgumentValidator {

    private final RequestParameter param;
    private final String value;

    private ArgumentValidator(RequestParameter param, String value) { this.param = param; this.value = value; }

    public static void validateArgument(RequestParameter param, String value) throws IllegalArgumentException {
        new ArgumentValidator(param, value).validate();
    }

    private void validate() {
        switch (param) {
            case FIELD -> validateFixedValues("name", "tag");
            case METHOD -> validateFixedValues("any", "all");
            case SORT -> validateFixedValues("+", "-");
            case SIZE, PAGE -> validateNumericArgument();
            case FIELDS -> validateFieldsArgument();
        }
    }
    private void validateFixedValues(String s1, String s2) {
        if (!(value.equals(s1) || value.equals(s2)))
            throw new IllegalArgumentException("Argument isn't either: " + s1 + " or " + s2);
    }
    private void validateNumericArgument() {
        try { Double.parseDouble(value); }
        catch (NumberFormatException nfe) { throw new IllegalArgumentException("Argument isn't a valid numeric value"); }
    }
    private void validateFieldsArgument() {
        if (value.contains(" ")) throw new IllegalArgumentException("Fields's argument mustn't contain spaces");
    }

}