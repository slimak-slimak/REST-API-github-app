package pl.wlny.jctask.apiGitHub.entity;

import java.util.Objects;

public class GitHubInfo {
    String fullName;
    String description;
    String cloneUrl;
    int stars;
    String createdAt;

    public GitHubInfo(String fullName, String description, String cloneUrl, int stars, String createdAt) {
        this.fullName = fullName;
        this.description = description;
        this.cloneUrl = cloneUrl;
        this.stars = stars;
        this.createdAt = createdAt;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "{\"fullName\":\"" + fullName + "\"" + "," +
                "\"description\":\"" + description + "\"" + "," +
                "\"cloneUrl\":\"" + cloneUrl + "\"" + "," +
                "\"stars\":" + stars + "," +
                "\"createdAt\":\"" + createdAt + "\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitHubInfo that = (GitHubInfo) o;
        return stars == that.stars &&
                fullName.equals(that.fullName) &&
                description.equals(that.description) &&
                cloneUrl.equals(that.cloneUrl) &&
                createdAt.equals(that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, description, cloneUrl, stars, createdAt);
    }
}
