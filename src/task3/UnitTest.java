package task3;

import org.junit.Assert;

public class UnitTest {
    @org.junit.jupiter.api.Test
    void checkdoubleValue() {
        Fraction fr=new Fraction(15,3);
        double res=fr.doubleValue();
        Assert.assertEquals(res,5,0.1);
    }
    @org.junit.jupiter.api.Test
    void checkproxyCall() {
        Object pr;
        pr =   new Fraction(80, 4).getProxy();
        double res=((Fractionable)pr).doubleValue();//sout сработал
        Assert.assertEquals(res,20,0.1);
    }
}
