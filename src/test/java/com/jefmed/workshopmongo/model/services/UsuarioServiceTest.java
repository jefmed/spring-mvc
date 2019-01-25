package com.jefmed.workshopmongo.model.services;

import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.repository.UsuarioRepository;
import com.jefmed.workshopmongo.model.services.error.ResourceNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;


    private static Usuario usuario1 = Usuario.builder()
            .id("1")
            .nome("Usuario1")
            .email("usuario1@gmail.com")
            .build();
    private static Usuario usuario2 = Usuario.builder()
            .id("2")
            .nome("Usuario2")
            .email("usuario2@gmail.com")
            .build();
    private static Usuario usuario3 = Usuario.builder()
            .id(null)
            .nome("Usuario3")
            .email("usuario3@gmail.com")
            .build();
    private static Usuario usuario4 = Usuario.builder()
            .id(null)
            .nome("Usuario4")
            .email("usuario4@gmail.com")
            .build();


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deve_Retornar_quando_ListaNaoVazia() {
        List<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario1);
        usuarioList.add(usuario2);
        usuarioList.add(usuario3);
        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        assertFalse(usuarioService.findAllUsers().isEmpty());
    }

    @Test
    public void deve_RetornarUmUsuario_Quando_InformadoId() {
        when(usuarioRepository.findById(usuario1.getId())).thenReturn(Optional.of(usuario1));
        Usuario userById = usuarioService.findUserById(usuario1.getId());
        assertEquals("1", userById.getId());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void deve_LancarErro_Quando_NaoExistirId() {
        when(usuarioRepository.findById(usuario2.getId())).thenReturn(Optional.of(usuario2));
        Usuario userById = usuarioService.findUserById(usuario1.getId());
        assertEquals("1", userById.getId());
    }

    @Test
    public void deve_RetornarUmUsuario_Quando_InformadoNome() {
        List<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario1);
        usuarioList.add(usuario2);
        usuarioList.add(usuario3);
        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        Optional<Usuario> usuario1 = usuarioService.findByName("usuario1");
        assertEquals("Usuario1", usuario1.get().getNome());
    }

    @Test
    public void deve_InserirNovoUsuario() {
        when(usuarioRepository.insert(usuario1)).thenReturn(usuario1);
        assertEquals(usuario1, usuarioService.insertNovoUsuario(usuario1));
    }

    @Test // PERGUNTAR P MATHEUS METODO MAIS EFICIENTE
    public void deve_DeletarUmUsuario_Quando_InformadoId() {
        when(usuarioRepository.findById(usuario1.getId())).thenReturn(Optional.of(usuario1));
        usuarioService.deleteUsuario(usuario1.getId());
        verify(usuarioRepository, times(1)).deleteById("1");
    }

    @Test
    public void deve_FazerUpdateDeUmUsuario() {
        when(usuarioRepository.findById(usuario3.getId())).thenReturn(Optional.of(usuario3));
        usuarioService.update(usuario4, usuario3.getId());
        assertEquals(usuario4, usuario3);
    }
}