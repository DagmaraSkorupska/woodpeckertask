package pl.skorupska.woodpeckertask;

import java.io.Serializable;

public class JokeResponse implements Serializable {

    private String type;
    private Joke value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Joke getValue() {
        return value;
    }

    public void setValue(Joke value) {
        this.value = value;
    }
}





