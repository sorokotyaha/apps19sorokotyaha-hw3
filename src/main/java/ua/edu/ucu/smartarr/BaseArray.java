package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    protected Object[] myArray;

    public BaseArray() {
    }

    public BaseArray(Object[] mass) {
        this.myArray = mass;
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.myArray, this.myArray.length);
    }

    @Override
    public String operationDescription() {
        return "\nCreated SmartArray.";
    }

    @Override
    public int size() {
        return this.myArray.length;
    }
}
