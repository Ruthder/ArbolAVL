package avlui_ruthdercantillo;


public class Metodos {

    //2
    public static int q;

    public static Nodo insertarAVL(Nodo raiz, int dato) {
        if (raiz == null) {
            Ventana.jLabel4.setText("Tipo de rotación: Ninguna");
            Ventana.jLabel12.setText("Elemento insertado: " + dato);
            return new Nodo(dato);
        } else if (dato > raiz.getDato()) {
            raiz.setDerecho(insertarAVL(raiz.getDerecho(), dato));
        } else if (dato < raiz.getDato()) {
            raiz.setIzquierdo(insertarAVL(raiz.getIzquierdo(), dato));
        }
        Ventana.jLabel12.setText("Elemento insertado: " + dato);
        int factorBalance = Propiedades.factorBalance(raiz);
        if (factorBalance == -2 && Propiedades.factorBalance(raiz.getIzquierdo()) != 1) {
            Ventana.jLabel4.setText("Tipo de rotación: Rotacion derecha");
            q = 1;
            return rotacionSimpleDer(raiz);
        }
        if (factorBalance == 2 && Propiedades.factorBalance(raiz.getDerecho()) != -1) {
            Ventana.jLabel4.setText("Tipo de rotación: Rotacion izquierda");
            q = 1;
            return rotacionSimpleIzq(raiz);
        }
        if (factorBalance == -2 && Propiedades.factorBalance(raiz.getIzquierdo()) == 1) {

            q = 1;
            return rotacionDobleIzquierda(raiz);
        }
        if (factorBalance == 2 && Propiedades.factorBalance(raiz.getDerecho()) == -1) {

            q = 1;
            return rotacionDobleDerecha(raiz);
        }
        if (q == 0) {
            Ventana.jLabel4.setText("Tipo de rotación: Ninguna");
        }
        return raiz;
    }

    public static Nodo buscarAVL(Nodo raiz, int dato) {
        if (raiz != null) {
            if (raiz.getDato() == dato) {
                return raiz;
            }
            if (dato > raiz.getDato()) {
                return buscarAVL(raiz.getDerecho(), dato);
            } else {
                return buscarAVL(raiz.getIzquierdo(), dato);
            }
        }
        return null;
    }

    public static Nodo rotacionSimpleDer(Nodo raiz) {
        Nodo hijo = raiz.getIzquierdo();
        raiz.setIzquierdo(hijo.getDerecho());
        hijo.setDerecho(raiz);
        return hijo;
    }

    public static Nodo rotacionSimpleIzq(Nodo raiz) {
        Nodo hijo = raiz.getDerecho();
        raiz.setDerecho(hijo.getIzquierdo());
        hijo.setIzquierdo(raiz);
        return hijo;
    }

    public static Nodo rotacionDobleIzquierda(Nodo raiz) {
        Ventana.jLabel4.setText("Tipo de rotación: Doble rotacion izquierda");
        raiz.setIzquierdo(rotacionSimpleIzq(raiz.getIzquierdo()));
        return rotacionSimpleDer(raiz);
    }

    public static Nodo rotacionDobleDerecha(Nodo raiz) {
        Ventana.jLabel4.setText("Tipo de rotación: Doble rotacion derecha");
        raiz.setDerecho(rotacionSimpleDer(raiz.getDerecho()));
        return rotacionSimpleIzq(raiz);
    }

    public static Nodo borrarAVL(Nodo raiz, int dato) {
        if (raiz == null) {
            return raiz;
        }
        if (dato < raiz.getDato()) {
            raiz.setIzquierdo(borrarAVL(raiz.getIzquierdo(), dato));
        } else if (dato > raiz.getDato()) {
            raiz.setDerecho(borrarAVL(raiz.getDerecho(), dato));
        } else if ((raiz.getIzquierdo() == null) || (raiz.getDerecho() == null)) {
            Nodo temp = null;
            if (temp == raiz.getIzquierdo()) {
                temp = raiz.getDerecho();
            } else {
                temp = raiz.getIzquierdo();
            }
            if (temp == null) {
                temp = raiz;
                raiz = null;
            } else {
                raiz = temp;
            }
        } else {

            Nodo temp = Propiedades.maximo(raiz.getIzquierdo());

            raiz.setDato(temp.getDato());

            raiz.setIzquierdo(borrarAVL(raiz.getIzquierdo(), temp.getDato()));
        }

        if (raiz == null) {
            return raiz;
        }

        int factorBalance = Propiedades.factorBalance(raiz);

        if (factorBalance == -2 && Propiedades.factorBalance(raiz.getIzquierdo()) != 1) {
            q = 1;
            Ventana.jLabel4.setText("Tipo de rotación: Rotacion derecha");
            return rotacionSimpleDer(raiz);

        }
        if (factorBalance == 2 && Propiedades.factorBalance(raiz.getDerecho()) != -1) {
            q = 1;
            Ventana.jLabel4.setText("Tipo de rotación: Rotacion izquierda");
            return rotacionSimpleIzq(raiz);
        }
        if (factorBalance == -2 && Propiedades.factorBalance(raiz.getIzquierdo()) == 1) {
            q = 1;
            return rotacionDobleIzquierda(raiz);
        }
        if (factorBalance == 2 && Propiedades.factorBalance(raiz.getDerecho()) == -1) {
            q = 1;
            return rotacionDobleDerecha(raiz);
        }
        if (q == 0) {
            Ventana.jLabel4.setText("Tipo de rotación: Ninguna");
        }
        return raiz;
    }

}
