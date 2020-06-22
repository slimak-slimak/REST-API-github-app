package pl.wlny.jctask.apiGitHub;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.wlny.jctask.apiGitHub.entity.GitHubInfo;
import pl.wlny.jctask.apiGitHub.entity.GitHubNotFound;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Client.class)
class ClientIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void repoExist() throws Exception {
        //Given
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/repositories/slimak-slimak/cryptography-program");
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        //When
        GitHubInfo example = new GitHubInfo("slimak-slimak/cryptography-program","Simple program for encryption text data. Done as a part of Java Developer track on Hyperskill","https://github.com/slimak-slimak/cryptography-program.git",0,"2020-05-25T17:56:44Z");
        //Then
        assertEquals(example.toString(),String.valueOf(result.getResponse().getContentAsString()));
    }
    @Test
    void repoDoesNotExist() throws Exception {
        //Given
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/repositories/noSuchUser/noSuchRepo");
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        //When
        GitHubNotFound example = new GitHubNotFound("Not Found", "https://developer.github.com/v3/repos/#get");
        //Then
        assertEquals(example.toString(),String.valueOf(result.getResponse().getContentAsString()));
    }

}