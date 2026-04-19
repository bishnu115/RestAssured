import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    public int id;
    public String email;
    public String first_name;
    public String last_name;

}
