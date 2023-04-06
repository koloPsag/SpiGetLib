package com.kolapsag.spiget.request.parameter.validator;

import com.kolapsag.spiget.request.parameter.RequestParameter;

public class ParameterValidator {

    private final String parameters;

    private ParameterValidator(String parameters) { this.parameters = parameters; }

    public static void validateParameters(String parameters) throws IllegalArgumentException {
        new ParameterValidator(parameters).validate();
    }

    private void validate() throws IllegalArgumentException {
        if (isTotallyInvalid()) throw new IllegalArgumentException("Parameters are totally invalid you dumbo");
        checkDeeper();
    }
    private boolean isTotallyInvalid() {
        return parameters == null || parameters.isBlank() || !parameters.contains("=");
    }
    private void checkDeeper() throws IllegalArgumentException {
        boolean shouldThrow = true;
        for (RequestParameter requestParameter : RequestParameter.values) {
            var finder = ParameterDeclarationFinder.findParameter(parameters, requestParameter.getKey() + '=');

            if (cantFindDeclaration(finder)) continue;

            ArgumentValidator.validateArgument(requestParameter, finder.getArgument());

            shouldThrow = false;
        }
        if (shouldThrow) throw new IllegalArgumentException("You screwed up the parameters, you idiot");
    }
    private boolean cantFindDeclaration(ParameterDeclarationFinder finder) { return finder == null; }

}