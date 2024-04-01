package task3;

import java.lang.reflect.Proxy;

public class Fraction implements Fractionable{
    private int num;
    private int denum;

    public Fraction (int num, int denum) {
        this.num=num;
        this.denum=denum;
    }
    @Mutator
    public void setNum(int num) {
        this.num = num;
    }

    @Mutator
    public void setDenum(int denum){
        this.denum=denum;
    }
    @Override
    @Cache
    public double doubleValue() {
        double res= num/denum;
        System.out.println("invoke double value");
        return res;
    }
    public  Object getProxy()
    {
        Class cls = this.getClass();
        return  Proxy.newProxyInstance(cls.getClassLoader(),
                new Class[]{Fractionable.class},
                new FractionableInvHandler(this));
    }
}
