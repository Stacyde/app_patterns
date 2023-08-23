package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity() {
        // var faker = new Faker(new Locale("ru"));
        //String city = faker.address().city();
        List<String> list = Arrays.asList("Майкоп", "Улан-Удэ", "Симферополь", "Саранск",
                "Грозный", "Петропавловск-Камчатский", "Астрахань", "Калининград", "Калуга", "Санкт-Петербург", "Москва",
                "Оренбург", "Ростов-на-Дону", "Саратов", "Саранск", "Ульяновск", "Хабаровск", "Херсон", "Санкт-Петербург",
                "Биробиджан", " Салехард","Нижний Новгород");
        Random rand = new Random();
        String city = list.get(rand.nextInt(list.size()));

        return city;


    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale("ru"));
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale("ru"));
        String phone = faker.phoneNumber().phoneNumber();
        // String phone = faker.numerify("+7##########");
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}