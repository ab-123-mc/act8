import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraGeometrica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> resultados = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            try {
                int figura = seleccionarFigura(scanner);
                int operacion = seleccionarOperacion(scanner);

                double resultado = 0;
                switch (figura) {
                    case 1:
                        resultado = operarCirculo(scanner, operacion);
                        break;
                    case 2:
                        resultado = operarCuadrado(scanner, operacion);
                        break;
                    case 3:
                        resultado = operarTriangulo(scanner, operacion);
                        break;
                    case 4:
                        resultado = operarRectangulo(scanner, operacion);
                        break;
                    case 5:
                        resultado = operarPentagono(scanner, operacion);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        continue;
                }

                resultados.add(String.format("Resultado de la operación con la figura seleccionada: %.2f", resultado));
                System.out.println("Resultado: " + resultado);
                System.out.print("¿Desea realizar otra operación? (sí/no): ");
                String respuesta = scanner.next();
                if (!respuesta.equalsIgnoreCase("sí")) {
                    continuar = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese valores numéricos adecuados.");
                scanner.next(); // Limpiar la entrada incorrecta
            }
        }

        System.out.println("\nResultados de todas las operaciones:");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }

        scanner.close();
    }

    public static int seleccionarFigura(Scanner scanner) {
        System.out.println("Seleccione una figura geométrica:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        return scanner.nextInt();
    }

    public static int seleccionarOperacion(Scanner scanner) {
        System.out.println("Seleccione una operación:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        System.out.println("3. Potencia");
        return scanner.nextInt();
    }

    public static double operarCirculo(Scanner scanner, int operacion) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = scanner.nextDouble();
        switch (operacion) {
            case 1:
                return Math.PI * Math.pow(radio, 2);
            case 2:
                return 2 * Math.PI * radio;
            case 3:
                return calcularPotencia(scanner, radio);
            default:
                System.out.println("Operación no válida.");
                return 0;
        }
    }

    public static double operarCuadrado(Scanner scanner, int operacion) {
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = scanner.nextDouble();
        switch (operacion) {
            case 1:
                return lado * lado;
            case 2:
                return 4 * lado;
            case 3:
                return calcularPotencia(scanner, lado);
            default:
                System.out.println("Operación no válida.");
                return 0;
        }
    }

    public static double operarTriangulo(Scanner scanner, int operacion) {
        System.out.print("Ingrese la base del triángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del triángulo: ");
        double altura = scanner.nextDouble();
        switch (operacion) {
            case 1:
                return (base * altura) / 2;
            case 2:
                System.out.print("Ingrese el lado 1 del triángulo: ");
                double lado1 = scanner.nextDouble();
                System.out.print("Ingrese el lado 2 del triángulo: ");
                double lado2 = scanner.nextDouble();
                return base + lado1 + lado2;
            case 3:
                return calcularPotencia(scanner, base);
            default:
                System.out.println("Operación no válida.");
                return 0;
        }
    }

    public static double operarRectangulo(Scanner scanner, int operacion) {
        System.out.print("Ingrese el largo del rectángulo: ");
        double largo = scanner.nextDouble();
        System.out.print("Ingrese el ancho del rectángulo: ");
        double ancho = scanner.nextDouble();
        switch (operacion) {
            case 1:
                return largo * ancho;
            case 2:
                return 2 * (largo + ancho);
            case 3:
                return calcularPotencia(scanner, largo);
            default:
                System.out.println("Operación no válida.");
                return 0;
        }
    }

    public static double operarPentagono(Scanner scanner, int operacion) {
        System.out.print("Ingrese el lado del pentágono: ");
        double ladoPentagono = scanner.nextDouble();
        switch (operacion) {
            case 1:
                System.out.print("Ingrese el apotema del pentágono: ");
                double apotema = scanner.nextDouble();
                return (5 * ladoPentagono * apotema) / 2;
            case 2:
                return 5 * ladoPentagono;
            case 3:
                return calcularPotencia(scanner, ladoPentagono);
            default:
                System.out.println("Operación no válida.");
                return 0;
        }
    }

    public static double calcularPotencia(Scanner scanner, double base) {
        System.out.print("Ingrese el exponente: ");
        int exponente = scanner.nextInt();
        return potenciaRecursiva(base, exponente);
    }

    public static double potenciaRecursiva(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente > 0) {
            return base * potenciaRecursiva(base, exponente - 1);
        } else {
            return 1 / potenciaRecursiva(base, -exponente);
        }
    }
}
