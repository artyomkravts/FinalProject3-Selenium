package ui;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class DataGenerator {

    static Faker faker = new Faker(new Locale("ru"));

    public static String getRandomValidFirstName() {
        return faker.name().firstName();
    }
    public static String getRandomValidEmail() {
        return faker.internet().emailAddress();
    }
    public static String getRandomPassword(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
}
