package org.example.jdbc.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Player {
    private String name;
    private String role;
    private double amount;
    private String team_name;
}
