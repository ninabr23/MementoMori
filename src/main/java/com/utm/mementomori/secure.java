package com.utm.mementomori;

import com.utm.mementomori.annotation.ValidPassword;
import com.utm.mementomori.models.Countries;
import org.springframework.lang.NonNull;
import javax.validation.constraints.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
// import java.time.Period;

public class secure implements Serializable {
    @NotEmpty(message = "All lines in form should be filled.")
    private Countries countries;

    @NotEmpty(message = "Name can not be empty.")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Gender should be introduced.")
    private String gender;

    @NotEmpty(message = "All lines in form should be filled.")
//TODO nu mai putin de 3 ani
    private LocalDate birthday;

/*    public int calculateAge(
            LocalDate birthday,
            LocalDate currentDate) {
        int age = Period.between(birthday, currentDate).getYears();
        return age;
    }
    @Min(value = 3, message = "Your age should be greater than 3 years.")
    private int age; */


    @NotEmpty(message = "All lines in form should be filled.")
    private boolean smoking;

    @NotEmpty(message = "All lines in form should be filled.")
    private boolean drinking;

    @NotEmpty(message = "All lines in form should be filled.")
    private boolean healthyFood;

    @NotEmpty(message = "All lines in form should be filled.")
    private boolean sport;

    @NotEmpty(message = "All lines in form should be filled.")
    private String disease;

    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotEmpty(message = "An e-mail is required.")
    private String email;

    @NonNull
    @NotBlank(message = "Password is mandatory")
    @ValidPassword
    private String password;

}

