package com.caerkea.searchuser.Controller;

import com.caerkea.searchuser.AJAXnews;
import com.caerkea.searchuser.Model.News;
import com.caerkea.searchuser.Result;
import com.caerkea.searchuser.Service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewsController {
    private NewsService ns = new NewsService();
    List<News> oldStuff = new ArrayList<>();

    @PostMapping("/api/news")
    public ResponseEntity<Result> addResults(@RequestBody AJAXnews req) {
        ns.addToList(req.getHeader());
        Result r = new Result();
        return ResponseEntity.ok(r);
    }

    @PostMapping("/api/get")
    public ResponseEntity<Result> getNews() {
        List<News> sendList = new ArrayList<>();
        for (News n : ns.getTimeline()) {
            if (!oldStuff.contains(n)) {
                sendList.add(n);
                oldStuff.add(n);
            }
        }

        Result r = new Result();
        r.setTimeline(sendList);
        return ResponseEntity.ok(r);
    }
}
