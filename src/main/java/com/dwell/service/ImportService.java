package com.dwell.service;

import com.dwell.entity.CheckUp;
import com.dwell.entity.Client;
import com.dwell.entity.Coach;
import com.dwell.repository.ClientRepository;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class ImportService {
    @Autowired
    private ClientRepository clientRepository;

    public void processFile(XSSFWorkbook workbook) {
        Coach coach = createCoach((XSSFRow) workbook.getSheetAt(0).getRow(0));
        workbook.removeSheetAt(0);
        Iterator<Sheet> iterator = workbook.iterator();
        iterator.forEachRemaining(sheet -> {
            if (sheet.getPhysicalNumberOfRows() > 0) {
                Client client = createClient((XSSFRow) sheet.getRow(0), coach);
                List<CheckUp> checkUpList = new ArrayList<>();
                for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                    XSSFRow row = (XSSFRow) sheet.getRow(i);
                    CheckUp checkup = createCheckup(row);
                    checkUpList.add(checkup);
                }
                client.setCheckUps(checkUpList);
                clientRepository.save(client);
            }
        });
    }

    private CheckUp createCheckup(XSSFRow row) {
        CheckUp checkUp = new CheckUp();
        checkUp.setCheckUpDate(LocalDate.parse(getCellValue(row, 0), DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
        checkUp.setWeight(Double.valueOf(getCellValue(row, 1)));
        checkUp.setViseralFat(Double.valueOf(getCellValue(row, 2)));
        checkUp.setTsf(Double.valueOf(getCellValue(row, 3)));
        checkUp.setTotalFat(Double.valueOf(getCellValue(row, 4)));
        checkUp.setMetaAge(Integer.valueOf(getCellValue(row, 5)));
        checkUp.setBmi(Integer.valueOf(getCellValue(row, 6)));
        checkUp.setBmr(Integer.valueOf(getCellValue(row, 7)));
        checkUp.setSkeMuscle(Double.valueOf(getCellValue(row, 8)));
        return checkUp;
    }

    private Client createClient(XSSFRow row, Coach coach) {
        Client client = new Client();
        client.setCoach(coach);
        client.setFirstName(getCellValue(row, 0));
        client.setLastName(getCellValue(row, 1));
        client.setDateOfBirth(LocalDate.parse(getCellValue(row, 2), DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
        client.setHeight(Double.valueOf(getCellValue(row, 3)));
        client.setPhone(getCellValue(row, 4));
        client.setIdealWeight(Double.valueOf(getCellValue(row, 5)));
        client.setPassword(getCellValue(row, 6));
        client.setGender(getCellValue(row, 7));
        client.setAddress(getCellValue(row, 8));
        return client;
    }

    private Coach createCoach(XSSFRow row) {
        Coach coach = new Coach();
        coach.setFirstName(getCellValue(row, 0));
        coach.setLastName(getCellValue(row, 1));
        coach.setHerbalifeId(getCellValue(row, 2));
        coach.setFssai(getCellValue(row, 3));
        coach.setUpLineTabTeam(getCellValue(row, 4));
        coach.setLevelInHerbalife(getCellValue(row, 5));
        coach.setEmailId(getCellValue(row, 6));
        coach.setPhone(getCellValue(row, 7));
        coach.setPassword(getCellValue(row, 8));
        return coach;
    }

    private String getCellValue(XSSFRow row, int cellIndex) {
        return Objects.requireNonNullElse(String.valueOf(row.getCell(cellIndex)), "");
    }
}
