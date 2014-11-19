
package com.fiona.leetcode;

import java.lang.reflect.Method;
import org.junit.rules.TestName;
import com.google.code.tempusfugit.concurrency.annotations.Intermittent;

public class TestCaseName extends TestName {
    private String className = "unknown";
    private Class<?> creator;

    public TestCaseName(Object callingClass) {
        super();
        if (callingClass != null) {
            this.className = callingClass.getClass().getSimpleName();
            this.creator = callingClass.getClass();
        }
    }

    public int getRepeatCount() {
        try {
            Class<?> param[] = null;
            Method method = creator.getMethod(this.getMethodName(), param);
            Intermittent annotation = method.getAnnotation(Intermittent.class);
            if (annotation != null) {
                return ((Intermittent) annotation).repetition();
            }
        } catch (NoSuchMethodException e) {
            // ignore
        }
        return 1;
    }

    public String getCompleteTestName() {
        return String.format("%s.%s", className, this.getMethodName());
    }

    public String getClassName() {
        return className;
    }
}
