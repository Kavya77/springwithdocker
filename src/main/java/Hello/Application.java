package Hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private StudentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of Students
        repository.save(new Student("Alice", "Smith"));
        repository.save(new Student("Bob", "Smith"));

        // fetch all Students
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Student student : repository.findAll()) {
            System.out.println(student);
        }
        System.out.println();

        // fetch an individual Student
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Student student : repository.findByLastName("Smith")) {
            System.out.println(student);
        }

    }

}