package com.bytesMenu.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PratoRequestDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private Boolean available;
}