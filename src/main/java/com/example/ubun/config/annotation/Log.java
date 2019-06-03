package com.example.ubun.config.annotation;
import java.lang.annotation.*;

/**
 * 注解本身是没有功能的,和xml一样,是属于元数据,即只有解释数据的功能
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {
    String name() default "";
}
