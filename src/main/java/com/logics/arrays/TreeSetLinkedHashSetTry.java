package com.logics.arrays;

import java.util.*;

public class TreeSetLinkedHashSetTry {
    static class TestData{
        String name;
        int age;
        public TestData(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "TestData{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }


    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{ 0, 0, 0, 1, 2, 3,};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;

      TreeSet<Integer> set1 = new TreeSet<>((a,b)-> a-b);
      set1.add(5);
      set1.add(1);
      set1.add(2);
      set1.add(0);
      System.out.println(set1);
        System.out.println(set1.last());

        List<Integer> list1 = new LinkedList<>(Arrays.asList(new Integer[] {2,3,1,5,9,5}));
        LinkedHashSet<Integer> list2 = new LinkedHashSet<>(Arrays.asList(new Integer[] {2,3,1,5,9,5}));

        System.out.println(list1);
        list2.add(0);
        list2.remove(5);
        System.out.println(list2);


        List<TestData> list3 = new LinkedList<>(
                Arrays.asList(new TestData("A", 20), new TestData("B", 30), new TestData("C", 25))
        );

        System.out.println(list3);

        LinkedHashSet<TestData> list4 = new LinkedHashSet<>(
                Arrays.asList( new TestData("B", 30), new TestData("C", 25), new TestData("A", 20))
        );

        System.out.println(list3.remove(new TestData("A", 20)));

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        TreeMap<TestData, Integer> map = new TreeMap<>(
                (a,b)-> {
                    if(a.age != b.age) {
                        return a.age - b.age; // sort by age
                    }
                    return a.name.compareTo(b.name); // sort by name if ages are equal
                }
        );
        map.put(new TestData("B", 30), 20);
        map.put(new TestData("A", 20), 10);

        System.out.println(map);

    }
}
