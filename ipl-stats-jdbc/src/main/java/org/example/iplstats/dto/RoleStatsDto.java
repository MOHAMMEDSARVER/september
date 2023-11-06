package org.example.iplstats.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RoleStatsDto {
    private String roleName;
    private long totalPlayers;
    private double totalAmount;
    private double minAmount;
    private double maxAmount;
    private double avgAmount;

}
