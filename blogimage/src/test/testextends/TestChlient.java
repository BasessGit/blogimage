package testextends;

public class TestChlient extends TestSuper{
    private  String name = "许静";
    private String Eat = "吃麦当劳";

    public TestChlient(String name,String Eat) {
        this.name = name;
    }

    public TestChlient() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String getEat() {
        return Eat;
    }

    @Override
    public void setEat(String eat) {
        Eat = eat;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestChlient{" +
                "name='" + name + '\'' +
                ", Eat='" + Eat + '\'' +
                '}';
    }
}
