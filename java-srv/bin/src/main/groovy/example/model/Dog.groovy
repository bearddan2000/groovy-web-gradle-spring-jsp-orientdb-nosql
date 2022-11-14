package example.model;

import lombok.*;

import com.orientechnologies.orient.core.record.impl.ODocument;

//import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
  //  @NotNull
    private Long id;
    private String breed;
    private String color;

    public static Dog fromODocument(ODocument oDocument) {
        Dog article = new Dog();
        article.id = oDocument.field("id");
        article.breed = oDocument.field("breed");
        article.color = oDocument.field("color");

        return article;
    }
}
