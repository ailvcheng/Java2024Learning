package top.ailvcheng.t0407_lamda;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Main {
    public static void main(String[] args) {
        //        test(args);
        //        test_2(args);
        //        test2(args);
        test2_2(args);
    }

    /**
     * 1. 匿名内部类1
     *
     * @param args
     */
    private static void test(String[] args) {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start Thread; 匿名内部类方式");
            }
        });
        thread.start();
    }

    /**
     * 1. 匿名内部类2
     * new 抽象类
     *
     * @param args
     */
    private static void test_2(String[] args) {
        final AbstractList<String> strList = new AbstractList<String>() {
            private final String[] data = {"1", "2", "3"};

            @Override
            public int size() {
                return this.data.length;
            }

            @Override
            public String get(int index) {
                return this.data[index];
            }
        };
        strList.forEach(System.out::println);
    }

    /**
     * 2. Lamda 表达式/函数
     *
     * @param args
     */
    private static void test2(String[] args) {
        final Thread thread = new Thread(() -> System.out.println("Start Thread;拉姆达表达式"));
        thread.start();
    }

    /**
     * 2 匿名内部类，带参数
     * 2.1 自定义比较器(lamda)
     * 2.2 lamda表达式直接还原成类实现
     * lamd简化过程 ：
     * -> 定义接口，实现类
     * -> 由于想简化类的创建，直接new 接口 ,即简化为匿名内部类
     * -> 因接口中方法只有一个，可以标记为 函数式接口(注解：FunctionalInterface) ，lamda
     *
     * @param args
     */
    private static void test2_2(String[] args) {
        final List<String> list = new ArrayList<String>() {{
            add("lamda");
            add("expression");
            add("function");
        }};
        // list2
        final List<String> list2 = new ArrayList<>(list);
        // 排序前
        System.out.print("list排序前: ");
        list.forEach(System.out::print);

        System.out.println("");
        Collections.sort(list, (e1, e2) -> {
            if (e1 == null) {
                return -1;
            }
            if (e2 == null) {
                return 1;
            }
            return e1.length() - e2.length();
        });
        // 排序后
        System.out.print("list排序后： ");
        list.forEach(System.out::print);
        System.out.println("\n ==================================");

        System.out.print("list2排序前: ");
        list2.forEach(System.out::print);
        System.out.println("");
        Collections.sort(list2, new Test2_2_sort());
        System.out.print("list2排序后： ");
        list2.forEach(System.out::print);
    }

    /**
     * 2. test2_2中的lamda表达式提取出来，直接还原成类
     */
    private static class Test2_2_sort implements Comparator<String> {
        @Override
        public int compare(String e1, String e2) {
            if (e1 == null) {
                return -1;
            }
            if (e2 == null) {
                return 1;
            }
            return e1.length() - e2.length();
        }
    }
}
