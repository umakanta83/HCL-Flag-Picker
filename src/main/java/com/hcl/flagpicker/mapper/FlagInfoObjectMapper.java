package com.hcl.flagpicker.mapper;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.domain.ContinentStructure;

public class FlagInfoObjectMapper {

    private static FlagInfoObjectMapper single_instance = null;
    public List<ContinentStructure> continentList;
    private ObjectMapper objectMapper;
    private JsonNode jsonNode;

    private FlagInfoObjectMapper() throws IOException {
        this.objectMapper = new ObjectMapper();
        this.continentList = new ArrayList<>();
        this.readJsonWithObjectMapper();
        serializeToJsonWithoutNulls();
    }

    /**
     * Create only one instance of this class
     *
     * @return {@code single_instance} of class
     * @throws IOException
     */

    public static FlagInfoObjectMapper getInstance() throws IOException {
        if (single_instance == null)
            single_instance = new FlagInfoObjectMapper();

        return single_instance;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

   

    public static FlagInfoObjectMapper getSingle_instance() {
		return single_instance;
	}

	public static void setSingle_instance(FlagInfoObjectMapper single_instance) {
		FlagInfoObjectMapper.single_instance = single_instance;
	}

	public List<ContinentStructure> getContinentList() {
		return continentList;
	}

	public void setContinentList(List<ContinentStructure> continentList) {
		this.continentList = continentList;
	}

	/**
     * Read whole continent.json file from prepared roots. Making a list of objects and return it.
     *
     * @throws IOException
     */
    public void readJsonWithObjectMapper() throws IOException {
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/continents.json");
        continentList = objectMapper.readValue(inputStream, new TypeReference<List<ContinentStructure>>(){});
     
    }

    /**
     * Methode get  list of continent and return properties and serialized it to JSON wihout null properties.
     */
    public List<ContinentStructure> serializeToJsonWithoutNulls() throws JsonProcessingException {

        List<ContinentStructure> filterSortedVolume = Optional.ofNullable(continentList)
                .orElseGet(Collections::emptyList)
                .stream()
                .collect(Collectors.toList());

        return filterSortedVolume;
    }

}



