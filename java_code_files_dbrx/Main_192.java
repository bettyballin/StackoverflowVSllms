interface Facade {
    void watchMovie();
}

class HomeTheaterFacade implements Facade {
    private Amplifier amp;
    private Tuner tuner;
    private DvdPlayer dvd;
    private CdPlayer cd;
    private Projector projector;
    private Screen screen;
    private TheaterLights lights;
    private PopcornPopper popper;

    public HomeTheaterFacade(
            Amplifier amp,
            Tuner tuner,
            DvdPlayer dvd,
            CdPlayer cd,
            Projector projector,
            Screen screen,
            TheaterLights lights,
            PopcornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.cd = cd;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
        this.popper = popper;
    }

    @Override
    public void watchMovie() {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);
        dvd.on();
        dvd.play();
    }
}

// Subsystem classes
class Amplifier {
    public void on() { System.out.println("Amplifier on"); }
    public void setDvd(DvdPlayer dvd) { System.out.println("Amplifier setting DVD player"); }
    public void setSurroundSound() { System.out.println("Amplifier surround sound on"); }
    public void setVolume(int level) { System.out.println("Amplifier setting volume to " + level); }
}

class Tuner {
    // Tuner methods (omitted for brevity)
}

class DvdPlayer {
    public void on() { System.out.println("DVD Player on"); }
    public void play() { System.out.println("DVD Player playing"); }
}

class CdPlayer {
    // CD Player methods (omitted for brevity)
}

class Projector {
    public void on() { System.out.println("Projector on"); }
    public void wideScreenMode() { System.out.println("Projector in widescreen mode"); }
}

class Screen {
    public void down() { System.out.println("Screen going down"); }
}

class TheaterLights {
    public void dim(int level) { System.out.println("Theater lights dimming to " + level + "%"); }
}

class PopcornPopper {
    public void on() { System.out.println("Popcorn Popper on"); }
    public void pop() { System.out.println("Popcorn Popper popping popcorn!"); }
}

public class Main {
    public static void main(String[] args) {
        // Create subsystems
        Amplifier amp = new Amplifier();
        Tuner tuner = new Tuner();
        DvdPlayer dvd = new DvdPlayer();
        CdPlayer cd = new CdPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLights lights = new TheaterLights();
        PopcornPopper popper = new PopcornPopper();

        // Create facade with its subsystems passed in constructor
        Facade facade = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, screen, lights, popper);

        // All parts of home theater are operated by a simple command
        facade.watchMovie();
    }
}