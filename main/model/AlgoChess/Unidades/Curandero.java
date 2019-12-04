package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Unidades.Ataques.Curacion;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public class Curandero extends UnidadMovible {

    private final static int Costo = 2;
    final int VidaCurandero = 75;
    private final int ValorCuracion = 15;

    private Curacion ataque = new Curacion(ValorCuracion);

    public void atacar(Unidad objetivo) throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion {
        ataque.atacar(objetivo,this);
    }

    public Curandero(Equipo unEquipo) {
        super(unEquipo);
        vida = new Vida(VidaCurandero);
        costo = Costo;
    }

    public boolean sePuedeComprarConPuntos(int puntos){
        return puntos >= Costo;
    }
}