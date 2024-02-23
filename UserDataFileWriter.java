import java.io.IOException;

public interface UserDataFileWriter {
    void writeUserData(Object userData) throws IOException;
}