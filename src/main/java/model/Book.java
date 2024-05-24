package model;

public record Book(String title, String author, String isbn) {
    @Override
    public String toString() {
        return("["+title+", "+author+", "+isbn+"]");
    }
}
