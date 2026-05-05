package com.anna.gymmembership.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ReportDTO {
    private String gymName;
    private BigDecimal amount;
    private String currency;
}
