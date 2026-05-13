package com.tomp.rolnopol.testdata;

import com.github.javafaker.Faker;

public class UserDataFactory {
    private static final Faker faker = new Faker();

    public static RegisterUserData randomUser() {
        return new RegisterUserData(
                faker.name().firstName() + " " + faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.internet().password()
        );
    }

    public static RegisterUserData randomUserWithoutOptionalFields() {
        return new RegisterUserData(
                null,
                faker.internet().emailAddress(),
                faker.internet().password()
        );
    }
}
