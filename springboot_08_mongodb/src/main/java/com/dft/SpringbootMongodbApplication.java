package com.dft;

import com.dft.dao.CustomerRepository;
import com.dft.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMongodbApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Nima", "Wang"));
        repository.save(new Customer("Dachui", "Wang"));

        System.out.println("--------------------------------");
        //fetch all customers
        System.out.println("Customer found with findAll():");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        System.out.println("--------------------------------");
        //find an individual customer
        System.out.println("Customer found with findByFirstName('Nima'):");
        System.out.println(repository.findByFirstName("Nima"));

        System.out.println("--------------------------------");
        System.out.println("Customer found with findByLastName('Wang'):");
        System.out.println(repository.findByLastName("Wang"));
//        repository.findByLastName("Wang").forEach(customer -> {
//            System.out.println(customer);
//        });
        System.out.println();
    }
}
