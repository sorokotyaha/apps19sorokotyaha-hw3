package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;


// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private Object[] arr;
    private int size;

    public FilterDecorator(SmartArray sa, MyPredicate pr) {
        super(sa);
        this.arr = this.filter(sa, pr);
        this.size = this.arr.length;
    }

    public Object[] filter(SmartArray sa, MyPredicate pr){

        Object[] array = sa.toArray();
        ArrayList<Object> arrayList = new ArrayList<>();
        for (Object o : array) {
            if (pr.test(o)) {
                arrayList.add(o);
            }
        }
        return arrayList.toArray();

    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.arr, this.size);
    }

    @Override
    public String operationDescription() {
        return "\nApplied MyPredicate to filter the SmartArray." + this.smartArray.operationDescription();
    }

    @Override
    public int size() {
        return this.size;
    }
}
