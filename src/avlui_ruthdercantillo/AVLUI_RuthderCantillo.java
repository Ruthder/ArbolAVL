
package avlui_ruthdercantillo;

public class AVLUI_RuthderCantillo {
    Nodo Raiz;
    String aux = "";
    
    public AVLUI_RuthderCantillo() {
        Raiz = null;
    }

    public int altura(Nodo Nodo) {
        if (Nodo == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(Nodo.getIzquierdo()), altura(Nodo.getDerecho()));
        }
    }
    
    public int tamaño(Nodo Nodo) {
        if (Nodo == null) {
            return 0;
        } else {
            return 1 + tamaño(Nodo.getIzquierdo()) + tamaño(Nodo.getDerecho());
        }
    }
    
    public int hojas(Nodo Nodo) {
        if (Nodo == null) {
            return 0;
        } else if (Nodo.getIzquierdo() == null && Nodo.getDerecho() == null) {
            return 1;
        } else {
            return hojas(Nodo.getIzquierdo()) + hojas(Nodo.getDerecho());
        }
    }
    
    public int completos(Nodo Nodo) {
        int conti = 0;
        if (Nodo != null) {
            conti = completos(Nodo.getIzquierdo()) + completos(Nodo.getDerecho());
            if (Nodo.getIzquierdo() != null && Nodo.getDerecho() != null) {
                conti = conti + 1;
            }
        }
        return conti;
    }
    
    public static void main(String[] args) {
        AVLUI_RuthderCantillo avl = new AVLUI_RuthderCantillo();
        Ventana v = new Ventana(avl);
        v.setVisible(true);
    }
    
}
