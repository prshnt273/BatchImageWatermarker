package com.kokoa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageRequestDTO {
    WatermarkParamsDTO params;
    String base64;
}