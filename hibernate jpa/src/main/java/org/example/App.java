package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        try {

            // Get context
            ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/org/example/h-beans.xml");

            // create dao object
            Dao dao = context.getBean("userDao", Dao.class);

            // create object to persist
            User person = new User();
            person.setName("foo");
            person.setAge(22);
            person.setEmail("webfil303@gmail.com");

            // use dao to persist object
            dao.save(person);
            System.out.println("Person Saved: " + person.toString());

            // close context
            ((ConfigurableApplicationContext) context).close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
