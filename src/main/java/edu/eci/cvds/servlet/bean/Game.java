package edu.eci.cvds.servlet.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean(name = "juego")
@SessionScoped
public class Game {
    public int numero;
    public int intento;
    public ArrayList<Integer> puestos;
    public int premio;
    public boolean estado;
    public Game(){
        numero=(int)Math.floor(Math.random()*(20-0+1)+0);
        intento=0;
        puestos=new ArrayList<Integer>();
        premio=100000;
        estado=false;
    }

    public String getmuestra(){
        if (estado){
            return "display: visible ;";
        }
        return "display: none ;";
    }
    public int getNumero(){
        return numero;
    }
    public int getintento() {
        return intento;
    }

    public void setintento() {
        intento ++;
    }

    public ArrayList<Integer> getPuestos() {
        return puestos;
    }

    public void setPuestos(int puesto) {
        if(puestos.size()==2){
            puestos.remove(0);
        }
        puestos.add(puesto);
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio() {
        premio -= 10000;
    }

    public String isEstado() {
        if (estado && premio>0){
            return "Ha ganado el juego, su premio es de "+premio;
        }
        else if(estado && premio==0){
            return "Has perdido";
        }
        return "Aun no ha ganado el juego";
    }

    public void setEstado() {
        estado = true;
    }

    public void guess(int num){

        if (!estado) {
            setintento();
            setPuestos(num);
            if (num==numero ){
                setEstado();
            }
            else {
                setPremio();
                if (premio==0){
                    setEstado();
                }
            }
        }
    }

    public void restart(){
        numero=(int)Math.floor(Math.random()*(20-0+1)+0);
        intento=0;
        puestos=new ArrayList<Integer>();
        premio=100000;
        estado=false;
    }
}
