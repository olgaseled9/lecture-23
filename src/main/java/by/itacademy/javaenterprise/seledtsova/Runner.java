package by.itacademy.javaenterprise.seledtsova;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-student-config.xml");
        Student student = (Student) context.getBean("student");
        logger.info("{}", student);
        student.throwSomeException();
        student.methodWithThreeParameters("Finance and credit","Economist",3);


    }
}

