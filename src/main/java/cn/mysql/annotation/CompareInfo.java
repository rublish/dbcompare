package cn.mysql.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 功能描述: <br>
 * 〈Show the field means in Chinese,you can alse change it in cn.mysql.entity.ColumnProp 〉
 *   {@link cn.mysql.entity.ColumnProp}
 * @Param:
 * @Return:
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface CompareInfo {
    public String mean() default "";
}
