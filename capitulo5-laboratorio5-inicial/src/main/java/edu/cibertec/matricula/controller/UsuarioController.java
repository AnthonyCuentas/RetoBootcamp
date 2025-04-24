package edu.cibertec.matricula.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cibertec.matricula.dao.entity.UsuarioDTO;
import edu.cibertec.matricula.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UsuarioController {

  @Autowired
  private UsuarioServiceImpl usuarioServiceImpl;

  @GetMapping("/usuarioRandom")
  public ModelAndView getUsuarioAleatorio()
  {
    List<UsuarioDTO> usuarios = usuarioServiceImpl.obtenerUsuarioAleatorio();

    ModelAndView mv = new ModelAndView("usuarioRandom");
    mv.addObject("usuarios", usuarios);
    return mv;
  }
}
