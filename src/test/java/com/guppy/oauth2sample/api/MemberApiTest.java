package com.guppy.oauth2sample.api;

import com.guppy.oauth2sample.repository.MemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kanghonggu on 2017. 7. 5..
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberApiTest {

    private static Logger logger = LoggerFactory.getLogger(MemberApiTest.class);

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;



    @Autowired
    private MemberRepository memberRepository;


    @Before
    public void 셋업 () {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void 테스트하자 () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/members")
                .with(user("user").password("test")
        )).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}
