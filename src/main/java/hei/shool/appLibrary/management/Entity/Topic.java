package hei.shool.appLibrary.management.Entity;


import java.util.Objects;

public class Topic {
    private int id;
    private TopicName topic;
    private Book book;

    public Topic(int id, TopicName topic, Book book) {
        this.id = id;
        this.topic = topic;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TopicName getTopic() {
        return topic;
    }

    public void setTopic(TopicName topic) {
        this.topic = topic;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topic topic1)) return false;
        return id == topic1.id && topic == topic1.topic && Objects.equals(book, topic1.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, book);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", topic=" + topic +
                ", book=" + book +
                '}';
    }
}
