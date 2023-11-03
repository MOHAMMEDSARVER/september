package org.example.jdbc.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TeamStatsDto {
    private String teamName;
    private int playerCount;
    private double totalAmount;
    private double maxAmount;
    private double minAmount;
    private double avgAmount;
}
