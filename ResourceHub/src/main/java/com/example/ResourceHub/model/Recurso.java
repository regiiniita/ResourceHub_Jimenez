package com.example.ResourceHub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
public class Recurso {

    private Long id;
    private String titulo;
    private String url;
    private String tipo;
    private String categoria;
}
