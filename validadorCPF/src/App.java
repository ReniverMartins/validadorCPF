import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static String Validacpf(String cpf) {

        char oneValid, twoValid;
        int sum, i, r;
        int number, peso;

        if (cpf.contains("*") || cpf.contains("-")) {
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
        }

        if(cpf.length() != 11 ||
        cpf.equals("11111111111") ||
        cpf.equals("22222222222") ||
        cpf.equals("33333333333") ||
        cpf.equals("44444444444") ||
        cpf.equals("55555555555") ||
        cpf.equals("66666666666") ||
        cpf.equals("77777777777") ||
        cpf.equals("88888888888") ||
        cpf.equals("99999999999") ||
        cpf.equals("00000000000")) {
            return "cpf invalido";
        } else {

            try {
                sum = 0;
                peso = 10;

                for (i = 0; i < 9; i++) {
                    number = (int) (cpf.charAt(i) - 48);
                    sum = sum + (number * peso);
                    peso = peso - 1;
                }

                r = 11 - (sum % 11);

                if ((r == 10) || (r == 11))
                    oneValid = '0';
                else
                    oneValid = (char) (r + 48);

                sum = 0;
                peso = 11;

                for (i = 0; i < 10; i++) {
                    number = (int) (cpf.charAt(i) - 48);
                    sum = sum + (number * peso);
                    peso = peso - 1;
                }

                r = 11 - (sum % 11);
                if ((r == 10) || (r == 11))
                    twoValid = '0';
                else
                    twoValid = (char) (r + 48);

                if ((oneValid == cpf.charAt(9)) && (twoValid == cpf.charAt(10))) {
                    return "CPF Valido!";
                } else {
                    return "CPF Invalido!";
                }

            } catch (InputMismatchException erro) {
                return "Erro Inexperado";
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        String cpf;

        System.out.println("Insira o cpf ex:(000.000.000-00 ou 00000000000)");
        cpf = input.next();
        System.out.println(Validacpf(cpf));
    }
}
