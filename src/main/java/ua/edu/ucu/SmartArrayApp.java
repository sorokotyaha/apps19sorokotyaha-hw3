package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student)t).getGPA() >= 4 && ((Student)t).getYear() == 2;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student)o1).getSurname().compareTo(((Student)o2).getSurname());
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student)t).getSurname() + " " + ((Student)t).getName();
            }
        };

        SmartArray sa = new BaseArray(students);

        sa = new FilterDecorator(sa, pr);
        sa = new SortDecorator(sa, cmp);
        sa = new MapDecorator(sa, func);
        sa = new DistinctDecorator(sa);

        /*
        ArrayList<String> studentsList = new ArrayList<String>();
        for (int i = 0; i < students.length; i++) {
            if (students[i].getGPA() >= 4 && students[i].getYear() == 2) {
                studentsList.add(students[i].getSurname() + " " + students[i].getName());
            }
        }
        Collections.sort(studentsList);
        List<String> studList = studentsList.stream().distinct().collect(Collectors.toList());
        String[] studentsArray = new String[studList.size()];
        for (int i = 0; i < studList.size(); i++) {
            studentsArray[i] = studList.get(i);
        }*/
        System.out.print(sa.operationDescription());
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
