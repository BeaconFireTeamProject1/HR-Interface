package com.example.hrinterface.service;

import com.example.hrinterface.dao.PersonalDocumentDAO;
import com.example.hrinterface.entity.PersonalDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    @Autowired
    PersonalDocumentDAO personalDocumentDAO;

    public PersonalDocument findDocumentByID(int ID){
        try{
            return personalDocumentDAO.findDocumentByID(ID);
        }catch (Exception e){System.out.println(e);}
        return null;
    }

    public List<PersonalDocument> getDocsByEmployeeId(int id){
        try{
            return personalDocumentDAO.getDocsByEmployeeId(id);
        }catch (Exception e){System.out.println(e);}
        return null;
    }
}
