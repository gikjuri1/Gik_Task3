import task3.Fraction;
import task3.Fractionable;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Fraction fr=new Fraction(15,3);
        fr.doubleValue();
        fr.setNum(6);
        System.out.println("---------------------");
        Object pr;
        pr =   new Fraction(80, 4).getProxy();
        ((Fractionable)pr).doubleValue();//sout сработал
        ((Fractionable)pr).doubleValue();//sout молчит
        ((Fractionable)pr).doubleValue();//sout молчит
        ((Fractionable)pr).setNum(16);
        ((Fractionable)pr).doubleValue();//sout сработал
        ((Fractionable)pr).doubleValue();//sout молчит
    }
}