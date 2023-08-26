package com.example.demo.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GitHubService {

    public ResponseEntity<Object> handleErrorResponse(HttpStatus status, String message) {
        Map<String, String> errorResponse = new LinkedHashMap<>();
        errorResponse.put("status", String.valueOf(status.value()));
        errorResponse.put("message", message);
        return ResponseEntity.status(status).body(errorResponse);
    }

    public ResponseEntity<String> getGitHubRepositoriesInfo(String username, String acceptHeader) {

        if (!"application/json".equals(acceptHeader)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Accept header");
        }

        String apiUrl = "https://api.github.com/users/" + username + "/repos";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> response;

        try {
            response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, Object[].class);
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Not Found User: " + e.getMessage());
        }

        Object[] repositories = response.getBody();
        List<String> result = new ArrayList<>();

        if (repositories != null) {
            for (Object repo : repositories) {
                if (repo instanceof Map) {
                    Map<String, Object> repoData = (Map<String, Object>) repo;

                    String name = (String) repoData.get("name");
                    Map<String, Object> ownerData = (Map<String, Object>) repoData.get("owner");
                    String owner = (String) ownerData.get("login");

                    StringBuilder info = new StringBuilder();
                    info.append("Repository Name: ").append(name).append("\n");
                    info.append("Owner Login: ").append(owner).append("\n");

                    String branchesUrl = ((String) repoData.get("branches_url"));
                    branchesUrl = branchesUrl.replace("{/branch}", "");

                    ResponseEntity<Object[]> branchesResponse = restTemplate.exchange(branchesUrl, HttpMethod.GET, entity, Object[].class);
                    Object[] branches = branchesResponse.getBody();

                    if (branches != null) {
                        for (Object branch : branches) {
                            if (branch instanceof Map) {
                                Map<String, Object> branchData = (Map<String, Object>) branch;
                                String branchName = (String) branchData.get("name");

                                Map<String, Object> commitData = (Map<String, Object>) branchData.get("commit");
                                String lastCommitSha = (String) commitData.get("sha");

                                String branchInfo = "Branch Name: " + branchName + ", Last Commit SHA: " + lastCommitSha;
                                info.append(branchInfo).append("\n");
                            }
                        }
                    }

                    result.add(info.toString());
                }
            }
            return ResponseEntity.ok(String.join("\n\n", result));
        }
        else {
            return ResponseEntity.status(response.getStatusCode()).body("Błąd w żądaniu");
        }
    }
}
