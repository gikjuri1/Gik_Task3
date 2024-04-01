package task3;

import lombok.EqualsAndHashCode;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode
public class State {
    //Для каждого метода - свой набор объектов - значений свойств
    private final Map<Method, List<Object>> values = new HashMap<>();

    //берем из старого и добавляем/обновляем новое состояние
    public State(State oldState, Method method, Object[] args) {
        values.putAll(oldState.values);
        values.put(method, Arrays.asList(args));
    }

    public State(){};
}
