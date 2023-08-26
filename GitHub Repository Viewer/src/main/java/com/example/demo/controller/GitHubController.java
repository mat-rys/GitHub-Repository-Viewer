package com.example.demo.controller;


import com.example.demo.service.GitHubService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class GitHubController {
    private final GitHubService gitHubService;

    @GetMapping(path = "test")
    public ResponseEntity<String> getGitHubRepositories(@RequestParam String username,
                                                        @RequestParam("Accept:") String acceptHeader) {
        return gitHubService.getGitHubRepositoriesInfo(username, acceptHeader);
    }


}

