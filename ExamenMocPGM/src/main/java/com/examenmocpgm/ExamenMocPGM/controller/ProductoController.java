package com.examenmocpgm.ExamenMocPGM.controller;

import com.examenmocpgm.ExamenMocPGM.entity.Producto;
import com.examenmocpgm.ExamenMocPGM.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/productos")
    public Producto addProducto(@RequestBody Producto producto) {
        return productoService.addProducto(producto);
    }

    @DeleteMapping("/producto/{productoId}")
    public void deleteProducto(@PathVariable Long productoId) {
        productoService.eliminarProductoById(productoId);
    }

    @PutMapping("/producto/{productoId}")
    public Producto modificarProducto(@PathVariable Long productoId,
                                      @RequestBody Producto producto) {
        return productoService.modificarProducto(productoId, producto);
    }

    @GetMapping("/productos")
    public List<Producto> getProductos(
            @RequestParam(defaultValue = "0.0") Float precio,
            @RequestParam(defaultValue = "") String categoria) {

        // Por ahora devuelve todos (como en tu implementación)
        return productoService.findAllProductos();
    }

    @GetMapping("/producto/{productoId}")
    public Optional<Producto> getProducto(@PathVariable Long productoId) {
        return productoService.findProducto(productoId);
    }
}
