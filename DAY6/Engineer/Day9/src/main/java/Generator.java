import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.RandomStringUtils;

public class Generator {
    public static String generateLogin(int login) {
        return RandomStringUtils.randomAlphabetic(login);
    }
    public static String generatePassword(int password) {
        return RandomStringUtils.randomAlphabetic(password);
    }

}
