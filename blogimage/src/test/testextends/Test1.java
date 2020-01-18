package testextends;

public class Test1 {
    public static void main(String[] args) {
        TestChlient testChlient = new TestChlient();
        System.out.println("我是"+testChlient.getName()+"我在"+testChlient.getSlpper()+"我喜欢"+testChlient.getEat());
        testChlient.getSlpper();
        testChlient.getEat();
    }
}
