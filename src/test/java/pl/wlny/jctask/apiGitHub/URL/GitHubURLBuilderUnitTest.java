package pl.wlny.jctask.apiGitHub.URL;

import org.junit.jupiter.api.Test;
import pl.wlny.jctask.apiGitHub.entity.GitHubParam;

import static org.junit.jupiter.api.Assertions.*;

class GitHubURLBuilderUnitTest {

    @Test
    void repoURL() {
        //Given
        GitHubParam param = new GitHubParam("slimak-slimak", "cryptography-program");
        GitHubURLBuilder urlBuilder = new GitHubURLBuilder();
        //When
        String expectedURL = "https://api.github.com/repos/slimak-slimak/cryptography-program";
        //Then
        assertEquals(urlBuilder.repoURL(param).toString(),expectedURL);
    }
}