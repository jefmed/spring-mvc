package com.jefmed.workshopmongo.controller;

import com.google.gson.Gson;
import com.jefmed.workshopmongo.controller.mapper.UsuarioMapper;
import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.request.UsuarioRequest;
import com.jefmed.workshopmongo.model.services.UsuarioService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {


    private MockMvc mockMvc;

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;


    private static UsuarioRequest usuarioRequest10 = UsuarioRequest.builder()
            .identity("10")
            .nome("usuarioRequest10")
            .email("usuarioRequest10@hotmail.com")
            .build();

    private static UsuarioRequest usuarioRequest20 = UsuarioRequest.builder()
            .identity("20")
            .nome("usuarioRequest20")
            .email("usuarioRequest20@hotmail.com")
            .build();

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

    public static String convertUsingGson(Usuario usuario)
    {
        Gson gson = new Gson();
        String usuarioJson = gson.toJson(usuario);
        return usuarioJson;
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
    }

    @Test
    public void deve_RetornarTodosUsuarios() throws Exception {
        List<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario1);
        usuarioList.add(usuario2);
        when(usuarioService.findAllUsers()).thenReturn(usuarioList);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/usuarios"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    public void deve_RetornarUmUsuario_quando_InformadoId() throws Exception {
        when(usuarioService.findUserById(usuario1.getId())).thenReturn(usuario1);
        mockMvc.perform(MockMvcRequestBuilders.get("/{id}", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deve_InserirUmNovoUsuario() throws Exception {

        //language=JSON
        String json = "{\n" +
                "  \"id\" : \"1\",\n" +
                "  \"nome\" : \"joaquim\",\n" +
                "  \"email\" : \"joaquim@gmail.com\"\n" +
                "}";



       when(usuarioService.insertNovoUsuario(UsuarioMapper.mapToUsuario(usuarioRequest10))).thenReturn(usuario1);
//        Usuario usuario = usuarioService.insertNovoUsuario();
//        String usuarioJson = convertUsingGson(usuario);


//        mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(usuarioJson))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void deve_DeletarUmUsuarioExistente() throws Exception {
        when(usuarioService.findUserById(usuario1.getId())).thenReturn(usuario1);
        doNothing().when(usuarioService).deleteUsuario(usuario1.getId());
        mockMvc.perform(MockMvcRequestBuilders.delete("/{id}", usuario1.getId())).andExpect(MockMvcResultMatchers.status().isNoContent());
        verify(usuarioService, times(1)).findUserById(usuario1.getId());
        verify(usuarioService, times(1)).deleteUsuario(usuario1.getId());
    }

    @Test
    public void deve_FazerUpdate_Quando_UsuarioExistir() {
    }

//    @Test(expected = ResourceNotFoundException.class)
//    public void deve_RetornarException_Quando_UsuarioExistir() {
//    }
}