package com.hcl.flagpicker.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hcl.domain.ContinentStructure;
import com.hcl.domain.Country;
import com.hcl.flagpicker.mapper.FlagInfoObjectMapper;
import com.hcl.flagpicker.service.FlagPickerService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by babool on 2/22/20.
 */
@Service
public class FlagPickerServiceImpl implements FlagPickerService
{
    FlagInfoObjectMapper flagInfoObjectMapper;

    {
        try {
            flagInfoObjectMapper = flagInfoObjectMapper.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<String> getContinents()  {
        List<String> continents = Collections.emptyList();
        try {
            continents = flagInfoObjectMapper.serializeToJsonWithoutNulls()
                .stream().map(ContinentStructure::getContinent)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        }catch(Exception ex){
            System.out.println("Error in getContinents for - ");
        }
        return continents;
    }

    @Override
    public List<Country> getCountries(String continent) {

        List<Country> countriesList = Collections.emptyList();
        try {
            countriesList = getCountries(continent, countriesList);


        }catch(Exception ex){
            System.out.println("Error in getCountries for - "+continent);
        }
        return countriesList;

    }

    private List<Country> getCountries(String continent, List<Country> countriesList) throws JsonProcessingException {
        Optional<ContinentStructure> conStructure = flagInfoObjectMapper.serializeToJsonWithoutNulls()
                .stream().filter(continentStructure -> continentStructure.getContinent().equalsIgnoreCase(continent))
                .findFirst();
        countriesList = conStructure.isPresent() ? conStructure.get().getCountries() : Collections.emptyList();
        return countriesList;
    }

    @Override
    public String getFlag(String continent, String countryName) {
        List<Country> countriesList = Collections.emptyList();
        Country country= null;
        try {
            countriesList = getCountries(continent, countriesList);
           country= countriesList.stream().filter(countryPresent -> countryPresent.getName().equalsIgnoreCase(countryName)).findFirst().orElse(null);


        }catch(Exception ex){
            System.out.println("Error in getCountries for - "+continent +"countryName:-"+countryName);
        }
        return Objects.nonNull(country) ? country.getFlag() : null;
    }
}
