package kata7;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class Watch {
    private static final double SecondsPerStep = 2 * Math.PI / 60;
    private static final double MinutesPerStep = SecondsPerStep / 60;
    private static final double HoursPerStep = MinutesPerStep / 24;

    private double seconds = Math.PI / 2 + SecondsPerStep * LocalDateTime.now().getSecond();
    private double minutes = Math.PI / 2 + SecondsPerStep * LocalDateTime.now().getMinute();
    private double hours = Math.PI / 2 + HoursPerStep * LocalDateTime.now().getHour();
    private final Timer timer;
    private final List<Observer> observers = new ArrayList<>();
    
    public Watch() {
        timer = new Timer();
        timer.schedule(timerTask(), 0, 1000);
    }

    private TimerTask timerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                step();
                updateObservers();
            }
        };
    }
    
    private void step() {
        seconds = Math.PI / 2 + SecondsPerStep * LocalDateTime.now().getSecond();
        minutes = Math.PI / 2 + SecondsPerStep * LocalDateTime.now().getMinute();
        hours = Math.PI / 2 + HoursPerStep * LocalDateTime.now().getHour();
    }

    private void updateObservers() {
        for (Observer observer : observers) 
            observer.update(null, null);
    }

    public double getSeconds() {
        return seconds;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getHours() {
        return hours;
    }

    public void add(Observer observer) {
        observers.add(observer);
    }

    private double normalize(double v) {
        return v % (2 * Math.PI);
    }
    
}

