package pl.wlny.jctask.apiGitHub.entity;

import java.util.Objects;

public class GitHubNotFound {
    String message;
    String documentation_url;

    public GitHubNotFound(String message, String documentation_url) {
        this.message = message;
        this.documentation_url = documentation_url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocumentation_url() {
        return documentation_url;
    }

    public void setDocumentation_url(String documentation_url) {
        this.documentation_url = documentation_url;
    }

    @Override
    public String toString() {
        return "{\"message\":\"" + message + "\"" + "," +
                "\"documentation_url\":\"" + documentation_url + "\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitHubNotFound that = (GitHubNotFound) o;
        return message.equals(that.message) &&
                documentation_url.equals(that.documentation_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, documentation_url);
    }
}
