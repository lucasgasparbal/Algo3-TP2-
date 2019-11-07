package test;

import org.junit.Test;
import org.junit.Assert;
import model.Curandero;
import model.Soldado;
import model.Catapulta;


public class CatapultaTest {

    @Test
    public void atacoCincoVecesASoldadoMurioDevuelveTrue() {
        int i = 0;
        Catapulta catapulta = new Catapulta (3,2);
        Soldado soldado = new Soldado (4,6);
        while (i<10) {
            catapulta.atacar(soldado);
            i++;
        }
        Assert.assertTrue(soldado.murio());

    }

    @Test
    public void atacoTresVecesACuranderoMurioDevuelveFalse() {
        int i = 0;
        Catapulta catapulta = new Catapulta (3,2);
        Curandero curandero = new Curandero (4,6);
        while (i<3) {
            catapulta.atacar(curandero);
            i++;
        }
        Assert.assertFalse(curandero.murio());
    }

    @Test
    public void atacoCuatroVecesACuranderoMurioDevuelveTrue() {
        int i = 0;
        Catapulta catapulta = new Catapulta (3,2);
        Curandero curandero = new Curandero (4,6);
        while (i<4) {
            catapulta.atacar(curandero);
            i++;
        }
        Assert.assertTrue(curandero.murio());
    }

}
