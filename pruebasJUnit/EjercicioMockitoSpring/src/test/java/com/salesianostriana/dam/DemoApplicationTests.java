package com.salesianostriana.dam;

import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.model.LineaDeVenta;
import com.salesianostriana.dam.model.Producto;
import com.salesianostriana.dam.model.Venta;
import com.salesianostriana.dam.repos.ProductoRepositorio;
import com.salesianostriana.dam.repos.VentaRepositorio;
import com.salesianostriana.dam.service.VentaServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class DemoApplicationTests {

	@MockBean
	ProductoRepositorio productoRepositorio;

	@MockBean
	VentaRepositorio ventaRepositorio;


	VentaServicio ventaServicio;

	@BeforeEach
	public void setUp(){
		ventaServicio= new VentaServicio(productoRepositorio,ventaRepositorio);
	}

	//Este metodo no consigo igualar las ids//
	@Test
	void whenNuevaVenta_succes() {

		Producto p= Producto.builder()
				.id(1L)
				.codigoProducto("1")
				.nombre("Ordenador portatil")
				.precio(12.36)
				.build();

		Cliente c= Cliente.builder()
				.nombre("Rompetechos")
				.email("rompetechos@gmail.com")
				.dni("123456789A")
				.build();

		lenient().when(productoRepositorio.findById(1L)).thenReturn(java.util.Optional.ofNullable(p));
		Map<Long,Integer> carrito= Map.of(1L,2);
		Venta v= new Venta();
		v.setId(2L);
		v.setCliente(c);
		v.setLineasDeVenta(List.of(new LineaDeVenta(p,2,12.36)));
		lenient().when(ventaRepositorio.save(v)).thenReturn(v);
		assertThat(v.equals(ventaServicio.nuevaVenta(carrito,c)));
	}

	//Compruebo que los datos sean todos iguales para testear y me sigue saliendo mal
	@Test
	public void whenDeleteLineaV_thenReturnVentawithClient(){
		Cliente c = new Cliente();
		LineaDeVenta lineaDeVenta = new LineaDeVenta(new Producto(1L,"1","Ordenador Portátil",699.0),1,699.0);
		LineaDeVenta lineaDeVenta2 = new LineaDeVenta(new Producto(2L,"2","Ordenador de sobremesa",499.0),1,499.0);
		List<LineaDeVenta> list = new ArrayList<>();
		c.setNombre("Luismi");
		list.add(lineaDeVenta);
		list.add(lineaDeVenta2);
		Optional<Venta> optionalVenta= Optional.of(new Venta(1L, LocalDate.of(2022, 01, 18), list, c));
		list.remove(lineaDeVenta2);
		Venta v =new Venta(1L, LocalDate.of(2022, 01, 18), list, c);
		list.add(lineaDeVenta2);
		when(ventaRepositorio.findById(1L)).thenReturn(optionalVenta);
		when(ventaRepositorio.save(v)).thenReturn(v);
		Venta v2 = ventaServicio.removeLineaVenta(1L,2L);
		assertThat(v.equals(v2));
	}

	//Compruebo que los datos sean todos iguales para testear y me sigue saliendo mal
	@Test
	public void whenAddProducto_thenReturnVentawithClientNull(){
		Cliente cliente = Cliente.builder()
				.nombre("Martin")
				.email("martincuale@gmail.com")
				.dni("123456789L")
				.build();
		LineaDeVenta lineaDeVenta = new LineaDeVenta(new Producto(3L,"3","Teclado mecánico retroiluminado",59.99),1,59.99);
		LineaDeVenta lineaDeVenta2 = new LineaDeVenta(new Producto(4L,"4","Ratón 3 botones",19.99),1,19.99);
		List<LineaDeVenta> list = new ArrayList<>();
		list.add(lineaDeVenta);
		Optional<Venta> optionalVenta= Optional.of(new Venta(3L, LocalDate.of(2022, 01, 18), list, cliente));
		list.add(lineaDeVenta2);
		Venta venta =new Venta(3L, LocalDate.of(2022, 01, 18), list, cliente);
		when(productoRepositorio.findById(4L)).thenReturn(Optional.of(new Producto(2L, "4", "Ratón 3 botones", 19.99)));
		when(ventaRepositorio.save(venta)).thenReturn(venta);
		when(ventaRepositorio.findById(1L)).thenReturn(optionalVenta);
		Venta v2 = ventaServicio.addProductoToVenta(1L,4L,1);
		assertThat(venta.equals(v2));
	}


	@Test
	public void createsNewVenta(){

		Cliente cliente = new Cliente("12345678H", "Pedro");
		Producto producto = Producto.builder()
				.id(4L)
				.codigoProducto("123")
				.nombre("Leche Semidesnatada")
				.precio(1)
				.build();

		Map<Long, Integer> carrito = Map.of(4L, 2);
		Venta v = new Venta();
		v.setId(2L);
		v.setCliente(cliente);
		v.setLineasDeVenta(List.of(new LineaDeVenta(producto,2, producto.getPrecio())));

		lenient().when(productoRepositorio.findById(any(Long.class))).thenReturn(Optional.of(producto));
		lenient().when(ventaRepositorio.save(any(Venta.class))).thenReturn(v);
		Venta result = ventaServicio.nuevaVenta(carrito, cliente);

		assertEquals(1, result.getLineasDeVenta().size());


	}




}
