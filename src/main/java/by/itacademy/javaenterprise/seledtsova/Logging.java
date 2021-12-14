package by.itacademy.javaenterprise.seledtsova;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class Logging {

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    @Pointcut("execution(*  by.itacademy.javaenterprise.seledtsova.*.*(..))")
    public void selectAllMethodsAvaliable() {
    }

    @Before("selectAllMethodsAvaliable()")
    public void beforeAdvice() {
        logger.info("Now we are going to initiate student's profile.");
    }

    @After("selectAllMethodsAvaliable()")
    public void afterAdvice() {
        logger.info("Student's profile has been initiated.");
    }

    @AfterReturning(pointcut = "selectAllMethodsAvaliable()", returning = "someValue")
    public void afterReturningAdvice(Object someValue) {
        logger.info("Value: " + someValue.toString());
    }

    @AfterThrowing(pointcut = "selectAllMethodsAvaliable()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(ClassCastException e) {
        logger.info("We have an exception here: " + e.toString());
    }
}

