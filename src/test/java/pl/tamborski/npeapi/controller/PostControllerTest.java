package pl.tamborski.npeapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.tamborski.npeapi.config.SecurityConfig;
import pl.tamborski.npeapi.model.Post;
import pl.tamborski.npeapi.repository.PostRepository;
import pl.tamborski.npeapi.service.TokenService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PostRepository postRepository;

    @Test
    @Transactional
    void getSinglePost_shouldReturnAccurateDataFromGivenData() throws Exception {
        // given
        Post newPost = new Post();
        newPost.setTitle("Test title");
        newPost.setContent("Test content");
        newPost.setCreated(LocalDateTime.now());
        postRepository.save(newPost);

        // when
        MvcResult mvcResult = mockMvc.perform(get("/api/posts/" + newPost.getId()))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
                //.andExpect(jsonPath("$.id", Matchers.is(1)));

        // then
        Post post = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Post.class);
        assertThat(post).isNotNull();
        assertThat(post.getId()).isEqualTo(newPost.getId());
        assertThat(post.getTitle()).isEqualTo("Test title");
        assertThat(post.getContent()).isEqualTo("Test content");
    }
}