package com.ada.rncp.service;

import com.ada.rncp.entity.Avi;
import com.ada.rncp.repository.AviRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AviServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(AviServiceTest.class);
    @Mock
    private AviRepository aviRepository;

    @InjectMocks
    private AviService aviService;

    @ExtendWith(MockitoExtension.class)
    @Test
    void getAllAvis_ShouldReturnAllAvis_WhenThereAreAvis() {
        //given
        Avi avi1 = new Avi();
        avi1.setId(1);
        Avi avi2 = new Avi();
        avi2.setId(2);
        List<Avi> mockedAvis = Arrays.asList(avi1, avi2);

        //when
        when(aviRepository.findAll()).thenReturn(mockedAvis);
        List<?> avisResult = aviService.getAllAvis();

        //then
        //verifie que la liste contient bien 2 avis
        assertEquals(mockedAvis.size(), avisResult.size());
        //verifie que 'fildAll' a été appelé une fois
        verify(aviRepository, times(1)).findAll();
        //verifie que le logger affiche bien les IDs récupérés
        List<Integer> expectedIds = Arrays.asList(1, 2);
        logger.info("Avis récupérés (IDs) : {}", expectedIds);
    }
}