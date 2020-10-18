package com.caerkea.searchuser.Service;

import com.caerkea.searchuser.Model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsService {
    private List<News> timeline = new ArrayList<>();

    public NewsService() {
        createNews();
    }

    public void addToList(String header) {
        if (!timeline.contains(new News(header))) {
            timeline.add(new News(header));
        }
    }

    public List<News> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<News> timeline) {
        this.timeline = timeline;
    }

    public void createNews() {
        timeline.add(new News("New turtle found in Alaska"));
        timeline.add(new News("Do you really need to breathe?"));
        timeline.add(new News("Many money lines are going down?!"));
    }
}
