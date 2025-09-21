package com.kokoa.service.api;

import com.kokoa.dto.WatermarkDataDTO;
import com.kokoa.dto.WatermarkParamsDTO;
import com.kokoa.entity.other.WatermarkParams;
import com.kokoa.exception.FontNotFoundException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import java.awt.*;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;


public interface BatchImageWatermarkerService {

    void startTask(String username, InputStream fileStream, WatermarkParams params, Image backgroundImage);
    Integer getProgress(String username);
    ResponseEntity<InputStreamResource> getZipFile(String username);
    Map<String, Set<String>> getAdditionalData(String username);
    void stopTask(String username);

    List<WatermarkParamsDTO> getPresetStyleParams();
    List<WatermarkDataDTO> getCustomStyleParams(String username);
    void addCustomStyleParams(WatermarkDataDTO data);
    void deleteCustomStyleParams(Integer id);
    void updateCustomStyleParams(WatermarkDataDTO data);

    String getDefaultBackgroundImage();
    String getModifiedImage(WatermarkParams params, byte[] bytes) throws FontNotFoundException;

    String handleUploadFontFile(byte[] fileBytes, String fileName);
}