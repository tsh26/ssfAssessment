package vttp.ssf.assessment.eventmanagement.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormData {

    @NotBlank(message = "Name is required")
    @Size(min = 5, max = 25, message = "Min 5 characters, Max 25 characters.")
    private String name;

    @Past(message = "Date of Birth must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @NotBlank(message = "Email is required")
    @Email
    @Size(max = 50, message = "Max 50 characters")
    private String email;

    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Invalid phone number entered")
    private String mobileNumber;

    @NotBlank(message = "Gender is required")
    private String gender;

    @Min(value = 1, message= "At least 1 ticket required")
    @Max(value = 3, message= "Max 3 tickets allowed")
    private int numberOfTickets;

}