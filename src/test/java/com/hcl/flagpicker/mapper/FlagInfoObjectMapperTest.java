package com.hcl.flagpicker.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlagInfoObjectMapperTest {

    FlagInfoObjectMapper flagInfoObjectMapper = FlagInfoObjectMapper.getInstance();

    public FlagInfoObjectMapperTest() throws IOException {

    }

    @Test
    public void flagInfoObjectMapperShouldNotBeNull() throws IOException {
        flagInfoObjectMapper.readJsonWithObjectMapper();
        assertNotNull(flagInfoObjectMapper.getObjectMapper());
        assertNotNull(flagInfoObjectMapper.serializeToJsonWithoutNulls());
    }


}
