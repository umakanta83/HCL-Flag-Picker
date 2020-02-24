package com.hcl.flagpicker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hcl.domain.Country;

import java.util.List;

/**
 * Created by babool on 2/22/20.
 */
public interface FlagPickerService {
    /** This method will return all continents.
     *
     * @return
     */
    List<String> getContinents() ;

    /**This method will return country list of all continent.
     *
     * @param continent
     * @return
     */

    List<Country> getCountries(String continent);

    /**This method will return the flag for continent and country.
     *
     * @param continent
     * @param countryName
     * @return
     */

    String getFlag(String continent, String countryName);
}
