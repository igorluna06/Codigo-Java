import java.util.Scanner;


public class Main{

    private final static Scanner input = new Scanner(System.in);

    private final static Car car = new Car();

    public static void main(String[] args){

        int option;

        while(true){

            System.out.println("\n=== Escolha uma das opções ===");
            System.out.println("1 - Informações do carro");
            System.out.println("2 - Ligar carro");
            System.out.println("3 - Desligar carro");
            System.out.println("4 - Aumentar marcha");
            System.out.println("5 - Diminuir marcha");
            System.out.println("6 - Acelerar");
            System.out.println("7 - Frear");
            System.out.println("8 - Virar esquerda");
            System.out.println("9 - Virar direita");
            System.out.println("10 - Verificar velocidade");
            System.out.println("0 - Sair");
            option = input.nextInt();

            switch (option){
                case 1-> checkCarInfo();
                case 2 -> car.powerOn();
                case 3 -> car.powerOff();
                case 4 -> car.changeGearUp();
                case 5 -> car.changeGearDown();
                case 6 -> car.accelerate();
                case 7 -> car.brake();
                case 8 -> car.turn("Esquerda");
                case 9 -> car.turn("Direita");
                case 10 -> System.out.println("Velocidade atual: " + car.getSpeed() + " Km/h");
                case 0 -> {
                    input.close();
                    System.exit(0);
                }
                default -> System.out.println("Opção invalida");
            }
        }
    }

    private static void checkCarInfo(){

        var speed = car.getSpeed();
        var gear = car.getGear();
        var power = car.getPower();
        System.out.println("Estado : " + power);
        System.out.println("Velocidade: " + speed + " Km/h");
        if(gear == 0){

            System.out.println("Marcha: Ponto morto");
        }else{
            System.out.println("Marcha: " + gear);
        }



    }


}