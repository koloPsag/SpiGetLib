package com.kolapsag.spiget.request.parameter.validator;

public class ParameterDeclarationFinder {

    private final String stringToSearchIn;
    private final String whatToFind;

    private int parameterDeclarationStartIndex;
    private int nextParameterDeclarationIndex;
    private String argument;

    private ParameterDeclarationFinder(String stringToSearchIn, String whatToFind) {
        this.stringToSearchIn = stringToSearchIn; this.whatToFind = whatToFind;
    }

    public static ParameterDeclarationFinder findParameter(String stringToSearchIn, String whatToFind) {
        return new ParameterDeclarationFinder(stringToSearchIn, whatToFind).find();
    }

    private ParameterDeclarationFinder find() {
        parameterDeclarationStartIndex = stringToSearchIn.indexOf(whatToFind);

        if (parameterDoesntExistInString()) return null;

        nextParameterDeclarationIndex = stringToSearchIn.indexOf('&', parameterDeclarationStartIndex);
        argument = stringToSearchIn.substring(getBeginIndex(), getEndIndex());
        return this;
    }
    private boolean parameterDoesntExistInString() { return parameterDeclarationStartIndex == -1; }
    private int getBeginIndex() { return parameterDeclarationStartIndex + whatToFind.length(); }
    private int getEndIndex() {
        return nextParameterDeclarationIndex == -1 ? stringToSearchIn.length() : nextParameterDeclarationIndex;
    }

    public int getParameterDeclarationStartIndex() { return parameterDeclarationStartIndex; }
    public int getNextParameterDeclarationIndex() { return nextParameterDeclarationIndex; }
    public String getArgument() { return argument; }

}