import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@XStreamAlias("person")
public class Person {
    @XStreamAlias("Name")
    private String name;
    @XStreamAlias("Hobbies")
    private List<String> hobbies;
}
