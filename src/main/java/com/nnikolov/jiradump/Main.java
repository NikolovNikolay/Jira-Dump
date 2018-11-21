package com.nnikolov.jiradump;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nnikolov.jiradump.model.Issue;
import com.nnikolov.jiradump.model.JiraFilterResult;
import com.nnikolov.jiradump.writers.JsonFileWriter;

public class Main {

    public static void main(String[] args) {

        try {
            Gson g = new Gson();

            HttpResponse<String> response = Unirest.get(EnvConfig.get().getIssueTypeFilteredIssuesUrl(0, 50)).asString();
            JiraFilterResult re = g.fromJson(response.getBody(), JiraFilterResult.class);

            HttpResponse<String> response2 = Unirest.get(re.getIssues().get(0).getSelf()).asString();

            Issue is = g.fromJson(response2.getBody(), Issue.class);
            is.buildUrl(EnvConfig.get().getWebBrowseBaseUrl());

            EnvConfig env = EnvConfig.get();
            JsonFileWriter jsonFileWriter = new JsonFileWriter(env.getOutputRoot(), env.getBaseOutputDirName(), env.getJsonOutputDirName());
            jsonFileWriter.write(is.getKey(), is);

        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
