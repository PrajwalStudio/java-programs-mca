package innerouter;

class Outer {
    
    int outdata = 10;
    Inner Ob1 = new Inner();

    void OutDisplay() {
        System.out.println("Acccessing from Outer Class");
        System.out.println("Outer class data:" + outdata);
        System.out.println("Inner class data:" + Ob1.innerdata);
    }

    class Inner {

        int innerdata = 20;

        void InDisplay() {
            System.out.println("Accesing from Inner Class");
            System.out.println("Outer class data:" + outdata);
            System.out.println("Inner class data:" + innerdata);
        }

    }
}

public class InnerOuter {

    public static void main(String[] args) {
        Outer out = new Outer();
        out.OutDisplay();
        Outer.Inner in = out.new Inner();
        in.InDisplay();

    }

}
