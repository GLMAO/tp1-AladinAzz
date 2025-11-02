package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import java.beans.PropertyChangeEvent;

public class CompteARebours implements TimerChangeListener{

     int compte;
     final TimerService timerService;
     final int id;
     static int nextId= 1;

    public CompteARebours(int leCompte, TimerService timerService) {
        this.compte = leCompte;
        this.timerService = timerService;
        this.id = nextId++;
        this.timerService.addTimeChangeListener(this);
        }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        if (propertyName.equals(TimerChangeListener.SECONDE_PROP)) {
            if (compte > 0) {
                compte--;
                System.out.println("CompteARebours " + id + ": " + compte);
            }
            if (compte == 0) {
                timerService.removeTimeChangeListener(this);
                System.out.println("CompteARebours " + id + " arrivé à 0 et désinscrit.");
            }
        }
    }


}
