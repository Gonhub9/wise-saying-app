package org.example;

public class Saying extends Object {
    public int id;
    public String content;
    public String author;

    public Saying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Saying (id=%d, content=\"%s\", author=\"%s\")".formatted(id, content, author);
    }
}
