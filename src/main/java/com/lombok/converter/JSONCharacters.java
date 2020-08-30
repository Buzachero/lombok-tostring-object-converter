package com.lombok.converter;

public enum JSONCharacters {
    CURLY_BRACES_START('(', '{'),
    CURLY_BRACES_END(')', '}'),
    COLON('=', ':');

    private char oldChar;
    private char newChar;

    JSONCharacters(char oldChar, char newChar) {
        this.oldChar = oldChar;
        this.newChar = newChar;
    }

    public char getOldChar() {
        return oldChar;
    }

    public char getNewChar() {
        return newChar;
    }
}
