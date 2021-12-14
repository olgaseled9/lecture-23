package by.itacademy.javaenterprise.seledtsova;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class Logging {

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    @Pointcut("execution(*  by.itacademy.javaenterprise.seledtsova.*.*(..))")
    private void selectAll() {
    }

    @Before("selectAll()")
    public void beforeAdvice() {
        logger.info("Now we are going to initiate student's profile.");
    }

    @After("selectAll()")
    public void afterAdvice() {
        logger.info("Student's profile has been launched.");
    }

    @AfterReturning(pointcut = "selectAll()", returning = "someValue")
    public void afterReturningAdvice(Object someValue) {
        logger.info("Value: " + someValue.toString());
    }

    @AfterThrowing(pointcut = "selectAll()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(ClassCastException e) {
        logger.info("Here we have an exception: " + e.toString());
    }

    @Pointcut("execution(public String by.itacademy.javaenterprise.seledtsova.Student.methodWithThreeParameters(String, String, Integer))")
    public void methodWithParameters() {
    }

    @Around("methodWithParameters()")
    public void aroundMethodWithArguments(ProceedingJoinPoint joinPoint) {
        try {
            logger.info("Start");
            logger.info("Begin time: " + System.currentTimeMillis());
            String result = (String) joinPoint.proceed();
            logger.info("Finish time: " + System.currentTimeMillis());
            logger.info("Status: " + result);
        } catch (Throwable throwable) {
            logger.error(throwable.toString());
        }
    }
}

