package com.nnikolov.jiradump.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.nnikolov.jiradump.model.JiraFilterResult;

/**
 * Takes care of fetching issues and persisting them in files.
 */
public interface PersistenceService {

    /**
     * Retrieves an json entity and parses it to a specific model object.
     *
     * @param clazz the model object type
     * @param url   url to fetch from
     * @param <T>   generic
     * @return parsed model object
     * @throws UnirestException if url can't be loaded
     */
    <T> T getAsEntity(Class<T> clazz, String url) throws UnirestException;

    /**
     * Persists collection of issues.
     * The issues are fetched via multiple REST requests using pagination
     * until all results from the initial filter request are downloaded or
     * attempted to download
     *
     * @param filterResult initial filter result
     */
    void persistEntities(JiraFilterResult filterResult);
}
