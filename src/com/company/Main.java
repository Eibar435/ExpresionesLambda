package com.company;
import java.util.ArrayList;
import java.util.Collections;

//Autor: Eibar Abisai Velazquez Guevara
public class Main {

    interface AnonClass {
        public void anonMethod();
    }
    interface MathOperation {
        double make(double a, double b);
    }
    interface Mailer {
        void sendUsing(String service);
    }
    static class Mail {
        private String sender;
        private String receiver;
        private String message;

        public Mail(String sender, String receiver, String message) {
            this.sender = sender;
            this.receiver = receiver;
            this.message = message;
        }
        private String compose() {
            String composeString = "From:%s|To:%s|Message:%s";
            return String.format(composeString, sender, receiver, message);
        }
        void send(String mailService) {
            System.out.println("Sending using " + mailService);
            System.out.println(compose());
        }
    }
    public static void main(String[] args) {
        ArrayList<String> colorArrayList = new ArrayList<String>();
        Longitud ss = new Longitud();
        System.out.println("********************************************");
        colorArrayList.add("negro");
        colorArrayList.add("rojo");
        colorArrayList.add("cafe");
        colorArrayList.add("azul");
        colorArrayList.add("morado");
        colorArrayList.add("amarillo");
        colorArrayList.add("blanco");
        colorArrayList.add("gris");
        colorArrayList.add("verde");
        colorArrayList.add("rosa");
        Collections.sort(colorArrayList, ss);
        System.out.println("Por longitud: " + colorArrayList);
        Collections.sort(colorArrayList);
        System.out.println("Por orden alfabetico: " + colorArrayList);

        String localVariable = "Printing the local variable value";
        AnonClass anon = new AnonClass() {
            public void anonMethod() {
                System.out.println("********************************************");
                System.out.println("*************** Clase Anonima **************");
                System.out.println("Inside method of anonymous class");
                System.out.println(localVariable);
            }
        };
        anon.anonMethod();
        System.out.println("********************************************");
        System.out.println("************ Expresiones Lambda ************");
        MathOperation gcd = (x, y) -> {
            double a = Math.max(x, y);
            double b = Math.min(x, y);
            double t = 0.0;
            do {
                t = b;
                b = a % b;
                a = t;
            } while(b != 0);
            return t;
        };
        double num1 = 10.0;
        double num2 = 5;
        System.out.println("GCD = " + gcd.make(num1, num2));

        System.out.println("********************************************");
        System.out.println("*********** Metodo de referencia ***********");
        Mail fooMail = new Mail("foo@mail.com", "bar@mail.com", "Hello World!");
        Mail barMail = new Mail("bar@mail.com", "baz@mail.com", "Exception thrown");

        Mailer fooMailer = fooMail::send;
        Mailer barMailer = barMail::send;
        fooMailer.sendUsing("GMail");
        barMailer.sendUsing("Outlook");
    }
}