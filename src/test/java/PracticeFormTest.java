import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillPracticeForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Dmitrii");
        $("#lastName").setValue("Borovkov");
        $(".col-md-9.col-sm-12 #userEmail").setValue("dmitry@borovkov.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9269262626");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1987")).click();
        $(".react-datepicker__month-select").$(byText("February")).click();
        $(".react-datepicker__month").$(byText("26")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("brain.jpg");
        $("#currentAddress").setValue("The Street, 9");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("Dmitrii Borovkov"));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("dmitry@borovkov.com"));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("9269262626"));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("26 February,1987"));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Maths"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Music"));
        $(".table").shouldHave(text("Picture")).shouldHave(text("brain.jpg"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text("The Street, 9"));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("NCR Noida"));
    }
}

