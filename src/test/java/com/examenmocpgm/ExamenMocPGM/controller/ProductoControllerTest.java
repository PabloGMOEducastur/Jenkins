package com.examenmocpgm.ExamenMocPGM.controller;

import com.examenmocpgm.ExamenMocPGM.entity.Producto;
import com.examenmocpgm.ExamenMocPGM.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class ProductoControllerTest {

    @Mock
    ProductoService productoService;

    @InjectMocks
    ProductoController productoController;

    @Test
    void getProductoControllerTest() {
        Producto productoEsperado = new Producto();
        productoEsperado.setId(1L);
        productoEsperado.setNombre("Producto1");
        //Solucinado

        Mockito.when(productoService.findProducto(1L))
                .thenReturn(Optional.of(productoEsperado));

        Optional<Producto> resultado = productoController.getProducto(1L);

        if (resultado.isPresent()) {
            assertEquals(productoEsperado, resultado.get());
        }

        Mockito.verify(productoService, Mockito.times(1)).findProducto(1L);
        System.out.println("prueba");
    }
}