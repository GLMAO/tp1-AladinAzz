package org.emp.gl.clients;

import java.awt.BorderLayout;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class HorlogeGUI implements TimerChangeListener {

    private final JLabel timeLabel;
    private final TimerService timerService;

    public HorlogeGUI(TimerService timerService) {
        this.timerService = timerService;
        this.timerService.addTimeChangeListener(this);

        JFrame frame = new JFrame("Horloge GL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        timeLabel = new JLabel("Chargement...", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));

        frame.getContentPane().add(timeLabel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(SECONDE_PROP)) {
            SwingUtilities.invokeLater(() -> {
                String time = String.format("%02d:%02d:%02d",
                        timerService.getHeures(),
                        timerService.getMinutes(),
                        timerService.getSecondes());
                timeLabel.setText(time);
            });
        }
    }

    public static void main(String[] args) {
        TimerService timer = new DummyTimeServiceImpl();
        SwingUtilities.invokeLater(() -> new HorlogeGUI(timer));
    }
}