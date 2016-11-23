package pl.javastart.model;

import javax.validation.constraints.NotNull;

import pl.javastart.common.Lang;
import pl.javastart.constraint.NotBadWord;

public class Message {
    @NotNull
    private String title;
    @NotBadWord(lang = {Lang.PL, Lang.EN})
    private String content;
    public Message(String title, String content) {
        this.title = title;
        this.content = content;
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
}