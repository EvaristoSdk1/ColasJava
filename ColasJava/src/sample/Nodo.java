package sample;

public class Nodo {

    private int valor;
    private Nodo proximo; //puntero hacia el siguiente nodo

    //Constructor simple, inicializa sin valor
    public Nodo() {
        this.valor=0;
        this.proximo=null;
    }

    //Constructor
    public Nodo(int valor){
        this.valor=valor;
        this.proximo=null;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public void Unir(Nodo n) {//Creamos un metodo que nos permite unir los valores ingresados a los nodos
        proximo = n;
    }

    public void setProximo(Nodo siguiente){
        this.proximo = siguiente;
    }

    public int getValor(){
        return this.valor;
    }

    public Nodo getProximo(){
        return this.proximo;
    }
}
