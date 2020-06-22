package pl.wlny.jctask.apiGitHub;

import org.junit.jupiter.api.Test;
import pl.wlny.jctask.apiGitHub.URL.GitHubURLBuilder;
import pl.wlny.jctask.apiGitHub.entity.GitHubInfo;
import pl.wlny.jctask.apiGitHub.entity.GitHubNotFound;
import pl.wlny.jctask.apiGitHub.entity.GitHubParam;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.*;

class JSONresponseUnitTest {

    //Given
    JSONresponse response = new JSONresponse();
    GitHubURLBuilder urlBuilder = new GitHubURLBuilder();
    GitHubParam param = new GitHubParam("slimak-slimak", "cryptography-program");
    HttpURLConnection connection = response.getConnection(urlBuilder.repoURL(param));
    String actualStringInfo = response.getStringInfo(connection);
    GitHubInfo exist = new GitHubInfo("slimak-slimak/cryptography-program", "Simple program for encryption text data. Done as a part of Java Developer track on Hyperskill", "https://github.com/slimak-slimak/cryptography-program.git", 0, "2020-05-25T17:56:44Z");
    GitHubNotFound notExist = new GitHubNotFound("Not Found", "https://developer.github.com/v3/repos/#get");

    @Test
    void getConnection() throws IOException {
        //When
        int expectedCode = 200;
        int responseCode = connection.getResponseCode();
        //Then
        assertEquals(expectedCode, responseCode);
    }

    @Test
    void getStringInfo() {
        //When
        String containsNodeId = "MDEwOlJlcG9zaXRvcnkyNjY4NDU2Nzc=";
        //Then
        // Ponieważ String był bardzo długi postanowiłem sprawdzić jedynie obecność unikalnego nodeId repozytorium.
        assertTrue(actualStringInfo.contains(containsNodeId));
    }

    @Test
    void getResponse() {
        //When
        Object actual = response.getResponse(actualStringInfo);
        //Then
        assertEquals(actual, exist);
        assertNotEquals(actual, notExist);
    }

    @Test
    void getJSONresponse() {
        //When
        Object actual = response.getJSONresponse(param);
        //Then
        assertEquals(actual, exist);
        assertNotEquals(actual, notExist);
    }
}