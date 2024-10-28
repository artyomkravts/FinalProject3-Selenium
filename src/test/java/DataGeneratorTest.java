import ui.DataGenerator;

public class DataGeneratorTest {

    @org.junit.Test
    public void test() {
        System.out.println(DataGenerator.getRandomValidFirstName());
        System.out.println(DataGenerator.getRandomValidEmail());
        System.out.println(DataGenerator.getRandomPassword(0));
    }
}
