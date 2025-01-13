import java.util.List;
import java.util.ArrayList;

public interface Observer {
  void update(String news);
}

public class NewsAgency {
  private List<Observer> observers = new ArrayList<>();

  public void subscribe(Observer observer) {
    observers.add(observer);
  }

  public void sendUpdate(String news) {
    for (Observer observer : observers) {
      observer.update(news);
    }
  }
}

public class NewsReader implements Observer {
  @Override
  public void update(String news) {
    System.out.println("Received news: " + news);
  }
}

public class Main {
  public static void main(String[] args) {
    NewsAgency agency = new NewsAgency();
    NewsReader reader = new NewsReader();
    agency.subscribe(reader);
    agency.sendUpdate("Breaking news!");
  }
}