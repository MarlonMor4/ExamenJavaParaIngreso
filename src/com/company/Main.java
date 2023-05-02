package com.company;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputData = new Scanner(System.in);
        List<Pelicula> catalogo = new ArrayList<>(); // Creamos una lista vacía de películas
        String answer = "Yes";

        while (answer.equalsIgnoreCase("Yes")) {
            // Mostramos un menú para que el usuario pueda agregar una película o ver el catálogo existente
            System.out.println("BIENVENIDO AL REGISTRO DE PELICULAS");
            System.out.println("1. Agregar una nueva película");
            System.out.println("2. Ver el catálogo existente");

            int option = inputData.nextInt();

            switch (option) {
                case 1:
                    // Agregar una nueva película al catálogo
                    System.out.println("REGISTRO DE PELICULA");

                    Pelicula pelicula = new Pelicula(); // Creamos una nueva instancia de Pelicula

                    // Preguntamos al usuario por el nombre, autor y fecha de la película
                    System.out.println("Ingrese el nombre de la pelicula:");
                    pelicula.setName(inputData.next());

                    System.out.println("Ingrese el autor de la pelicula:");
                    pelicula.setAutor(inputData.next());

                    System.out.println("Ingrese la fecha de estreno de la pelicula:");
                    System.out.println("Opción 1: Ingrese la fecha en formato yyyy/mm/dd");
                    System.out.println("Opción 2: Ingrese la fecha en formato dd-mm-yyyy");
                    int opcionFecha = inputData.nextInt();
                    String fechaString = "";

                    // Validamos que la fecha tenga el formato correcto
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    dateFormat.setLenient(false);

                    DateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
                    dateFormat2.setLenient(false);

                    try {
                        if (opcionFecha == 1) {
                            fechaString = inputData.next();
                            dateFormat.parse(fechaString);
                        } else if (opcionFecha == 2) {
                            fechaString = inputData.next();
                            dateFormat2.parse(fechaString);
                        } else {
                            System.out.println("Opción de fecha inválida");
                            continue;
                        }

                        pelicula.setFecha(fechaString); // Establecemos la fecha de estreno de la película
                        catalogo.add(pelicula); // Agregamos la película al catálogo
                    } catch (ParseException e) {
                        System.out.println("Fecha inválida");
                        continue;
                    }

                    break;
                case 2:
                    // Mostrar el catálogo existente
                    System.out.println("CATÁLOGO DE PELÍCULAS:");

                    if (catalogo.isEmpty()) { // Si la lista está vacía, informamos al usuario
                        System.out.println("El catálogo está vacío.");
                    } else { // Si no, mostramos las películas en el catálogo
                        for (int i = 0; i < catalogo.size(); i++) {
                            System.out.println("Nombre: "  + catalogo.get(i).getName());
                            System.out.println("Autor: " +  catalogo.get(i).getName());
                            System.out.println("Fecha de estreno: " + catalogo.get(i).getName());
                            System.out.println("");
                        }
                    }

                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }


            // Preguntar al usuario si desea agregar otra película o ver el catálogo existente
            while (true) {
                System.out.println("¿Desea agregar otra película o ver el catálogo existente? (Agregar/Ver)");
                String opcion = inputData.nextLine();

                if (opcion.equalsIgnoreCase("Agregar")) {
                    // Si el usuario desea agregar otra película, volvemos al inicio del ciclo
                    break;
                } else if (opcion.equalsIgnoreCase("Ver")) {
                    // Si el usuario desea ver el catálogo existente, mostramos las películas en el catálogo
                    if (catalogo.isEmpty()) { // Si la lista está vacía, informamos al usuario
                        System.out.println("El catálogo está vacío.");
                    } else { // Si no, mostramos las películas en el catálogo
                        for (int i = 0; i < catalogo.size(); i++) {
                            System.out.println("Nombre: " + catalogo.get(i).getName());
                            System.out.println("Autor: " + catalogo.get(i).getAutor());
                            System.out.println("Fecha de estreno: " + catalogo.get(i).getFecha());
                            System.out.println("");
                        }
                    }

                    break;
                } else {
                    System.out.println("Opción inválida. Por favor ingrese 'Agregar' o 'Ver'.");
                }
            }
        }
    }
}
