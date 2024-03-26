package Trees;

import Nodes.Node_Reservation;

public class Tree_Reservations {
    private Node_Reservation root;

    public Tree_Reservations() {
        this.root = null;
    }
    
    /**
     * Este método se encarga de insertar un nodo dentro del árbol a traves de la recursividad.
     * @param reservation 
     */
    public void insertar(Node_Reservation reservation) {
        
        // VALIDAMOS SI LA RAÍZ ESTÁ VACÍA.
        if (this.isEmpty()) {
            this.root = reservation;
        } else {
            this.root.insertNodo(reservation);
        }
    }
    
    /**
     * Este metodo lo hizo ricky!
     * @param id
     * @param nodo
     * @return 
     */
    public Node_Reservation search(int id, Node_Reservation nodo){
        if (isEmpty()) {
            return null;
        } if (id == nodo.getKey()) {
            return nodo;
        } else {
            //Buscando elemento a la izquierda.
            if (id < nodo.getKey()) {
                return search(id,nodo.getLeft());
            } else {
                return search(id,nodo.getRight());
            }
        }
    }
    
    /**
     * Este método elimina un nodo del arbol dado una key.
     * @param idClient Key de nodo, en este caso el id del Cliente.
     * @param pointer Nodo Raíz para recorrer el arbol.
     * @param pointerPrevious Nodo previo para poder reordenar el arbol.
     */
    public void delete(int idClient, Node_Reservation pointer, Node_Reservation pointerPrevious) {
        if (isEmpty() == false) {
            if (idClient < pointer.getKey()) {
                delete(idClient, pointer.getLeft(), pointer);
            } else if (idClient > pointer.getKey()) {
                delete(idClient, pointer.getRight(), pointer);
            } else {
                //CASO 1: NODO HOJA (NO TIENE HIJOS)
                if (pointer.isLeaf()) {
                    //Si es la raíz que se desea eliminar.
                    if (pointerPrevious == null) {
                        setRoot(null);
                    //Si no es la raíz que se desea eliminar.
                    } else {
                        if (idClient < pointerPrevious.getKey()) {
                            pointerPrevious.setLeft(null);
                        } else {
                            pointerPrevious.setRight(null);
                        }
                    }
                //CASO 2: SI TIENE UN SOLO HIJO.
                } else if(pointer.hasLeftSon()) {
                    //Si es la raíz que se desea eliminar.
                    if (pointerPrevious == null){
                        setRoot(pointer.getLeft());
                    //Si no es la raíz que se desea eliminar.
                    } else {
                        if (idClient < pointerPrevious.getKey()) {
                            pointerPrevious.setLeft(pointer.getLeft());
                        } else {
                            pointerPrevious.setRight(pointer.getLeft());
                        }
                    }
                } else if(pointer.hasRightSon()) {
                    //Si es la raíz que se desea eliminar.
                    if (pointerPrevious == null) {
                        setRoot(pointer.getRight());
                    //Si no es la raíz que se desea eliminar.
                    } else {
                        if (idClient < pointerPrevious.getKey()) {
                            pointerPrevious.setLeft(pointer.getRight());
                        } else {
                            pointerPrevious.setRight(pointer.getRight());
                        }
                    }
                //CASO 3: CUANDO EL NODO TIENE 2 HIJOS.
                } else {
                    boolean hasRightSons = validateLeftSon(pointer.getLeft());
                    Node_Reservation temp = (hasRightSons) ? searchNodoToReplace(pointer.getLeft()) : pointer.getLeft();
                    if (pointerPrevious == null) {
                        temp.setLeft(getRoot().getLeft());
                        temp.setRight(getRoot().getRight());
                        setRoot(temp);
                    } else {
                        temp.setLeft(pointer.getLeft());
                        temp.setRight(pointer.getRight());
                        if (idClient < pointerPrevious.getKey()) {
                            pointerPrevious.setLeft(temp);
                        } else {
                            pointerPrevious.setRight(temp);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Método para validar el hijo izquierdo del Nodo.
     * @param node Nodo a validar.
     * @return Retorna true solo si el hijo derecho del nodo existe.
     */
    public boolean validateLeftSon(Node_Reservation node) {
        return node.getRight() != null;
    }
    
    /**
     * Método para conseguir el nodo a subir. (El mayor de los menores).
     * @param node Nodo raíz para poder recorrer el Arbol.
     * @return retorna el nodo que va a reemplazar al que deseamos eliminar.
     */
    public Node_Reservation searchNodoToReplace(Node_Reservation node){
        Node_Reservation previous = node;
        while (node.getRight() != null){
            previous = node;
            node = node.getRight();
        }
        previous.setRight(null);
        if(node.getLeft() != null) {
            previous.setRight(node.getLeft());
            node.setLeft(null);
        }
        return node;
    }
    
    // IMPRIMIMOS EN PREORDEN.
    public void shootPreOrder() {
        preOrder(this.root);
    }
    
    public void preOrder(Node_Reservation nodo) {
        if (nodo != null) {
            System.out.print(nodo.getKey() + ", ");
            preOrder(nodo.getLeft());
            preOrder(nodo.getRight());
        }
    }

    // IMPRIMIMOS EN ORDEN.
    public void shootInOrder() {
        inOrder(this.root);
    }
    
    public void inOrder(Node_Reservation nodo) {
        if (nodo != null) {
            inOrder(nodo.getLeft());
            System.out.print(nodo.getKey() + ", ");
            inOrder(nodo.getRight());
        }
    }
    
    // IMPRIMIMOS EN POSTORDEN.
    public void shootPostOrder() {
        postOrder(this.root);
    }
    
    public void postOrder(Node_Reservation nodo) {
        if (nodo != null) {
            postOrder(nodo.getLeft());
            postOrder(nodo.getRight());
            System.out.print(nodo.getKey() + ", ");
        }
    }
    
    // MÉTODO GET.
    public Node_Reservation getRoot() {
        return root;
    }

    // MÉTODO SET.
    public void setRoot(Node_Reservation root) {
        this.root = root;
    }
    
    // MÉTODO PARA VALIDAR SI ESTÁ VACÍO.
    public boolean isEmpty() {
        return root == null;
    }
}