package Common;

import wiremock.org.apache.commons.lang3.RandomStringUtils;

public class sharedFunctions {

    public static String createRandomString(int length){
        String randomString = RandomStringUtils.randomAlphabetic(length);
        return randomString;
    }
}

