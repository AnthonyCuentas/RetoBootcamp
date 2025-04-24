package bootcamp.reto.controller;

import bootcamp.reto.dao.entity.UsuarioDTO;
import bootcamp.reto.service.impl.UsuarioServiceImpl;
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
