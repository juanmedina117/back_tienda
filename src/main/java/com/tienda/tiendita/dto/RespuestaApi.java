package com.tienda.tiendita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
@Getter
@Setter
public class RespuestaApi {

    private boolean success;
    private String message;
    private Object data;


}