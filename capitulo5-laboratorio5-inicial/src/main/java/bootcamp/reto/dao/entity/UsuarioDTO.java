package bootcamp.reto.dao.entity;

import lombok.Data;


@Data
public class UsuarioDTO {

  private String nombre;

  private String genero;

  private String ubicacion;

  private String email;

  private String fechaNacimiento;

  private String foto;

}
