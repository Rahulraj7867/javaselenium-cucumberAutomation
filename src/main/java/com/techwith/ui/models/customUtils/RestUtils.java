package com.techwith.ui.models.customUtils;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
    public static String getFirstName() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return (generatedString);
    }
    public static String getJob() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return (generatedString);
    }
    public static String getId() {
        String generatedString = RandomStringUtils.randomNumeric(1);
        return (generatedString);
    }
}
