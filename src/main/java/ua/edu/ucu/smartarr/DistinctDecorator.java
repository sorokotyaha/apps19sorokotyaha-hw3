package ua.edu.ucu.smartarr;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartarray){
        super(smartarray);
        this.smartArray = getUniqueValues();
    }


     private SmartArray getUniqueValues() {
         List<Object> list = Arrays.asList(this.smartArray.toArray());
         List<Object> deduped = list.stream().distinct().collect(Collectors.toList());
         Object[] unique = deduped.toArray();

        return new BaseArray(unique);

    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.smartArray.toArray(), this.smartArray.size());
    }


    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

}
