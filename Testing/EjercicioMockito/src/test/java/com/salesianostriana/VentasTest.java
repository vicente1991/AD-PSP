package com.salesianostriana;


import com.salesianostriana.dam.ejerciciotesting.repos.ProductoRepositorio;
import com.salesianostriana.dam.ejerciciotesting.repos.VentaRepositorio;
import com.salesianostriana.dam.ejerciciotesting.services.VentaServicio;
import lombok.experimental.ExtensionMethod;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtensionMethod(Mockito.class)
public class VentasTest {

    @InjectMocks
    VentaServicio ventaServicio;

    @Mock
    VentaRepositorio ventaRepositorio;

    @Mock
    ProductoRepositorio productoRepositorio;


    //codigo null
    public void productoConCodigoNull(){

    }

}
