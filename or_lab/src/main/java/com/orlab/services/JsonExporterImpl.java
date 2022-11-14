package com.orlab.services;

import com.google.gson.Gson;
import com.orlab.model.Turniri;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonExporterImpl implements  JsonExporter{
    @Override
    public String export(List<Turniri> turniri) {
        Gson gson = new Gson();
        return gson.toJson(turniri);
    }
}
