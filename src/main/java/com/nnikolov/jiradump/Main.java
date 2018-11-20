package com.nnikolov.jiradump;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nnikolov.jiradump.model.Issue;
import com.nnikolov.jiradump.model.JiraFilterResult;

public class Main {

    public static void main(String[] args) {

        try {
            HttpResponse<String> response = Unirest.get(EnvConfig.get().getIssueTypeFilteredIssuesUrl(0, 50)).asString();
            Gson g = new Gson();
            JiraFilterResult re = g.fromJson(response.getBody(), JiraFilterResult.class);

            HttpResponse<String> response2 = Unirest.get(re.getIssues().get(0).getSelf()).asString();
            Issue is = g.fromJson(response2.getBody(), Issue.class);
            int a = 0;
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
