package org.example;

class Saying extends Object {
    int id;
    String content;
    String author;

    Saying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Saying (id=%d, content=\"%s\", author=\"%s\")".formatted(id, content, author);
    }
}
