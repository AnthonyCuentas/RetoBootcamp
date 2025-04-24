package bootcamp.reto.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import bootcamp.reto.dao.entity.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UsuarioServiceImpl {

  private static final String API_URL= "https://randomuser.me/api";

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  public List<UsuarioDTO> obtenerUsuarioAleatorio(){
    try {
      String url = UriComponentsBuilder.fromHttpUrl(API_URL)
              .queryParam("results", 10) // Número de usuarios aleatorios
              .toUriString();
      String jsonResponse = restTemplate.getForObject(url, String.class);

      JsonNode root = objectMapper.readTree(jsonResponse);
      JsonNode results = root.path("results");

      List<UsuarioDTO> usuarios = new ArrayList<>();
      for (JsonNode usuario : results) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setGenero(usuario.path("gender").asText());
        dto.setNombre(
                usuario.path("name").path("first").asText() + " " +
                        usuario.path("name").path("last").asText()
        );
        dto.setUbicacion(usuario.path("location").path("city").asText());
        dto.setUbicacion(usuario.path("location").path("country").asText());
        dto.setEmail(usuario.path("email").asText());
        dto.setFechaNacimiento(usuario.path("dob").path("date").asText());
        dto.setFoto(usuario.path("picture").path("large").asText());

        usuarios.add(dto);
      }
      return usuarios;

    }catch (Exception e){
      System.out.println("Error al consumir la API: " + e.getMessage());
      return Collections.emptyList();
    }
  }


}
