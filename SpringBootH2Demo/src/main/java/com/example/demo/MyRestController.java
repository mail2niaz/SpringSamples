package com.example.demo;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping(path = "/rest")
    public Page<Country> getCountries(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {
//        countryRepository.findAll()
        Sort sort = Sort.by("id").descending();
        Pageable firstPageWithTwoElements = PageRequest.of(page, size,sort);
        return countryRepository.findAll(firstPageWithTwoElements);
    }


}
