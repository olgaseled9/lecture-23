package by.itacademy.javaenterprise.seledtsova;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(*  by.itacademy.javaenterprise.seledtsova.*.*(..))")
    private void selectAll() {
    }

    @Before("selectAll()")
    public void beforeAdvice() {
        logger.info("Now we are going to create  student's profile.");
    }

    @After("selectAll()")
    public void afterAdvice() {
        logger.info("Student's profile has been created.");
    }

    @AfterReturning(pointcut = "selectAll()", returning = "someValue")
    public void afterReturningAdvice(Object someValue) {
        logger.info("Value: " + someValue.toString());
    }

    @AfterThrowing(pointcut = "selectAll()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(ClassCastException e) {
        logger.info("Here we have an exception: " + e.toString());
    }

    @Pointcut("execution(public String by.itacademy.javaenterprise.seledtsova.Student.methodAboutStudentEducation(String, String, Integer))")
    public void methodWithParameters() {
    }

    @Around("methodWithParameters()")
    public Object aroundMethodExecution(ProceedingJoinPoint joinPoint) {
        try {
            long start = System.currentTimeMillis();
            Object res = joinPoint.proceed();
            long end = System.currentTimeMillis();
            logger.info("Execution of method " + joinPoint.getSignature()
                    + " took " + (end - start) + " msec.");
            return res;
        } catch (
                Throwable throwable) {
            logger.error(throwable.toString());
        }
        return null;
    }
}


