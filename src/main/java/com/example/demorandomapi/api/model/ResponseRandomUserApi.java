package com.example.demorandomapi.api.model;

import java.util.List;

public class ResponseRandomUserApi {
    private List<UserDetails> results;

    public List<UserDetails> getResults() {
        return results;
    }

    public void setResults(List<UserDetails> results) {
        this.results = results;
    }
}
