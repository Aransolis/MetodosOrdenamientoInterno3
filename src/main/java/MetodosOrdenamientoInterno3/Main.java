/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodosOrdenamientoInterno3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aran Solis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] b = {33, 102, 12, 156, 2, 65, 52, 27};
    
        System.out.println("Antes Ordenamiento Radix");
        imprimir(b);

        System.out.println("Despues Ordenamiento Radix");
        radixSort(b);
        imprimir(b);

    }

    public static void radixSort(int[] arreglo) {
        final int RADIX = 10;
        // declarar y incializar listas[0,1,2,3,4,5,6,7,8,9] 
        List<Integer>[] lista = new ArrayList[RADIX];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = new ArrayList<Integer>();
        }
        boolean maxLength = false;
        int tmp = -1, digito = 1; //variables/ tmp para obtener numero/ digito para indicar posicon
        
        while (!maxLength) { //mientras no sea igual a true
            maxLength = true;
            // separar arreglo en lista 
            for (Integer i : arreglo) { //recorremos arreglo
                tmp = i / digito;  //102/1000 = 0.043 = 0

                lista[tmp % RADIX].add(i); //vamos a agregar a la lista correspondiente
                
                if (maxLength && tmp > 0) { //NOS SIRVE PARA SALIR DEL BUCLE
                   
                    maxLength = false;
                    
                }
            }
        // vaciamos listas a arreglo
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : lista[b]) {
                    arreglo[a++] = i;
                }
                lista[b].clear();
            }
        // desplazamos a siguiente digito
            digito *= RADIX;

        }
    }

    public static void imprimir(int[] a) {
        for (int i = 0; i < a.length; i++) { //IMPRIMO 
            System.out.print("[" + a[i] + "]");
        }
        System.out.println("\n");
    }
}
