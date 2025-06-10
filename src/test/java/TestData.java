import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import java.util.Locale;
import java.util.Random;

public class TestData {
    Faker faker = new Faker(new Locale("en"));
    String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().cellPhone().replaceAll("[^\\d]", "");
    int day = faker.number().numberBetween(1,28);
    String month = months[new Random().nextInt(months.length)];
    int year = faker.number().numberBetween(1960, 2000);
    String address = faker.address().streetAddress();
    String subject = "Hindi";
    String state = "Uttar Pradesh";
    String city = "Agra";
}
