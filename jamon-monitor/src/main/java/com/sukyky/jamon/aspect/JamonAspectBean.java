package com.sukyky.jamon.aspect;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Aspect for monitoring method invocations within @Jamon.
 *
 * @author huljas
 */
@Component
@Aspect
public class JamonAspectBean {

    @Around(value = "@within(Jamon)")
    public Object monitorClass(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method targetMethod = signature.getMethod();
        Jamon annotation = targetMethod.getAnnotation(Jamon.class);
        if (annotation == null) {
            Class declaringClass = targetMethod.getDeclaringClass();
            annotation = (Jamon) declaringClass.getAnnotation(Jamon.class);
        }
        return doMonitor(proceedingJoinPoint, annotation.value());
    }

    protected Object doMonitor(ProceedingJoinPoint proceedingJoinPoint, String label) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        // In case of proxies we split the ugly $$ part away
        String className = proceedingJoinPoint.getTarget().getClass().getSimpleName().split(Pattern.quote("$$"))[0];
        String methodName = signature.getMethod().getName();
        Monitor monitor = MonitorFactory.startPrimary(label + ": " + className + "." + methodName);
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            monitor.stop();
        }
    }
}
