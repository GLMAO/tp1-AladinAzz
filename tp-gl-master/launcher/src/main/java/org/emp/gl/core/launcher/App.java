package org.emp.gl.core.launcher;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge ;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        TimerService timer = new DummyTimeServiceImpl();
        /*testDuTimeService(timer);*/
        testDesComptesARebours(timer);


    }

    private static void testDuTimeService(TimerService timer) {

        Horloge horloge = new Horloge("Num 0",timer) ;
        Horloge horloge1 = new Horloge("Num 1",timer) ;
        Horloge horloge2 = new Horloge("Num 2",timer) ;
        Horloge horloge3 = new Horloge("Num 3",timer) ;
    }

    public static void testDesComptesARebours(TimerService timer) {
        CompteARebours compte1 = new CompteARebours(5,timer) ;
        CompteARebours compte2 = new CompteARebours(8,timer) ;
        CompteARebours compte3 = new CompteARebours(12,timer) ;
        CompteARebours compte4 = new CompteARebours(12,timer) ;
        CompteARebours compte5 = new CompteARebours(12,timer) ;
        CompteARebours compte6 = new CompteARebours(12,timer) ;
        CompteARebours compte7 = new CompteARebours(12,timer) ;
        CompteARebours compte8 = new CompteARebours(12,timer) ;
        CompteARebours compte9 = new CompteARebours(12,timer) ;
        CompteARebours compte10 = new CompteARebours(12,timer) ;
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
