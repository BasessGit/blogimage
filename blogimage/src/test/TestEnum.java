public enum TestEnum {
    SIGNATURE("signature"),
    TIMESTAMP("timestamp"),
    NONCE("nonce"),
    OPENID("openid");
    private String name;

    TestEnum(String name) {
        this.name = name;
    }

    TestEnum() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
