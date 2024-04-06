package top.ailvcheng.t0406_annotation.annoattion;

import java.lang.annotation.Annotation;

class Main {
    public static void main(String[] args) {
        System.out.println("子类是否有注解：" + Son.class.isAnnotationPresent(A0406Annotation.class));
        System.out.println("父类是否有注解：" + Father.class.isAnnotationPresent(A0406Annotation.class));
        // 父
        System.out.println("父类注解：");
        for (Annotation annotation : Father.class.getAnnotations()) {
            System.out.println(annotation);
        }
        System.out.println("子类注解：");
        // 子  ，可以获得到继承的标记
        for (Annotation annotation : Son.class.getAnnotations()) {
            System.out.println(annotation);
            A0406Annotation a = (A0406Annotation) annotation;
            System.out.printf("value:%s", a.value());
        }
        System.out.println("-----------------Son.class#getDeclaredAnnotations ：");
        // getDeclaredAnnotations 仅能得到 直接标记的
        for (Annotation annotation : Son.class.getDeclaredAnnotations()) {
            System.out.println(annotation);
        }
        System.out.println("-----------------END ");

    }
}
