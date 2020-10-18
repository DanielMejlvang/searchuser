package com.caerkea.searchuser.Controller;

import com.caerkea.searchuser.AJAXrequest;
import com.caerkea.searchuser.Model.User;
import com.caerkea.searchuser.Result;
import com.caerkea.searchuser.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    private UserService us = new UserService();

    @PostMapping("/api/search")
    public ResponseEntity<Result> getSearchResults(@RequestBody AJAXrequest req) {
        System.out.println("Here we are! Search with " + req.getUsername());

        Result r = new Result();
        List<User> usersFound = us.findUsers(req.getUsername());
        r.setMessage("Found users: " + usersFound.size());
        r.setList(usersFound);
        return ResponseEntity.ok(r);
    }
}
