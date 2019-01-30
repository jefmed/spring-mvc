package com.jefmed.workshopmongo.suites;


import com.jefmed.workshopmongo.controller.UsuarioControllerTest;
import com.jefmed.workshopmongo.model.services.UsuarioServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({UsuarioControllerTest.class, UsuarioServiceTest.class})
public class SuiteExec {
}
