package com.jefmed.workshopmongo.controller;

import com.jefmed.workshopmongo.model.services.UsuarioService;
import com.jefmed.workshopmongo.model.services.error.ResourceNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioControllerTest {
    @Mock
    private UsuarioService usuarioService;
    @InjectMocks
    private UsuarioController usuarioController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deve_RetornarTodosUsuarios() {
    }

    @Test
    public void deve_RetornarUmUsuario_quando_InformadoId() {
    }

    @Test
    public void deve_InserirUmNovoUsuario() {
    }

    @Test
    public void deve_DeletarUmUsuarioExistente() {
    }

    @Test
    public void deve_FazerUpdate_Quando_UsuarioExistir() {
    }

//    @Test(expected = ResourceNotFoundException.class)
//    public void deve_RetornarException_Quando_UsuarioExistir() {
//    }
}