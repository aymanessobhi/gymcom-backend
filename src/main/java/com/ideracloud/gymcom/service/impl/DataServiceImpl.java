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
        list.add(new DataRef(Genre.HOMME.name(), Genre.HOMME.description,0));
        list.add(new DataRef(Genre.FEMME.name(),Genre.FEMME.description,0));
        list.add(new DataRef(Genre.ENFANT.name(),Genre.ENFANT.description,0));
        return list;
    }

    @Override
    public List<DataRef> loadSDocType() {
        List<DataRef> list = new ArrayList<>();
        list.add(new DataRef(TypeDocument.CIN_V.name(),TypeDocument.CIN_V.description,0));
        list.add(new DataRef(TypeDocument.CIN_R.name(),TypeDocument.CIN_R.description,0));
        list.add(new DataRef(TypeDocument.PHOTO.name(),TypeDocument.PHOTO.description,0));

        return list;
    }

    @Override
    public List<DataRef> loadStatus() {
        List<DataRef> list = new ArrayList<>();
        list.add(new DataRef(Status.NOUVEAU.name(),Status.NOUVEAU.name(),0));
        list.add(new DataRef(Status.SOUMIS.name(),Status.SOUMIS.name(),0));
        return list;
    }

    @Override
    public List<DataRef> loadTAboon() {
        List<DataRef> list = new ArrayList<>();
        list.add(new DataRef(TypeAbonnement.ABONN1.name(),TypeAbonnement.ABONN1.description,TypeAbonnement.ABONN1.prix));
        list.add(new DataRef(TypeAbonnement.ABONN2.name(),TypeAbonnement.ABONN2.description,TypeAbonnement.ABONN2.prix));
        list.add(new DataRef(TypeAbonnement.ABONN3.name(),TypeAbonnement.ABONN3.description,TypeAbonnement.ABONN3.prix));

        return list;
    }

    @Override
    public List<DataRef> loadTPaiement() {
        List<DataRef> list = new ArrayList<>();
        list.add(new DataRef(TypePaiement.CHEQUE.name(),TypePaiement.CHEQUE.description, 0));
        list.add(new DataRef(TypePaiement.ESPECE.name(),TypePaiement.ESPECE.description, 0));
        list.add(new DataRef(TypePaiement.VIREMENT.name(),TypePaiement.VIREMENT.description, 0));
        return list;
    }

}
