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

        ((Fractionable)pr).setNum(100);
        System.out.println("---------------------");
        long lStartTime = System.nanoTime();
        //task
        ((Fractionable)pr).doubleValue();//sout сработал
        //end
        long lEndTime = System.nanoTime();
        //time elapsed
        long output = lEndTime - lStartTime;
        System.out.println("Elapsed time for Envoked: " + output);

        long lStartTime1 = System.nanoTime();
        //task
        ((Fractionable)pr).doubleValue();//sout молчит
        //end
        long lEndTime1 = System.nanoTime();
        //time elapsed
        long output1 = lEndTime1 - lStartTime1;
        System.out.println("Elapsed time for Cached: " + output );

    }
}