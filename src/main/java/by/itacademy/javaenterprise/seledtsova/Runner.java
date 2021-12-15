package by.itacademy.javaenterprise.seledtsova;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-aop-config.xml");
        Student student1 = (Student) context.getBean("studentFirst");
        logger.info("{}", student1);
        student1.methodAboutStudentEducation(" 'finance and credit' ", " 'economist' ", 3);
        Student student2 = (Student) context.getBean("studentSecond");
        logger.info("{}", student2);
        student2.methodAboutStudentEducation(" 'marketing' ", " 'marketer-economist' ", 1);

        student2.throwSomeException();

    }
}

