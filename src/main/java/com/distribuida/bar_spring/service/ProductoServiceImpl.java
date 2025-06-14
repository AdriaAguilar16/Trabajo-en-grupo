package com.distribuida.bar_spring.service;

import com.distribuida.bar_spring.dao.ProductoRepository;
import com.distribuida.bar_spring.model.Producto;
import jakarta.websocket.OnError;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    @Override
    public Producto findOne(int id){
        Optional<Producto>producto=productoRepository.findById(id);
        return producto.orElse(null);
    }

    @Override
    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(int id,Producto productonuevo){
        Producto productoexistente=findOne(id);
        if (productoexistente == null){
            return null;
        }

        productoexistente.setIdProducto(productonuevo.getIdProducto());
        productoexistente.setNombreProducto(productonuevo.getNombreProducto());
        productoexistente.setPrecio(productonuevo.getPrecio());
        productoexistente.setStock(productonuevo.getStock());
        return productoRepository.save(productoexistente);

    }

    @Override
    public void delete(int id){
        if (productoRepository.existsById(id)){
            productoRepository.deleteById(id);
        }
    }


}
