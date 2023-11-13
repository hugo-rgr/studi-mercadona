package com.example.studimercadonafinal.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AdminDataLoader implements CommandLineRunner {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminDataLoader(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void run(String... args){

        Admin admin1 = new Admin();
        admin1.setLogin("admin");
        admin1.setPass("lorem5ipsum");
        adminRepository.save(admin1);

        Admin admin2 = new Admin();
        admin2.setLogin("john_doe");
        admin2.setPass("coolmdp");
        adminRepository.save(admin2);

    }
}

