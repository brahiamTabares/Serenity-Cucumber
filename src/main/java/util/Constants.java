package util;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;

public class Constants {

    private static final Dotenv dotenv = new DotenvBuilder()
            .filename("dotenv.env")
            .ignoreIfMalformed()
            .ignoreIfMissing()
            .load();

    public static final String BASE_URL_API = dotenv.get("BASE_URL_API");
    public static String getBaseUrlApi() {
        return BASE_URL_API;
    }
}

