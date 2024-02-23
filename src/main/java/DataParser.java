import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.IOException;

public class DataParser {

    public void parseXML(String filePath) throws IOException {
        XStream xstream = new XStream();
        xstream.allowTypesByWildcard(new String[]{"*"});
        xstream.processAnnotations(Person.class);

        var person = xstream.fromXML(new File(filePath));
        System.out.println("Person object from XML:"+person);
    }

    public void parseJSON(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(new File(filePath), Person.class);
        System.out.println("Person object from JSON:"+person);
    }

    public void parseYAML(String filepath) throws IOException {
        var mapper = new ObjectMapper(new YAMLFactory());
        Person person = mapper.readValue(new File(filepath), Person.class);
        System.out.println("Person object from YAML:"+person);
    }
}