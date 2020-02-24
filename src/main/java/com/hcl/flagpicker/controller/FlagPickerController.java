package com.hcl.flagpicker.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.hcl.domain.Country;
import com.hcl.flagpicker.service.FlagPickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class FlagPickerController {

    @Autowired
    FlagPickerService flagPickerService;


    /**
     * Return list of continents
     *
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/continents", method = GET)
    @ResponseBody
    public List<String> getContinents() {

        return flagPickerService.getContinents();
    }

    /**
     * Return list of countries
     *
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/continents/{continent}", method = GET)
    @ResponseBody
    public List<Country> getCountries(@PathVariable String continent) throws JsonProcessingException {

        return flagPickerService.getCountries(continent);
    }

    /**
     * Return flag of country.
     *
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/continents/{continent}/country/{countryName}", method = GET)
    @ResponseBody
    public String getFlag(@PathVariable String continent,@PathVariable String countryName) throws JsonProcessingException {

        return flagPickerService.getFlag(continent,countryName);
    }


}