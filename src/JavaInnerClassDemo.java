public class JavaInnerClassDemo {

    private Float mOuterValue;

    JavaInnerClassDemo() {
        Inner i = new Inner();
        i.mInnerValue = 4;
    }

    private class Inner {
        private Integer mInnerValue;

        Inner() {
            mOuterValue = 5f;
        }
    }

    public static void main(String[] args) {

    }
}
