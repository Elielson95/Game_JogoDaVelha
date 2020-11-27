package br.ucsal.pooa.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.Timer;

public class RelogioLabel extends JLabel {

    public RelogioLabel() {
        Timer t = new Timer(1000, e -> setText(getDateTime()));
        t.setInitialDelay(0);
        t.start();
    }

    private String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}