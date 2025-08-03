public class Car{

    private boolean powerOff = true;

    private int speed = 0;

    private int gear = 0;

    private int maxGearSpeed;

    private int minGearSpeed;

    private String direction;

    private void applyGearLimits(){

        switch(gear){

            case 0 -> {
                maxGearSpeed = 0;
                minGearSpeed = 0;
            }
            case 1 -> {
                maxGearSpeed = 20;
                minGearSpeed = 0;
            }
            case 2 -> {
                maxGearSpeed = 40;
                minGearSpeed = 21;
            }
            case 3 -> {
                maxGearSpeed = 60;
                minGearSpeed = 41;
            }
            case 4 -> {
                maxGearSpeed = 80;
                minGearSpeed = 61;
            }
            case 5 -> {
                maxGearSpeed = 100;
                minGearSpeed = 81;
            }
            case 6 -> {
                maxGearSpeed = 120;
                minGearSpeed = 101;
            }
        }
    }

    public int getGear(){

        return gear;
    }

    public int getSpeed(){

        return speed;
    }

    public String getPower(){

        if(powerOff){
            return "Desligado";
        }else{
            return "Ligado";
        }
    }

    public void powerOn(){

        if(powerOff){

            powerOff = false;
            System.out.println("Carro ligado.");
        }else{

            System.out.println("O carro já está ligado.");
        }
    }

    public void powerOff(){

        if(!powerOff){
            if(gear == 0 && speed == 0){

                powerOff = true;
                System.out.println("Carro desligado.");
            }else{

                System.out.println("Para desligar o carro deve estar no ponto morto(marcha 0) e totalmente parado");
            }

        }else{

            System.out.println("O carro já está desligado.");
        }
    }

    public void changeGearDown(){

        if(!powerOff){
            if(gear == 0){
                System.out.println("Esta no ponto morto, não tem como diminuir.");

            }else{
                gear -= 1;
                applyGearLimits();
                System.out.println("Marcha diminuida para " + gear);
            }
        }else{

            System.out.println("O carro está desligado");
        }

    }


    public void changeGearUp(){

        if(!powerOff){
            if(gear < 6){

                gear += 1;
                applyGearLimits();
                System.out.println("Marcha aumentada para " + gear);
            }else{

                System.out.println("Esta na ultima marcha, não tem como aumentar.");
            }
        }else{

            System.out.println("O carro está desligado");
        }

    }

    public void accelerate(){

        if(!powerOff && gear > 0){
            if((speed + 10) <= maxGearSpeed){
                speed += 10;
            }else{

                System.out.println("Velocidade máxima para essa marcha atingida. Aumenta a marcha.");
            }

        }else{

            System.out.println("O carro está desligado ou no ponto morto");
        }

    }

    public void brake(){

        if(!powerOff){
            if((speed - 10) >= minGearSpeed){
                speed -= 10;
            }else{

                System.out.println("Velocidade minima para essa marcha atingida. Diminua a marcha.");
            }

        }else{

            System.out.println("O carro está desligado ou no ponto morto");
        }

    }

    public void turn(String direction){

        if(!powerOff){
            if(speed >= 1 && speed <= 40){
                System.out.println("Você virou pra " + direction);
            }else{

                System.out.println("A velocidade não está adequada para virar (1 a 40 Km/h).");
            }

        }else{

            System.out.println("O carro está desligado ou no ponto morto");
        }
    }


}