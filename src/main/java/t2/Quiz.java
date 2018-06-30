package t2;

import static lombok.AccessLevel.PRIVATE;

import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
public class Quiz {

    @Getter
    String name;
    @Getter
    int score;

    public Quiz(String name, String language) {
        this.name = name;
        this.resourceQuizProperty = new ResourceProperty(language, "questions");
        this.resourceAnsProperty = new ResourceProperty(language, "answers");
    }

    ResourceProperty resourceQuizProperty;
    ResourceProperty resourceAnsProperty;

    public void changeLocale(String language) {
        resourceQuizProperty = new ResourceProperty(language, "answers");
        resourceQuizProperty = new ResourceProperty(language, "questions");
    }

    public void printAllQuestion() {
        int i = 0;
        for (String key : resourceQuizProperty.getQuizKeys()) {
            System.out.println(++i + ". " + resourceQuizProperty.getValue(key));
        }
    }

    public void printAnswer(int idQuestion) {
        System.out.println("Answer for: " + resourceQuizProperty
            .getValue((String) resourceQuizProperty.getQuizKeys().toArray()[idQuestion - 1])
            + " is "
            + resourceAnsProperty
            .getValue((String) resourceQuizProperty.getQuizKeys().toArray()[idQuestion - 1]));
    }


}
