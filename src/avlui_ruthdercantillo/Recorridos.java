
package avlui_ruthdercantillo;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Recorridos {    
    static String aux = "";
    public static void preOrdenR(Nodo raiz){
        if (raiz!=null) {
            aux = aux +" "+ raiz.getDato();
            preOrdenR(raiz.getIzquierdo());
            preOrdenR(raiz.getDerecho());
        }
    }
    public static void preOrdenNR(Nodo raiz){
        Stack<Nodo> pila = new Stack();
        do{
            if(raiz!=null){
                System.out.println(raiz.getDato()+" ");                
                pila.add(raiz);
                raiz=raiz.getIzquierdo();
            }else{
                raiz=pila.pop();
                raiz=raiz.getDerecho();
            }
        }while(!pila.isEmpty() || raiz!=null);
    }
    public static void inOrdenR(Nodo raiz){
        if (raiz!=null) {
            inOrdenR(raiz.getIzquierdo());
            aux = aux +" "+ raiz.getDato();
            inOrdenR(raiz.getDerecho());
        }
    }
    public static void inOrdenNR(Nodo raiz){
        Stack<Nodo> pila = new Stack();
        do {
            if (raiz != null) {
                pila.add(raiz);
                raiz = raiz.getIzquierdo();
            } else {
                raiz = pila.pop();
                System.out.print(raiz.getDato() + " ");
                raiz = raiz.getDerecho();
            }
        } while (!pila.isEmpty() || raiz != null);
    }
    public static void postOrdenR(Nodo raiz){
        if (raiz!=null) {
            postOrdenR(raiz.getIzquierdo());
            postOrdenR(raiz.getDerecho());
            aux = aux +" "+ raiz.getDato();
        }
    }
    public static void nivelesNR(Nodo raiz){
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);        
         while(!cola.isEmpty()){
             raiz = cola.remove();
             System.out.print(raiz.getDato()+" ");
             if (raiz.getIzquierdo()!=null) 
                cola.add(raiz.getIzquierdo());
             if(raiz.getDerecho()!=null)
                 cola.add(raiz.getDerecho());             
         }
    }
    
    public static void niveles(int i, Nodo p){
        nivelX(i, p);
        if(i!=Propiedades.altura(p)){
            niveles(i+1, p);
        }
    }
    
    public static void nivelX(int x, Nodo p){
        if(p == null){
            
        }else{
            if(x>0){
                nivelX(x-1, p.getIzquierdo());
                nivelX(x-1, p.getDerecho());
            }else{
                if(x==0){
                    aux = aux +" "+ p.getDato();
                }
            }
        }
    }
    
}
