package TP4.EJ8;



public class Main {
    public static void main(String[] args) {
        GrafoDirigido<Tarea> grafoTareas = new GrafoDirigido<>();

      Tarea t0 = new Tarea("Tarea 0", "Descripcion de la tarea 0", 0);
        Tarea t1 = new Tarea("Tarea 1", "Descripcion de la tarea 1", 4);
        Tarea t2 = new Tarea("Tarea 2", "Descripcion de la tarea 2", 18);
        Tarea t3 = new Tarea("Tarea 3", "Descripcion de la tarea 3", 4);
        Tarea t4 = new Tarea("Tarea 4", "Descripcion de la tarea 4", 13);
        Tarea t5 = new Tarea("Tarea 5", "Descripcion de la tarea 5", 22);
        Tarea t6 = new Tarea("Tarea 6", "Descripcion de la tarea 6", 18);
        Tarea t7 = new Tarea("Tarea 7", "Descripcion de la tarea 7", 12);
        Tarea t8 = new Tarea("Tarea 8", "Descripcion de la tarea 8", 3);
        Tarea t9 = new Tarea("Tarea 9", "Descripcion de la tarea 9", 2);
        Tarea t10 = new Tarea("Tarea 10", "Descripcion de la tarea 10", 3);
        Tarea t11 = new Tarea("Tarea 11", "Descripcion de la tarea 11", 1);
        Tarea t12 = new Tarea("Tarea 12", "Descripcion de la tarea 12", 5);


        grafoTareas.agregarVertice(t0);
        grafoTareas.agregarVertice(t1);
        grafoTareas.agregarVertice(t2);
        grafoTareas.agregarVertice(t3);
        grafoTareas.agregarVertice(t4);
        grafoTareas.agregarVertice(t5);
        grafoTareas.agregarVertice(t6);
        grafoTareas.agregarVertice(t7);
        grafoTareas.agregarVertice(t8);
        grafoTareas.agregarVertice(t9);
        grafoTareas.agregarVertice(t10);
        grafoTareas.agregarVertice(t11);
        grafoTareas.agregarVertice(t12);


        grafoTareas.agregarArco(t0, t2, 0);
        grafoTareas.agregarArco(t0, t1, 0);
        grafoTareas.agregarArco(t1, t3, 3);
        grafoTareas.agregarArco(t3, t4, 5);
        grafoTareas.agregarArco(t3, t6, 8);
        grafoTareas.agregarArco(t4, t11, 3);
        grafoTareas.agregarArco(t11, t12, 9);
        grafoTareas.agregarArco(t6, t12, 2);
        grafoTareas.agregarArco(t2, t5, 1);
        grafoTareas.agregarArco(t2, t7, 18);
        grafoTareas.agregarArco(t7, t8, 7);
        grafoTareas.agregarArco(t8, t9, 4);
        grafoTareas.agregarArco(t9, t10, 1);
        grafoTareas.agregarArco(t5, t6, 2);
        grafoTareas.agregarArco(t6, t10, 6);


       /*   Tarea A = new Tarea("A", "Iniciar proyecto", 10);
        Tarea B = new Tarea("B", "Analizar", 20);
        Tarea C = new Tarea("C", "Diseñar", 30);
        Tarea D = new Tarea("D", "Implementar", 40);
        Tarea E = new Tarea("E", "Testear", 20);

        grafoTareas.agregarVertice(A);
        grafoTareas.agregarVertice(B);
        grafoTareas.agregarVertice(C);
        grafoTareas.agregarVertice(D);
        grafoTareas.agregarVertice(E);

        grafoTareas.agregarArco(A, B, 5);
        grafoTareas.agregarArco(B, C, 10);
        grafoTareas.agregarArco(C, D, 5);
        grafoTareas.agregarArco(C, E, 15);
*/

        TareasMayorEjec t = new TareasMayorEjec(grafoTareas);
        System.out.println(t.getTareasMaxTiempoEjec(t0) + " total hs: " + t.getMayorSum());
    }
}