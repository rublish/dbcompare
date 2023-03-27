package cn.mysql.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 功能描述: <br>
 * 〈If the field use the annotation, means that the field will be ignore to be compared with others.〉
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface CompareIgnore {
}
