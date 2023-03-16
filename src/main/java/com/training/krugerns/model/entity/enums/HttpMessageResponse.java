package com.training.krugerns.model.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpMessageResponse {
    /*
    * Enums for sucess
    */

    FIND_SUCESS("Busqueda realizada exitosamente"),
    SAVE_SUCESS("Registro exitoso"),
    UPDATE_SUCESS("Actualizaacion exitosa"),
    DELETE_SUCESS("Se eliminó correctamente"),


    /*
    * Enums for fails
    */
    NOT_FOUND("No se encontro el registro solicitado");

    private final String value;
}
