package com.example.internship;

public class RepoModel {

    String repoName, repoUrl, repoDescription;

    public RepoModel(String repoName, String repoUrl, String repoDescription) {
        this.repoName = repoName;
        this.repoUrl = repoUrl;
        this.repoDescription = repoDescription;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    public String getRepoDiscription() {
        return repoDescription;
    }

    public void setRepoDiscription(String repoDiscription) {
        this.repoDescription = repoDiscription;
    }
}
