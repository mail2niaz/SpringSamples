package com.example.demo;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MyDataLoader implements ApplicationRunner {

    @Autowired
    private CountryRepository userRestRepo;

    @Override
    public void run(ApplicationArguments args) {
        List<String[]> strings = Arrays.asList(new String[][]{{"a", "a"}, {"b", "b"}, {"c", "c"}, {"d", "d"}, {"e", "e"}, {"f", "f"}, {"g", "g"}, {"h", "h"}, {"i", "i"}, {"j", "j"}});
        strings.forEach(a -> userRestRepo.save(new Country(a[0], a[1])))
        ;
    }
}
