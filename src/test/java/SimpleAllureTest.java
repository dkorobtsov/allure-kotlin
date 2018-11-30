import io.qameta.allure.Step;
import org.junit.Test;

public class SimpleAllureTest {

    @Test
    public void simpleAllureTest() {
        step1();
        step2();
        step3();
    }

    @Step
    private void step1() {

    }

    @Step
    private void step2() {

    }

    @Step
    private void step3() {

    }
}
