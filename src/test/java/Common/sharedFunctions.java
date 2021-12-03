package Common;

import wiremock.org.apache.commons.lang3.RandomStringUtils;

public class sharedFunctions {

    public static String createRandomString(int length) {
        //this function generates and returns a random string of the length sent in the parameter
        String randomString = RandomStringUtils.randomAlphabetic(length);
        return randomString;
    }
}

