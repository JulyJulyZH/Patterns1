package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import ru.netology.delivery.data.DataGenerator.UserInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {

    }

    public static String generateDate(int number) {
        String date = LocalDate.now().plusDays(number).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {

        String[] cities = new String[]{"Москва", "Санкт-Петербург", "Екатеринбург", "Нижний Новгород", "Новосибирск", "Владивосток"};
        String city = cities[new Random().nextInt(cities.length)];
        return city;
    }

    public static String generateName(String locale) {
        Faker fake = new Faker(new Locale(locale));
        String name = fake.name().lastName() + " " + fake.name().firstName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker fake = new Faker(new Locale(locale));
        String phone = fake.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
