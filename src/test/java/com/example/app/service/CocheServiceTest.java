package com.example.app.service;

import com.example.app.DTO.Car;
import com.example.app.model.Coche;
import com.example.app.repositorio.CocheRepository;
import com.example.app.servicio.coche.CocheService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CocheServiceTest {
    @InjectMocks
    private CocheService cocheService;

    @Mock
    private CocheRepository repository;

    @Test
    public void buscarPorDni() {
        // GIVEN
        Page<Coche> cocheBuscarMatricula = new PageImpl(Arrays.asList(new Coche(1, "1234ABC", new Date(System.currentTimeMillis()), null)));
        final String DEFAULT_MATRICULA = "1234ABC";
        final Integer DEFAULT_SIZE = 10;
        final Integer DEFAULT_PAGE = 0;
        final Pageable DEFAULT_PAGEABLE = PageRequest.of(DEFAULT_PAGE, DEFAULT_SIZE);

        // WHEN
        when(repository.findByMatriculaContaining(DEFAULT_MATRICULA, DEFAULT_PAGEABLE)).thenReturn(cocheBuscarMatricula) ;

        Page<Coche> coche = cocheService.findByMatricula(DEFAULT_MATRICULA, DEFAULT_PAGE, DEFAULT_SIZE);

        String matricula = coche.getContent().get(0).getMatricula();


        // THEN
        Assert.assertNotNull(coche);
        Assert.assertNotNull(coche.getContent());
        Assert.assertTrue(coche.getContent().size()>0);
        Assert.assertThat(matricula, is(DEFAULT_MATRICULA));

        verify(repository).findByMatriculaContaining(DEFAULT_MATRICULA, DEFAULT_PAGEABLE);
    }
}
