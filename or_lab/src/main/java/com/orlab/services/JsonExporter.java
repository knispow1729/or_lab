package com.orlab.services;

import com.orlab.model.Turniri;

import java.util.List;

public interface JsonExporter {
    String export(List<Turniri> turniri);
}
