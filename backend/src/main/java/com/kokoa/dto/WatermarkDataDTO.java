package com.kokoa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class WatermarkDataDTO {
    Integer id;
    String username;
    String backgroundImage;
    String previewImage;
    WatermarkParamsDTO params;
}