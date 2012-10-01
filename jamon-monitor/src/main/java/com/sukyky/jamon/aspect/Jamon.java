package com.sukyky.jamon.aspect;

import java.lang.annotation.*;

/**
 * Annotation for monitoring spring beans with Jamon.
 *
 * @author huljas
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Jamon {
    String value() default "Annotation";
}
