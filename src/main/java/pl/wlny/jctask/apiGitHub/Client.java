package pl.wlny.jctask.apiGitHub;
import org.springframework.web.bind.annotation.*;
import pl.wlny.jctask.apiGitHub.entity.GitHubParam;

@RestController
public class Client {

    @GetMapping("/repositories/{owner}/{repositoryName}")
    public Object showRepoDetails(@PathVariable String owner, @PathVariable String repositoryName)  {
        GitHubParam gitHubParam = new GitHubParam(owner, repositoryName);
        JSONresponse json = new JSONresponse();
        return json.getJSONresponse(gitHubParam);
    }
}