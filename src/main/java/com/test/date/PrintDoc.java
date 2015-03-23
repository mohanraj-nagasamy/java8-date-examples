package com.test.date;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Inherited  // for descenders of the annotation to have the @documented feature automatically
@Retention(RetentionPolicy.RUNTIME) // must be there
public @interface PrintDoc {
    String value() default "";
}

