package ua.edu.ucu.smartarr;


import java.util.Arrays;
import java.util.List;


// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private int size;
    private Object[] unique;

    public DistinctDecorator(SmartArray smartarray) {
        super(smartarray);
        this.unique = this.getUniqueValues();
        this.size = this.unique.length;
    }

    private Object[] getUniqueValues() {
        List<Object> list = Arrays.asList(this.smartArray.toArray());
        return list.stream().distinct().toArray();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.unique, this.size);
    }


    @Override
    public String operationDescription() {
        return "\nCleared from repeated values." + this.smartArray.operationDescription();
    }

    @Override
    public int size() {
        return this.size;
    }

}
