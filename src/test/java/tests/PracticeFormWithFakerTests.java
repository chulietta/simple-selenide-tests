package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormWithFakerTests {

    @Test
    @DisplayName("Fill Form With RandomUtils")
    void positiveFormTest() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = "Female",
                phoneNumber = faker.phoneNumber().subscriberNumber(10),
                dayOfBirth = "06",
                monthOfBirth = "April",
                yearOfBirth = "1993",
                firstSubjectPrefix = "m",
                firstSubject = "Chemistry",
                secondSubjectPrefix = "e",
                secondSubject = "Commerce",
                hobby1 = "Sports",
                hobby2 = "Reading",
                hobby3 = "Music",
                address = faker.address().fullAddress(),
                state = "NCR",
                city = "Delhi",
                pictureName = "pic.jpg";

        // Open form
        open("https://demoqa.com/automation-practice-form");
        $("h5").shouldHave(text("Student Registration Form"));

        // Fill form
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").val(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--006").click();
        $("#subjectsInput").val(firstSubjectPrefix);
        $(".subjects-auto-complete__menu-list").$(byText(firstSubject)).click();
        $("#subjectsInput").val(secondSubjectPrefix);
        $(".subjects-auto-complete__menu-list").$(byText(secondSubject)).click();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();
        $("#uploadPicture").uploadFromClasspath(pictureName);
        $("#currentAddress").scrollTo().val(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").scrollTo().click();

        // Asserts
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(phoneNumber));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(firstSubject + ", " + secondSubject));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1 + ", " + hobby2 + ", " + hobby3));
        $x("//td[text()='Picture']").parent().shouldHave(text(pictureName));
        $x("//td[text()='Address']").parent().shouldHave(text(address));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }
};
