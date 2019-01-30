package com.jefmed.workshopmongo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jefmed.workshopmongo.model.Usuario;
import com.jefmed.workshopmongo.model.services.UsuarioService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(controllers = UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsuarioService usuarioService;

//    @Autowired
//    private WebApplicationContext context;

//    @MockBean
//    private UsuarioRepository usuarioRepository;

//    @InjectMocks
//    private UsuarioController usuarioController;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(new UsuarioController()).build();
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


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




    @Test
    public void deve_RetornarTodosUsuarios() throws Exception {
        List<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario1);
        usuarioList.add(usuario2);
        when(usuarioService.findAllUsers()).thenReturn(usuarioList);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/usuarios").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }


    @Test
    public void deve_RetornarUmUsuario_quando_InformadoId() throws Exception {
       when(usuarioService.findUserById(usuario1.getId())).thenReturn(usuario1);
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/{id}", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void deve_InserirUmNovoUsuario() throws Exception {
        when(usuarioService.insertNovoUsuario(ArgumentMatchers.any(Usuario.class))).thenReturn(usuario1);
        mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
                .content(objectMapper.writeValueAsString(usuario1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }


    @Test
    public void deve_DeletarUmUsuarioExistente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/usuarios/{id}", usuario1.getId()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        verify(usuarioService, times(1)).deleteUsuario(usuario1.getId());
    }


    @Test
    public void deve_FazerUpdate_Quando_UsuarioExistir() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/usuarios/{id}", usuario1.getId())
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(usuario1)))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

    }


//    @Test(expected = ResourceNotFoundException.class)
//    public void deve_RetornarException_Quando_UsuarioExistir() {
//    }
}