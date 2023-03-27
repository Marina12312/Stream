import jdk.jfr.Threshold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Stream<Integer> stream= new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 13, 21)).stream();
        findMinMax(
        stream,
        (x,y)->x.compareTo(y),
                (x,y)->System.out.println("мин"+x+"мах"+y));
        stream.close();

        List<Integer> even= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Long count=evenNumbers(even);
        System.out.println("КОл-во четных числен" +count);
    }


    public static <T > void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer){
        List<T> elements = stream.sorted(order).collect(Collectors.toList());
        if (!elements.isEmpty()){
            minMaxConsumer.accept(elements.get(0),elements.get(elements.size()-1));
        }else {
            minMaxConsumer.accept(null,null);
        }
    }
    public static Long evenNumbers (List <Integer> even){
return even.stream()
                .filter(num -> num % 2 == 0)
                        .peek(num->System.out.println(num))
        .count();

        }


    }

