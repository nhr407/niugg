package net.modules.java.annotation.otherexample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * http://www.mkyong.com/java/java-custom-annotations-example/
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //can use in method only.
public @interface Test {
	//should ignore this test?
	public boolean enabled() default true;
}
