import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class MontyHall {
    public static void main(String[] args) throws IOException {
        int escolha;
        int portaEscolhida;
        int portaVazia = 0;
        String troca;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("*****************************");
            System.out.println("PORTA DOS DESESPERADOS!!!");
            System.out.println("1) JOGAR");
            System.out.println("0) SAIR :(");
            System.out.println("*****************************");
            escolha = scanner.nextInt();

            switch (escolha){
                case 1:
                    System.out.println("Escolha uma porta de 1 a 3");
                    Random r = new Random();
                    int minimo = 1;
                    int maximo = 3;
                    int portaPremiada = r.nextInt(maximo-minimo) +minimo;
                    portaEscolhida = scanner.nextInt();

                    do {
                        portaVazia = r.nextInt(maximo-minimo) +minimo;
                    } while (portaPremiada == portaVazia || portaVazia == portaEscolhida);
                    System.out.println("O apresentador abriu a porta " +portaVazia+ " e ela estava vazia, deseja trocar a sua porta escolhida? (s/n)");
                    troca = scanner.next();
                    if (troca.equals("s") && portaEscolhida == portaPremiada){
                        System.out.println("Você perdeu! A porta premiada era: " +portaPremiada);
                    } else if (troca.equals("s") && portaEscolhida != portaPremiada) {
                        System.out.println("Você venceu!!!");

                    } else if (portaEscolhida == portaPremiada){
                        System.out.println("Você venceu!!!");
                    }
                    else {
                        System.out.println("Você perdeu! A porta premiada era: " +portaPremiada);
                    }


                    System.out.println("Porta escolhida: "+portaEscolhida+" Porta Premiada: "+portaPremiada+ " Porta Vazia: " +portaVazia);
                    break;

            }
        }
        while (escolha != 0);
    }

}