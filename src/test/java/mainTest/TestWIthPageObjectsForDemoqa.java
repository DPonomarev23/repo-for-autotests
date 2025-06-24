package mainTest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TestWIthPageObjectsForDemoqa extends TestBase {


    private static final Logger log = LoggerFactory.getLogger(TestWIthPageObjectsForDemoqa.class);
    @Test
    public void successfulTest() {

        String firstName = "John";
        String lastName =  "Ivanov";
        String email = "dadad@mail.ru";
        String phoneNumber = "1412414214";
        String day = "16";
        String month = "January";
        String year = "1997";
        String subject = "Hindi";
        String address = "фыафыа";
        String state = "Uttar Pradesh";
        String city = "Agra";

        registationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender()
                .setPhone(phoneNumber)
                .setBirthDay(day,month,year)
                .setSubjects(subject)
                .uploadFile()
                .setAddress(address)
                .setStateAndCity(state,city)
                .submit();

        registationPage.verifyResultModalComponent("Mobile","1412414214");
    }
}


