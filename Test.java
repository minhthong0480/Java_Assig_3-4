import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

        import java.io.FileNotFoundException;

class EnrolmentManagerTest {

    private static Enrolmanager enrolment = new Enrolmanager();

    @BeforeAll
    static void beforeAll() throws FileNotFoundException {
        enrolment.readData("default");

    }

    @Test
    void testAdd() {}