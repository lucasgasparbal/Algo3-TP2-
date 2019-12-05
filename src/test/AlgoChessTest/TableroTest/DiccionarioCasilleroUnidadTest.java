package AlgoChessTest.TableroTest;

import model.AlgoChess.Excepciones.NoHayUnidadAliadaEnCasilleroExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.DiccionarioCasilleroUnidad;
import model.AlgoChess.Unidades.Unidad;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiccionarioCasilleroUnidadTest {
    @Test(expected = NoHayUnidadAliadaEnCasilleroExcepcion.class)
    public void DiccionarioCasilleroUnidadObtenerUnidadEnCasilleroTiraExcepcionSiNoHayUnidadEnElCasillero() throws NoHayUnidadAliadaEnCasilleroExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casillero = mock(Casillero.class);

        diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casillero);
    }

    @Test
    public void DiccionarioCasilleroUnidadObtenerUnidadEnCasilleroDevuelveUnidadSiLaAgregoAntes() throws NoHayUnidadAliadaEnCasilleroExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casillero = mock(Casillero.class);
        Unidad unidad = mock(Unidad.class);

        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casillero,unidad);

        Assert.assertEquals(unidad,diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casillero));
    }

    @Test(expected = NoHayUnidadAliadaEnCasilleroExcepcion.class)

    public void DiccionarioCasilleroUnidadActualizoLaPosicionDeUnaUnidadNoLaPuedoConseguirPorSuCasilleroViejo() throws NoHayUnidadAliadaEnCasilleroExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casilleroA = mock(Casillero.class);
        Casillero casilleroB = mock(Casillero.class);
        Unidad unidad = mock(Unidad.class);
        when(unidad.getUbicacion()).thenReturn(casilleroB);
        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casilleroA,unidad);
        diccionarioCasilleroUnidad.actualizarCasilleroUnidad(casilleroA,casilleroB);

        diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casilleroA);
    }

    @Test
    public void DiccionarioCasilleroUnidadActualizoLaPosicionDeUnaUnidadLaConsigoPorSuCasilleroNuevo() throws NoHayUnidadAliadaEnCasilleroExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casilleroA = mock(Casillero.class);
        Casillero casilleroB = mock(Casillero.class);
        Unidad unidad = mock(Unidad.class);
        when(unidad.getUbicacion()).thenReturn(casilleroB);
        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casilleroA,unidad);
        diccionarioCasilleroUnidad.actualizarCasilleroUnidad(casilleroA,casilleroB);

        Assert.assertEquals(unidad,diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casilleroB));
    }
}