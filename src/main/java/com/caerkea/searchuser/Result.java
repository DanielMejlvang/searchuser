package com.caerkea.searchuser;

import com.caerkea.searchuser.Model.News;
import com.caerkea.searchuser.Model.User;

import java.util.List;

public class Result {
    String message;
    private List<User> list;
    private List<News> timeline;

    public Result() {
    }

    public List<News> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<News> timeline) {
        this.timeline = timeline;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
