package io.petstore.swagger.testing.utils.enums;

public enum URLEnum {

    URL_BASE("https://petstore.swagger.io"),
    URI_POST_PET("/v2/pet");

    private String value;

    URLEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
