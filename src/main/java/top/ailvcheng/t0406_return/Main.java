package top.ailvcheng.t0406_return;

import cn.hutool.core.lang.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * @ClassName Main
 * @Description return 和 finally，及 finally中有return
 * @Version 1.0
 **/
class Main {
    /**
     * return 和 finally
     *
     * @return
     */
    private static TestClass test(Integer num) {
        final TestClass.TestClassBuilder builder = TestClass.builder()
                .name("test");
        try {
            Assert.notNull(num, "num is null");
            System.out.println("1执行了");
            return builder.num(num).build();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            builder.num(333);
            System.out.println("2执行了 ");
            System.out.println(builder.build());
        }
        return builder.build();
    }

    private static TestClass test2(Integer num) {
        final TestClass.TestClassBuilder builder = TestClass.builder()
                .name("test");
        try {
            Assert.notNull(num, "num is null");
            builder.num(num);
            System.out.println("1执行了");
            return builder.build();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("2执行了");
            // finally中有return语句
            return builder.num(-1).build();
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    private static class TestClass {
        private String name;
        private Integer num;
    }

    public static void main(String[] args) {
        System.out.printf("test num :%s\n", test(1));
        System.out.println("---------\n");
        // finally中有return ，返回结果受影响
        System.out.printf("test num :%s\n", test2(99));
        System.out.println("===================");
        // 断言null
        System.out.printf("test num :%s\n", test(null));
        System.out.printf("test num :%s\n", test2(null));
    }
}
