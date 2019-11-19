package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    private int size;
    private Object[] arr;

    public SortDecorator(SmartArray sa, MyComparator mcp) {
        super(sa);
        this.arr = Arrays.stream(sa.toArray()).sorted(mcp).toArray();
        this.size = this.arr.length;
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.arr, this.size);
    }

    @Override
    public String operationDescription() {
        return "\nApplied MyComparator to sort the SmartArray." + this.smartArray.operationDescription();
    }

    @Override
    public int size() {
        return this.size;
    }
}
