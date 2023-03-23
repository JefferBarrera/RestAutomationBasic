package io.petstore.swagger.testing.utils.enums;

public enum PetEnum {

    ID_PET("1234"),
    ID_CATEGORY("1"),
    NAME_CATEGORY("Mascota"),
    NAME_PET("Natasha"),
    PHOTO_URL("string"),
    ID_TAG("25"),
    NAME_TAG("natis"),
    STATUS("avaible");

    private final String value;

    PetEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

