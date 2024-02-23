import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserData {
  static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
  private static final int PHONE_NUMBER_LENGTH = 11;

  private String lastName;
  private String firstName;
  private String middleName;
  private LocalDate dateOfBirth;
  private long phoneNumber;
  private Gender gender;

  public UserData(String lastName, String firstName, String middleName, LocalDate dateOfBirth,
                   long phoneNumber, Gender gender) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.middleName = middleName;
    this.dateOfBirth = dateOfBirth;
    this.phoneNumber = phoneNumber;
    this.gender = gender;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public long getPhoneNumber() {
    return phoneNumber;
  }

  public Gender getGender() {
    return gender;
  }

  public static LocalDate validateDateOfBirth(String dateOfBirthString) {
    try {
      return LocalDate.parse(dateOfBirthString, DATE_FORMATTER);
    } catch (Exception e) {
      throw new IllegalArgumentException("Неверный формат даты рождения. Введите дату рождения в формате дд.мм.yyyy.");
    }
  }

  public static long validatePhoneNumber(String phoneNumberString) {
    try {
      if (phoneNumberString.length() != PHONE_NUMBER_LENGTH) {
        throw new IllegalArgumentException("Неверная длина номера телефона. Введите номер телефона длиной " + PHONE_NUMBER_LENGTH + " цифр.");
      }
      return Long.parseLong(phoneNumberString);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Неверный формат номера телефона.");
    }
  }

  public static Gender validateGender(String genderString) {
    if (genderString.equalsIgnoreCase("m")) {
      return Gender.MALE;
    } else if (genderString.equalsIgnoreCase("f")) {
      return Gender.FEMALE;
    } else {
      throw new IllegalArgumentException("Неверный формат пола. Введите 'f' для женского пола или 'm' для мужского пола.");
    }
  }
}