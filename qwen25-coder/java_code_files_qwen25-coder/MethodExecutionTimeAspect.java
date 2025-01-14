package com.example.monitoring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.jboss.logging.Logger;

@Aspect
public class MethodExecutionTimeAspect {
    private static final Logger logger = Logger.getLogger(MethodExecutionTimeAspect.class);

    @Around("execution(* com.yourpackage..*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            logger.info(joinPoint.getSignature() + " executed in " + (endTime - startTime) + "ms");
        }
    }

    public static void main(String[] args) {
    }
}