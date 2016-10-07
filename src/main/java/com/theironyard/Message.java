package com.theironyard;



import javax.persistence.*;

/**
 * Created by jakefroeb on 10/7/16.
 */
@Entity
@Table (name="messages")
public class Message {

    @Id
    @GeneratedValue
    int id;

    @Column (nullable = false)
    String text;

    public Message(String text) {
        this.text = text;
    }

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
