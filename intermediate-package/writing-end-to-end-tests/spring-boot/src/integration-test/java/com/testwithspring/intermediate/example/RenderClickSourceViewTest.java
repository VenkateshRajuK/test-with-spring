package com.testwithspring.intermediate.example;

import com.testwithspring.intermediate.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ExampleApplication.class})
@AutoConfigureMockMvc
@ActiveProfiles(Profiles.INTEGRATION_TEST)
@Category(IntegrationTest.class)
public class RenderClickSourceViewTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnHttpStatusCodeOk() throws Exception {
        renderClickSourceView()
                .andExpect(status().isOk());
    }

    @Test
    public void shouldRenderClickSourceView() throws Exception {
        renderClickSourceView()
                .andExpect(view().name(WebTestConstants.Views.CLICK_SOURCE_VIEW));
    }

    private ResultActions renderClickSourceView() throws Exception {
        return mockMvc.perform(get("/click-source"));
    }
}
