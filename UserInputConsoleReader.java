import java.time.LocalDate;
import java.util.Scanner;

public class UserInputConsoleReader implements UserInputReader {
  private Scanner scanner;

  public UserInputConsoleReader(Scanner scanner) {
    this.scanner = scanner;
  }

  @Override
  public UserData readUserData() throws UserDataException {
    while (true) {
      System.out.println("Введите данные в следующем порядке, разделяя их пробелом: Фамилия Имя Отчество Дата рождения (dd.mm.yyyy) Номер телефона Пол (f или m)");

      try {
        String input = scanner.nextLine();
        String[] data = input.split(" ");

        if (data.length != 6) {
          throw new UserDataException("Введено неверное количество данных.");
        }

        LocalDate dateOfBirth = UserData.validateDateOfBirth(data[3]);
        long phoneNumber = UserData.validatePhoneNumber(data[4]);
        Gender gender = UserData.validateGender(data[5]);

        return new UserData(data[0], data[1], data[2], dateOfBirth, phoneNumber, gender);
      } catch (IllegalArgumentException e) {
        System.out.println("Ошибка: " + e.getMessage());
      }
    }
  }
}