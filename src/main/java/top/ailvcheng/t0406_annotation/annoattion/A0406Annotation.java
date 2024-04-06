package top.ailvcheng.t0406_annotation.annoattion;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
//注解可继承
@Inherited
@interface A0406Annotation {
    String value();
}
