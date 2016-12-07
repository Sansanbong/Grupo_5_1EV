package com.android.grupo5;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sanch on 07/12/2016.
 */

public class Juego {

    private Configuracion configuracion;
    private ArrayList<Casilla> listCasillas;

    public Juego(Configuracion configuracion) {
        this.configuracion = configuracion;
        this.listCasillas=new ArrayList<>();
    }

    public void generarCasillas(){
        int numCasillas=this.configuracion.getX()*this.configuracion.getY();
        Random random=new Random();
        for (int y=1; y<=this.configuracion.getY(); y++){
            for (int x=1; x<=this.configuracion.getX(); x++){
                listCasillas.add(new Casilla(x, y, random.nextInt(this.configuracion.getValorMax())+1));
            }
        }
    }

    public int getIndex(Casilla casilla){
        for (Casilla item: listCasillas){
            if (casilla.getX()==item.getX() && casilla.getY()==item.getY())
                return listCasillas.indexOf(item);
        }
        return -1;
    }

    public void pulsarCasilla(Casilla casilla){
        casilla=listCasillas.get(this.getIndex(casilla)); //Para coger el objeto que está dentro de la lista.
        casilla.incrementarValor(this.configuracion.getValorMax());

        if (casilla.getX()==1 || casilla.getX()==this.configuracion.getValorMax()){
            for (Casilla item: listCasillas){
                if (item.getY()==casilla.getY() || item.getX()==casilla.getX())
                    item.incrementarValor(this.configuracion.getValorMax());
            }
        }

        else {
            for (Casilla item: listCasillas){
                if (item.getY()==casilla.getY() || item.getX()==casilla.getX())
                    item.incrementarValor(this.configuracion.getValorMax());
            }
        }

    }

    public boolean condicionVictoria(){
        Casilla aux=null;
        for (Casilla item: listCasillas){
            if (aux!=null){
                if (aux.getValor()!=item.getValor())
                    return false;
            }
            aux=item;
        }
        return true;
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public ArrayList<Casilla> getCasillas() {
        return listCasillas;
    }
}
