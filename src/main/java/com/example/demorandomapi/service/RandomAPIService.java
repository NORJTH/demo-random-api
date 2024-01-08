package com.example.demorandomapi.service;

import com.example.demorandomapi.api.model.ResponseRandomUserApi;
import com.example.demorandomapi.api.model.UserDetails;
import com.example.demorandomapi.api.model.UserResults;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class RandomAPIService {

    public UserResults getRandomUser(String seed) {
        System.out.println("seed : " + seed);
        String uri = "https://randomuser.me/api/?seed=" + seed;
        System.out.println("uri  : " + uri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseRandomUserApi resultApi = restTemplate.getForObject(uri, ResponseRandomUserApi.class);
        UserDetails user = Objects.requireNonNull(resultApi).getResults().get(0);

        System.out.println("FirstName  : " + user.getName().getFirst());
        System.out.println("LastName   : " + user.getName().getLast());
        System.out.println("Email  : " + user.getEmail());
        System.out.println("Gender : " + user.getGender());
        return convertToUserResults(user);
    }

    private UserResults convertToUserResults(final UserDetails userDetails) {
        UserResults userResults = new UserResults();
        userResults.setFirstName(userDetails.getName().getFirst());
        userResults.setLastName(userDetails.getName().getLast());
        userResults.setEmail(userDetails.getEmail());
        userResults.setGender(userDetails.getGender());
        return userResults;
    }
}
