package pl.wlny.jctask.apiGitHub;

import org.json.JSONException;
import org.json.JSONObject;
import pl.wlny.jctask.apiGitHub.URL.GitHubURLBuilder;
import pl.wlny.jctask.apiGitHub.entity.GitHubInfo;
import pl.wlny.jctask.apiGitHub.entity.GitHubNotFound;
import pl.wlny.jctask.apiGitHub.entity.GitHubParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONresponse {

    public HttpURLConnection getConnection(URL repoURL) {
        try {
            HttpURLConnection connnection = (HttpURLConnection) repoURL.openConnection();
            connnection.setRequestMethod("GET");
            return connnection;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Connection to URL failure");
            return null;
        }

    }

    public String getStringInfo(HttpURLConnection connection) {
        BufferedReader in = null;
        try {
            if (connection.getResponseCode() == 200) {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GitHubNotFound("Not Found", "https://developer.github.com/v3/repos/#get").toString();
    }

    public Object getResponse(String getStringInfo) {
        try {
            JSONObject myResponse = null;
            myResponse = new JSONObject(getStringInfo);
            if (!myResponse.toString().isEmpty() && myResponse.toString().contains("full_name")) {
                return new GitHubInfo(
                        myResponse.getString("full_name"),
                        myResponse.getString("description"),
                        myResponse.getString("clone_url"),
                        myResponse.getInt("stargazers_count"),
                        myResponse.getString("created_at"));
            }
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
        return new GitHubNotFound("Not Found", "https://developer.github.com/v3/repos/#get");
    }


    public Object getJSONresponse(GitHubParam gitHubParam) {
        GitHubURLBuilder gitHubURLBuilder = new GitHubURLBuilder();
        return getResponse((getStringInfo(getConnection(gitHubURLBuilder.repoURL(gitHubParam)))));
    }
}
