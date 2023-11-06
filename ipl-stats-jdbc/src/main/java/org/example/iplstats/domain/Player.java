package org.example.iplstats.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private String role;
    private String team_name;
    private double amount;
}
