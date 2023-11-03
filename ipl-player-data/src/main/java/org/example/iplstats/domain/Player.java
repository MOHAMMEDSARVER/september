package org.example.iplstats.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Player {
    private String name;
    private String role;
    private String teamName;
    private double amount;

}
