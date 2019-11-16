package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;


// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private Object[] arr;

    public FilterDecorator(SmartArray sa, MyPredicate pr) {
        super(sa);
        Object[] array = sa.toArray();
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (pr.test(array[i])) {
                arrayList.add(array[i]);
            }
        }
        this.arr = arrayList.toArray();
        this.smartArray = new BaseArray(this.arr);

    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.arr, this.arr.length);
    }

    @Override
    public String operationDescription() {
        return "FilterDecorator. Applied MyPredicate to filter the SmartArray.. ";
    }

    @Override
    public int size() {
        return this.arr.length;
    }
}
