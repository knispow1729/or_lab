package com.orlab.controllers;

import com.orlab.model.Turniri;
import com.orlab.services.JsonExporter;
import com.orlab.services.TurnirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DowloadController {

    private final JsonExporter jsonExporter;
    private final TurnirService turnirService;

    @Autowired
    public DowloadController(JsonExporter jsonExporter, TurnirService turnirService) {
        this.jsonExporter = jsonExporter;
        this.turnirService = turnirService;
    }


    @GetMapping("/downloadJson")
    public ResponseEntity<byte[]> downloadJsonFile() {
        List<Turniri> turniri = turnirService.getAllTurniri();

        String turniriJsonString = jsonExporter.export(turniri);

        byte[] turniriJsonBytes = turniriJsonString.getBytes();

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=turniri.json")
                .contentType(MediaType.APPLICATION_JSON)
                .contentLength(turniriJsonBytes.length)
                .body(turniriJsonBytes);
    }

    @GetMapping("/downloadCsv")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=turniri.csv";
        response.setHeader(headerKey, headerValue);

        List<Turniri> listTurniri = turnirService.getAllTurniri();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Naziv", "Serija", "Organizator", "Tip", "Lokacija", "Format","DatumPocetka", "DatumZavrsetka", "NagradniFond", "BrojTimova", "BrojGledatelja","VerzijaIgre", "IdTurnir"};
        String[] nameMapping = {"Naziv", "Serija", "Organizator", "Tip", "Lokacija", "Format","DatumPocetka", "DatumZavrsetka", "NagradniFond", "BrojTimova", "BrojGledatelja","VerzijaIgre", "IdTurnir"};

        csvWriter.writeHeader(csvHeader);

        for (Turniri turnir : listTurniri) {
            csvWriter.write(turnir, nameMapping);
        }

        csvWriter.close();

    }


}
