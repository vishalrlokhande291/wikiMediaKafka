package vishal.springboot.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "wikimediaData")
@Data
public class WikimediaData {
    @Id
    private String id;

    private String wikiEventData;

    public WikimediaData(String wikiEventData) {
        this.wikiEventData = wikiEventData;
    }
}
