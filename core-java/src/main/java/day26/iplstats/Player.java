package day26.iplstats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    String name;
    String role;
    @JsonProperty("team_name")
    String teamName;
    Double amount;
}
