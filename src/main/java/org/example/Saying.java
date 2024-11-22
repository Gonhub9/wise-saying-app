package org.example;

public class Saying extends Object {
    private final int id;
    private String content;
    private String author;

    public Saying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Saying (id=%d, content=\"%s\", author=\"%s\")".formatted(id, content, author);
    }
}
