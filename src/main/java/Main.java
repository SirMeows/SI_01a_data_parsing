import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DataParser dataParser = new DataParser();
        try {
            dataParser.parseXML("src/main/resources/me.xml");
            dataParser.parseJSON("src/main/resources/me.json");
            dataParser.parseYAML("src/main/resources/me.yaml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
