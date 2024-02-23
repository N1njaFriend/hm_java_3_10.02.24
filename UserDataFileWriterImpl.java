import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserDataFileWriterImpl implements UserDataFileWriter {

    @Override
    public void writeUserData(Object userData) throws IOException {
        // Cast the userData object to UserData
        UserData data = (UserData) userData;

        String fileName = null;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите имя файла для записи пользовательских данных: ");
            fileName = scanner.nextLine();
        }

        try (FileWriter writer = new FileWriter(fileName, true)) {
            String userDataString = String.join(" ",
                    data.getLastName(),
                    data.getFirstName(),
                    data.getMiddleName(),
                    data.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    String.valueOf(data.getPhoneNumber()),
                    data.getGender().toString());
            writer.write(userDataString + "\n");
            System.out.println("Пользовательские данные успешно записаны в файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка записи пользовательских данных в файл: " + e.getMessage());
            throw e;
        }
    }
}