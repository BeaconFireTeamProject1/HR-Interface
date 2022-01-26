package com.example.hrinterface.Service;

import com.example.hrinterface.dao.DigitalDocumentDAO;
import com.example.hrinterface.dao.PersonalDocumentDAO;
import com.example.hrinterface.entity.DigitalDocument;
import com.example.hrinterface.entity.PersonalDocument;
import com.example.hrinterface.service.DocumentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DocumentServiceTest {
    @Mock
    PersonalDocumentDAO personalDocumentDAO;

    @InjectMocks
    DocumentService documentService;

    PersonalDocument personalDocument1;

    static List<PersonalDocument> list;
    static {
        list = new ArrayList<>();
        list.add(PersonalDocument.builder().
                id(1).path("test path").title("Personal Document 1").comment("comment").employeeID(1).
                build());
    }

    @BeforeEach
    public void setup(){
        personalDocument1 =
                PersonalDocument.builder().
                        id(1).path("test path").title("Personal Document 1").comment("comment").employeeID(1).
                        build();
        List<PersonalDocument> personalDocumentList = new ArrayList<>();
        personalDocumentList.add(personalDocument1);
        lenient().when(personalDocumentDAO.findDocumentByID(1)).thenReturn(personalDocument1);
        lenient().when(personalDocumentDAO.getDocsByEmployeeId(1)).thenReturn(personalDocumentList);
    }

    @Test
    public void findDocsByEmployeeId(){
        assertEquals(list, documentService.getDocsByEmployeeId(1));
        verify(personalDocumentDAO, times(1)).getDocsByEmployeeId(1);
    }
}
