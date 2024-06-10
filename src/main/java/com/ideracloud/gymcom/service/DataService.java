package com.ideracloud.gymcom.service;

import com.ideracloud.gymcom.dto.DataRef;

import java.util.List;

public interface DataService {

    List<DataRef> loadGenre();
    List<DataRef> loadSDocType();
    List<DataRef> loadStatus();
    List<DataRef> loadTAboon();

}
