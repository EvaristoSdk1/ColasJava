package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by UchihaMadara on 20/11/2017 0020.
 */
public class Cola{

    private Nodo frente;//el inicio de la cola

    Controller controller;

    // constructor simple
    public Cola() {
        this.frente = null;
    }

    //Método para insertar siguiente elemento (nodo), el elemento debe colocarse detrás del último nodo
    public void insertar(int valor){
        Nodo nuevo = new Nodo(valor);

        if(frente == null){
            frente = nuevo;
        }else{
            Nodo temp = frente;
            while(temp.getProximo() != null){
                temp = temp.getProximo();
            }
            temp.setProximo(nuevo);
        }
    }

    //Método para mostrar los elementos de la cola
    public void mostrar( ){

        if( frente != null){
            Nodo temp = frente;

            System.out.println("Los valores de la cola son: ");

            while(temp != null){
                //System.out.println(temp.getValor());
                temp = temp.getProximo();
            }

        }else{
            System.out.println("La cola está vacía.");
        }
    }


    //Método para extraer el elemento del frente
    public int extraer(){
        if(frente == null){
            return 0;
        }else{
            int valorExtraer = frente.getValor(); //variable temporal
            System.out.println("Valor extraído: "+ frente.getValor());
            frente = frente.getProximo(); //cambiar el frente por el siguiente
            return valorExtraer ; //devolver el valor extraído de la cola
        }
    }

    public void buscar(int busqueda) {

        try {
            Nodo temp = frente;
            int posicion = 1;

            if (temp.getValor() == busqueda) {
                System.out.println("El valor esta en la posición 0");
            } else {
                while (temp != null) {
                    if (temp.getProximo().getValor() == busqueda) {

                        System.out.println("valor en la posicion:" + posicion);

                        break;
                    }
                    posicion++;
                    temp = temp.getProximo();
                }}
        }
        catch (Exception ex)
        {
            System.out.println("El elemento no se encuentra");
        }
    }

    public int tamano (){//Creamos un metodo que nos permitira contar los elemntos que tiene la pila
        Nodo aux = null;
        int i=0; //declaramos la varibale i que tiene el valor 0
        aux = frente;
        while(aux != null){//Cuenta los valores de la pila
            aux = aux.getProximo();//suma los valores de 1 por 1
            i++;// y se incrementa el valor de la variable i
        }
        return i;//y nos retorna el valor de la variable i
    }

    public boolean vacia (){
        return ( frente == null);
    }
}
