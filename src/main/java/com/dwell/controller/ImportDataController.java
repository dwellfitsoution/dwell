package com.dwell.controller;

import com.dwell.service.ImportService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/imports")
public class ImportDataController {

    @Autowired
    private ImportService importService;

    @PostMapping("/")
    public String processFile(@RequestParam("file") MultipartFile excel) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());
        importService.processFile(workbook);
        return "Success";
    }
}
