package pl.wlny.jctask.apiGitHub.URL;

import pl.wlny.jctask.apiGitHub.entity.GitHubParam;

import java.net.MalformedURLException;
import java.net.URL;

public class GitHubURLBuilder {
    public URL repoURL(GitHubParam gitHubParam) {
        String userURL = "https://api.github.com/repos/" + gitHubParam.getRepoOwner() + "/" + gitHubParam.getRepoName();
        try {
            URL url = new URL(userURL);
            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }

    }

}
