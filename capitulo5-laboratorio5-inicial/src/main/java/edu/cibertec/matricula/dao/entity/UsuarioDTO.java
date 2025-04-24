package edu.cibertec.matricula.dao.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Arrays;

@Data
public class UsuarioDTO {

  private String nombre;

  private String genero;

  private String ubicacion;

  private String email;

  private String fechaNacimiento;

  private String foto;

}
