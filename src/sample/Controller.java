package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Label lbHeader;
    @FXML
    TextField txtYourName, txtZengName;
    @FXML
    TextArea txtResult;

    String f_name;
    String z_name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbHeader.setText("Zeng Finder");
        txtResult.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
    }

    public void calculateZeng(ActionEvent actionEvent) {
        f_name = txtYourName.getText();
        z_name = txtZengName.getText();
        if (f_name.equals("") || z_name.equals("")) {
            System.out.println("No empty fields");
        } else
            randomNumber();
            // zengNames();
        txtYourName.setText("");
        txtZengName.setText("");
    }

    private void randomNumber(){
        f_name = txtYourName.getText();
        z_name = txtZengName.getText();
        Random rd = new Random();
        int randnum = rd.nextInt(10)+1;
        if (randnum <= 10 && randnum >= 9) {
            txtResult.setText(randnum+"\nPossibility of a Zeng between\n"+f_name+" and "+z_name+" is 100%");
        } else if (randnum < 9 && randnum >= 7){
            txtResult.setText(randnum+"\nPossibility of a Zeng between\n"+f_name+" and "+z_name+" is 80%");
        } else if (randnum < 7 && randnum >= 5){
            txtResult.setText(randnum+"\nPossibility of a Zeng between\n"+f_name+" and "+z_name+" is 60%");
        } else if (randnum < 5 && randnum >= 3){
            txtResult.setText(randnum+"\nPossibility of a Zeng between\n"+f_name+" and "+z_name+" is 40%");
        } else if (randnum < 3 && randnum >= 2){
            txtResult.setText(randnum+"\nPossibility of a Zeng between\n"+f_name+" and "+z_name+" is 20%");
        } else {
            txtResult.setText(randnum+"\nPossibility of a Zeng between\n"+f_name+" and "+z_name+" is Not possible");
        }
    }

    /*private void zengNames() {
        char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O'};
        f_name = txtYourName.getText().toUpperCase();
        z_name = txtZengName.getText().toUpperCase();
        String fz = f_name+z_name;
        char[] f = fz.toCharArray();
        int z = 0;
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= arr.length; j++) {
                if (arr[i] == f[j]) {
                    z = arr[i] + f[j];
                }
            }
        }
        System.out.println(z+"%");
    }*/

    /*
    public static void percentages(String... data) {
        Map<Character, Integer> map = new TreeMap<>();
        for(String s : data) {
            for(char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        int total = map.values().stream().reduce(0, (x,y) -> x+y);
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            double percentage = entry.getValue() * 100.0 / total;
            System.out.println(entry.getKey() + " has a percentage of " + percentage);
        }
    }
    * */

    public void clearBtn(ActionEvent actionEvent) {
        txtYourName.setText("");
        txtZengName.setText("");
        txtResult.setText("");
    }
}
