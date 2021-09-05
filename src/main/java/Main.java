import javax.swing.*;
import java.net.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {

        URL oracle = new URL("https://belarusbank.by/api/kursExchange");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        StringBuilder nak = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            nak.append(inputLine);
        }
        nak.delete(38, nak.length());
        nak.delete(0, 3);
        String USD_in, USD_out;
        USD_in = nak.substring(9,15);
        USD_out = nak.substring(28, 34);

        Double uin = Double.parseDouble(USD_in);
        Double uout = Double.parseDouble(USD_out);


        JDialog.setDefaultLookAndFeelDecorated(true);
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Сколько вы собираетесь обменять?"));
        JOptionPane.showMessageDialog(null, "При конвертации BYN в $ вы получите " + Math.round((Double)amount/uin) + "$ \n"+"При конвертации $ в BYN вы получите " + (uout * (Double)amount) +" BYN");

        in.close();
    }
}
