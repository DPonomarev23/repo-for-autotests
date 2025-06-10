import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestWithJavaFakerForDemoqa extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(TestWIthPageObjectsForDemoqa.class);
    TestData data = new TestData();
    @Test
    public void successfulTest() {


        registationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender()
                .setPhone(data.phoneNumber)
                .setBirthDay(String.valueOf(data.day),data.month, String.valueOf(data.year))
                .setSubjects(data.subject)
                .uploadFile()
                .setAddress(data.address)
                .setStateAndCity(data.state,data.city)
                .submit();

        registationPage.verifyResultModalComponent("Mobile",data.phoneNumber);
    }
}
