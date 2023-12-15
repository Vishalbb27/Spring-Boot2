package com.example.MycoolApp.hello;

import jakarta.persistence.*;

@Entity
public class Hello {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String hello;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHello() {
        return hello;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "id=" + id +
                ", hello='" + hello + '\'' +
                '}';
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
