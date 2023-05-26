/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_carmencastillo;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author casti
 */
public class Lab6P1_CarmenCastillo {

    static Scanner leer = new Scanner(System.in);
    static Scanner leer2 = new Scanner(System.in);
    static Random ran = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguirmenu = true;
        while (seguirmenu) {
            int opcionmenu = Menu();
            switch (opcionmenu) {
                case 1:
                    System.out.print("Ingrese el tamaño del arreglo a generar: ");
                    int tama = leer.nextInt();
                    //leer el tama del arreglo
                    System.out.print("Ingrese el límite inferior: ");
                    int liminf = leer.nextInt();
                    //limite inferior
                    System.out.print("Ingrese el limite superior: ");
                    int limsup = leer.nextInt();
                    //limite superior

                    int[] sal = new int[tama];
                    System.out.println("Arreglo Generado: ");
                    sal = genRandArray(tama, liminf, limsup);
                    System.out.println("\nCuenta de primos: ");
                    print(getTotalPrimeCount(sal));
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Ingrese una palabra: ");
                    String palabra = leer2.nextLine();
                    //leer la palabra
                    int contmin = 0;
                    for (int i = 0; i < palabra.length(); i++) {
                        int car = (int) palabra.charAt(i);
                        if (car >= 97 && car <= 122 || car == 65533) {
                            contmin++;
                        }
                    }
                    boolean palvalid = false;
                    if (contmin == 0) {
                        System.out.println("La palabra no es valida.");
                    } else {
                        palvalid = true;
                    }
                    int[] arreglo= extraerFrecuencias(palabra);
                    for (int i = 0; i < arreglo.length; i++) {
                        System.out.print("[" + arreglo[i] + "]");
                    }
                    System.out.println("\n[a][b][c][d][e][f][g][h][i][j][k][l][m][n][o][p][q][r][s][t][u][v][w][x][y][z][ñ][á][é][í][ó][ú][ü]");
                    break;

                default:
                    seguirmenu = false;
                    break;

            }

        }
    }

    public static int Menu() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("MENU");
        System.out.println("1. ¿Cuántos primos tienes?");
        System.out.println("2. Frecuencia de letras");
        System.out.println("3. Salir");
        int opcion = leer.nextInt();

        return opcion;

    }

    public static int[] genRandArray(int tam, int lim1, int lim2) {
        int[] temporal = new int[tam];

        for (int i = 0; i < tam; i++) {
            int randInt = ran.nextInt(lim2 - lim1) + lim1;
            System.out.print("[" + randInt + "]");
            temporal[i] = randInt;
        }
        return temporal;

    }

    public static boolean isPrime(int x) {
        int conta = 1;
        int conta2 = 0;
        while (conta <= x) {
            if (x % conta == 0) {
                conta2++;
            }
            conta++;
        }
        boolean primo = true;
        if (conta2 == 2) {
            primo = true;
        } else {
            primo = false;

        }
        return primo;

    }

    public static int countPrimeFactors(int sal) {
        int contador = 0;
        for (int j = 2; j <= sal; j++) {
            if (isPrime(j) && sal % j == 0) {
                contador++;
            }
        }
        return contador;
    }

    public static int[] getTotalPrimeCount(int[] generado) {
        int[] contador = new int[generado.length];
        for (int i = 0; i < generado.length; i++) {
            int cuenta = countPrimeFactors(generado[i]);
            contador[i] = cuenta;
//            System.out.print("No. divisores primos: ");
//            System.out.println("[" + contador[i] + "]" + " ");
        }

        return contador;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
        }
    }

    public static int[] extraerFrecuencias(String pal) {
        int[] frecuencias = new int[33];
        for (int i = 0; i < pal.length(); i++) {
            char caract = pal.charAt(i);
            if ((int)caract >= 97 && (int)caract <= 122) {
                frecuencias[(int) caract - 97]++;
            } else {
                switch (caract) {
                    case 'ñ':
                        frecuencias[26]++;
                        break;
                    case 'á':
                        frecuencias[26]++;
                        break;
                    case 'í':
                        frecuencias[26]++;
                        break;
                    case 'é':
                        frecuencias[26]++;
                        break;
                    case 'ó':
                        frecuencias[26]++;
                        break;
                    case 'ú':
                        frecuencias[26]++;
                        break;
                    case 'ü':
                        frecuencias[26]++;
                        break;
                }

            }

        }

        // for if
        //(car+97)-97 [es el indice]
        return frecuencias;
    }

}
