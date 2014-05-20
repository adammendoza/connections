package hack.connections;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Item1 {

    private long id;

    @Length(max = 3)
    private String content;

    public Item1() {
        // Jackson deserialization
    }

    public Item1(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}