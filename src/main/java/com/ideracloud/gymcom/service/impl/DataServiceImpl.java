package com.ideracloud.gymcom.service.impl;

import com.ideracloud.gymcom.dto.DataRef;
import com.ideracloud.gymcom.enums.*;
import com.ideracloud.gymcom.service.DataService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    @Override
    public List<DataRef> loadGenre() {
        List<DataRef> list = new ArrayList<>();
        list.add(new DataRef(Genre.HOMME.name(), Genre.HOMME.description));
        list.add(new DataRef(Genre.FEMME.name(),Genre.FEMME.description));
        list.add(new DataRef(Genre.ENFANT.name(),Genre.ENFANT.description));
        return list;
    }



    @Override
    public List<DataRef> loadSDocType() {
        List<DataRef> list = new ArrayList<>();
        list.add(new DataRef(TypeDocument.CIN_V.name(),TypeDocument.CIN_V.description));
        list.add(new DataRef(TypeDocument.CIN_R.name(),TypeDocument.CIN_R.description));
        list.add(new DataRef(TypeDocument.PHOTO.name(),TypeDocument.PHOTO.description));

        return list;
    }

    @Override
    public List<DataRef> loadStatus() {
        List<DataRef> list = new ArrayList<>();
        list.add(new DataRef(Status.NOUVEAU.name(),Status.NOUVEAU.name()));
        list.add(new DataRef(Status.SOUMIS.name(),Status.SOUMIS.name()));
        return list;
    }

    @Override
    public List<DataRef> loadTAboon() {
        List<DataRef> list = new ArrayList<>();
        list.add(new DataRef(TypeAbonnement.ABONN1.name(),TypeAbonnement.ABONN1.description));
        list.add(new DataRef(TypeAbonnement.ABONN2.name(),TypeAbonnement.ABONN2.description));
        list.add(new DataRef(TypeAbonnement.ABONN3.name(),TypeAbonnement.ABONN3.description));

        return list;
    }


}
