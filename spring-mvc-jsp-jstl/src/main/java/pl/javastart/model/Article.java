package pl.javastart.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Article {

    private String title;
    private String content;
    private List<String> tags;
    
    public Article(String title, String content, String tags) {
        this.title = title;
        this.content = content;
        if(tags != null && tags.length() > 0) {
            this.tags = Arrays.asList(tags.split(","));
        } else {
            this.tags = Collections.emptyList();
        }
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    
}