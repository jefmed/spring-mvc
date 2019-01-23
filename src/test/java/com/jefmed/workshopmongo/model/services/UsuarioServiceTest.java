package com.jefmed.workshopmongo.model.services;

import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.repository.UsuarioRepository;
import com.jefmed.workshopmongo.model.services.error.ResourceNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @InjectMocks
    private Usuario usuario;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }



    private static Usuario usuario1 = Usuario.builder()
            .id("1")
            .nome("Usuario 1")
            .email("usuario1@gmail.com")
            .build();
    private static Usuario usuario2 = Usuario.builder()
            .id("2")
            .nome("Usuario 2")
            .email("usuario2@gmail.com")
            .build();
    private static Usuario usuario3 = Usuario.builder()
            .id("3")
            .nome("Usuario 3")
            .email("usuario3@gmail.com")
            .build();


    public static Collection<Object[]> getParams(){
        return Arrays.asList(new Object[][]{
                {Arrays.asList(usuario1, usuario2, usuario3)}
        });
    }

    @Test
    public void deve_QuantidadeUsuarios() {
        List<Usuario> allUsers = usuarioService.findAllUsers();

        assertEquals(3, allUsers.size());
    }

    @Test
    public void deve_RetornarUmUsuario_Quando_InformadoId() {
        Usuario userById = usuarioService.findUserById(usuario1.getId());

        assertEquals(1, userById);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void deve_LancarErro_Quando_NaoExistirId() {
    }

    @Test
    public void deve_RetornarUmUsuario_Quando_InformadoNome() {
    }

    @Test
    public void deve_InserirNovoUsuario() {
    }

    @Test
    public void deve_DeletarUmUsuario() {
    }

    @Test
    public void deve_FazerUpdateDeUmUsuario() {
    }
}