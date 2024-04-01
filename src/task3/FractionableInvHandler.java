package task3;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FractionableInvHandler implements InvocationHandler {
    private Object obj;
    private int modCount=1;
    private Object cachedVal;

    FractionableInvHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println("It works");
        Method m = obj.getClass().getMethod(method.getName(), method.getParameterTypes());

        Annotation[] anns = m.getDeclaredAnnotations();
        if (m.isAnnotationPresent(Cache.class)) {
            if (modCount>0){
                //Вызываем метод
                System.out.println("Not cached val:");
                cachedVal = method.invoke(obj, args);
                //Обнуляем счетчик кэша
                modCount=0;
                return cachedVal;
            }
            else{
                //Берем значение из кэша
                System.out.println("Cached val:");
                return cachedVal;
            }
        }
        if (m.isAnnotationPresent(Mutator.class)) {
            //Увеличиваем счетчик кэша, вызываем метод
            modCount++;
            System.out.println("Not cached val from mutator");
            return method.invoke(obj, args);
        }

        return method.invoke(obj, args);
    }
}
