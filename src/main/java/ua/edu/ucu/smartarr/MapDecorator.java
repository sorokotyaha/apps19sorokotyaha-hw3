package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    private Object[] arr;
    private int size;

    public MapDecorator(SmartArray sa, MyFunction func) {
        super(sa);

        this.arr = this.map(sa, func);
        this.size = this.arr.length;
    }

    public Object[] map(SmartArray sa, MyFunction func){
        Object[] objectArray = sa.toArray();
        for (int i = 0; i < objectArray.length; i++) {
            objectArray[i] = func.apply(objectArray[i]);
        }
        return objectArray;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.arr, this.size);
    }

    @Override
    public String operationDescription() {
        return "\nApplying MyFunction to all the elements of a SmartArray." + this.smartArray.operationDescription();
    }

    @Override
    public int size() {
        return this.size;
    }
}
