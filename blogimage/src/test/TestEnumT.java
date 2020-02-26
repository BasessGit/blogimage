public class TestEnumT {
    public static void main(String[] args) {
        String s = TestEnum.NONCE.getName();
        System.out.println(s);

        TestEnum testEnum = TestEnum.NONCE;
        testEnum.getName();
        testEnum = TestEnum.SIGNATURE;
        System.out.println(TestEnum.OPENID);
        System.out.println(testEnum);

    }
}
