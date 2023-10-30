package day28;

interface One {
    public Inner getInner();

    interface Inner {
        public void show();
    }
}

class OneImpl implements One {

    @Override
    public Inner getInner() {
        return new InnerImpl();
    }

    class InnerImpl implements Inner {

        @Override
        public void show() {
            System.out.println("Inner Class Show Method.");
        }
    }
}

public class MapExample2 {
    public static void main(String[] args) {
        One one = new OneImpl();
        One.Inner inner = one.getInner();
        inner.show();
    }
}
