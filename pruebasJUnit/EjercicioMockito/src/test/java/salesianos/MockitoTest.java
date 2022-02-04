package salesianos;
import com.salesianostriana.dam.ejerciciotesting.model.Cliente;
import com.salesianostriana.dam.ejerciciotesting.model.LineaDeVenta;
import com.salesianostriana.dam.ejerciciotesting.model.Producto;
import com.salesianostriana.dam.ejerciciotesting.model.Venta;
import com.salesianostriana.dam.ejerciciotesting.repos.ProductoRepositorio;
import com.salesianostriana.dam.ejerciciotesting.repos.VentaRepositorio;
import com.salesianostriana.dam.ejerciciotesting.services.VentaServicio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    @Mock
    VentaRepositorio ventaRepositorio;

    @Mock
    ProductoRepositorio productoRepositorio;

    @InjectMocks
    VentaServicio ventaServicio;


    //Caja Negra
    @Test
    public void whenVenta_thenReturnVentasWithouthClient(){
        Cliente cliente = new Cliente();
        LineaDeVenta lineaDeVenta = new LineaDeVenta(new Producto("4","Ratón 3 botones",19.99),1,19.99);
        List<LineaDeVenta> lista = new ArrayList<>();
        lista.add(lineaDeVenta);
        Venta v2 = new Venta(1L, LocalDate.of(2022,01,18),lista,cliente);
        when(productoRepositorio.findOne("4")).thenReturn(new Producto("4", "Ratón 3 botones", 19.99));
        when(ventaRepositorio.save(v2)).thenReturn(v2);
        Venta v = ventaServicio.nuevaVenta(Map.of("4", 1), cliente);
        assertEquals(v.getId(),v2.getId());
    }
    //Caja Blanca
    @Test
    public void whenDeleteLineaV_thenReturnVentawithClient(){
        Cliente c = new Cliente();
        LineaDeVenta lineaDeVenta = new LineaDeVenta(new Producto("1","Ordenador Portátil",699.0),1,699.0);
        LineaDeVenta lineaDeVenta2 = new LineaDeVenta(new Producto("2","Ordenador de sobremesa",499.0),1,499.0);
        List<LineaDeVenta> list = new ArrayList<>();
        c.setNombre("Luismi");
        list.add(lineaDeVenta);
        list.add(lineaDeVenta2);
        Optional<Venta> optionalVenta= Optional.of(new Venta(1L, LocalDate.of(2022, 01, 18), list, c));
        list.remove(lineaDeVenta2);
        Venta v =new Venta(1L, LocalDate.of(2022, 01, 18), list, c);
        list.add(lineaDeVenta2);
        when(ventaRepositorio.findOneOptional(1L)).thenReturn(optionalVenta);
        when(ventaRepositorio.edit(optionalVenta.get())).thenReturn(v);
        Venta v2 = ventaServicio.removeLineaVenta(1L,"2");
        assertEquals(v,v2);
    }

    //Caja Blanca
    @Test
    public void whenAddProducto_thenReturnVentawithClientNull(){
        Cliente cliente = new Cliente();
        LineaDeVenta lineaDeVenta = new LineaDeVenta(new Producto("3","Teclado mecánico retroiluminado",59.99),1,59.99);
        LineaDeVenta lineaDeVenta2 = new LineaDeVenta(new Producto("4","Ratón 3 botones",19.99),1,19.99);
        List<LineaDeVenta> list = new ArrayList<>();
        list.add(lineaDeVenta);
        Optional<Venta> optionalVenta= Optional.of(new Venta(1L, LocalDate.of(2022, 01, 18), list, cliente));
        list.add(lineaDeVenta2);
        Venta venta =new Venta(1L, LocalDate.of(2022, 01, 18), list, cliente);
        when(productoRepositorio.findOne("4")).thenReturn(new Producto("4", "Ratón 3 botones", 19.99));
        when(ventaRepositorio.edit(optionalVenta.get())).thenReturn(venta);
        when(ventaRepositorio.findOneOptional(1L)).thenReturn(optionalVenta);
        Venta v2 = ventaServicio.addProductoToVenta(1L,"4",1);
        assertEquals(venta,v2);
    }

    @Test
    public void whenNuevaVenta_success(){
        Producto p= Producto.builder()
                .codigoProducto("1")
                .nombre("Producto")
                .precio(12.36)
                .build();

        Cliente c= Cliente.builder()
                .nombre("Rompetechos")
                .email("rompetechos@ndln")
                .dni("123456789A")
                .build();

        lenient().when(productoRepositorio.findOne("1")).thenReturn(p);
        Map<String,Integer> carrito= Map.of("1",2);
        Venta v= new Venta();
        v.setId(2l);
        v.setCliente(c);
        v.setLineasDeVenta(List.of(new LineaDeVenta(p,2,12.36)));
        lenient().when(ventaRepositorio.save(v)).thenReturn(v);
        assertEquals(v,ventaServicio.nuevaVenta(carrito,c));
    }



}
