package org.dpow.myapplication.api;

public class Greeting {
    private long id;
    private String name;
    private String postBody;

    public Greeting(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Greeting(long id, String name, String postBody) {
        this.id = id;
        this.name = name;
        this.postBody = postBody;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
}
