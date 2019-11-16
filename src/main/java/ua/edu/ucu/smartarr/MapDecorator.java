package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    private Object[] arr;

    public MapDecorator(SmartArray sa, MyFunction func) {
        super(sa);
        Object[] objectArray = sa.toArray();
        for (int i = 0; i < objectArray.length; i++) {
            objectArray[i] = func.apply(objectArray[i]);
        }
        this.arr = objectArray;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.arr, this.arr.length);
    }

    @Override
    public String operationDescription() {
        return "MapDecorator. Applying MyFunction to all the elements of a SmartArray.. ";
    }

    @Override
    public int size() {
        return this.arr.length;
    }
}
