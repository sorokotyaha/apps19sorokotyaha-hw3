package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    private Object[] arr;

    public SortDecorator(SmartArray sa, MyComparator mcp) {
        super(sa);
        this.arr = Arrays.stream(sa.toArray()).sorted(mcp).toArray();
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.arr, this.arr.length);
    }

    @Override
    public String operationDescription() {
        return " SortDecorator. Applied MyComparator to sort the SmartArray.. ";
    }

    @Override
    public int size() {
        return this.arr.length;
    }
}
