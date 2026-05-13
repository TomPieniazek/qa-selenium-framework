package com.tomp.rolnopol.context;

import com.tomp.rolnopol.testdata.RegisterUserData;

public class ScenarioContext {
    private static final ThreadLocal<RegisterUserData> userData = new ThreadLocal<>();

    public static void setUserData(RegisterUserData user) {
        userData.set(user);
    }

    public static RegisterUserData getUserData() {
        return userData.get();
    }

    public static void clearUserData() {
        userData.remove();
    }
}
