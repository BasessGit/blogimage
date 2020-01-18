package testextends;

public class TestSuper {
    private String eat = "吃大米";
    String slpper ="睡觉觉";

    public TestSuper() {
    }

    public TestSuper(String eat, String slpper) {
        this.eat = eat;
        this.slpper = slpper;
    }

    public String getEat() {
        return eat;
    }

    public String getSlpper() {
        return slpper;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public void setSlpper(String slpper) {
        this.slpper = slpper;
    }

    @Override
    public String toString() {
        return "TestSuper{" +
                "eat='" + eat + '\'' +
                ", slpper='" + slpper + '\'' +
                '}';
    }
}
