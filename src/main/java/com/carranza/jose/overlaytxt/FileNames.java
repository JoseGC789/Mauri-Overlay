package com.carranza.jose.overlaytxt;

public enum FileNames {
    PATH_FILE_NAME("Path"),
    PLAYER("Player Name"),
    SCORE("Player Score"),
    EXTRA("EXTRA");

    private String value;

    FileNames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}