import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main_88 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://www.rideuta.com/Riding-UTA/Schedules/routeSchedulePage/1"; // your URL here
        Document doc = Jsoup.connect(url).get();  // get the document
        Elements rows = doc.select("table").first().select("tr");
        int i = 0;
        for (Element row : rows) {               // scan all <tr> elements
            if (!row.text().equals("") && i != 0) {   // exclude table header and empty lines
                Elements tds = row.getElementsByClass("time");    // get the columns in this row where time is displayed
                String depTime = "";             // to hold departure times in a string
                for (Element td : tds) {           // loop through all "<td>...</td>" elements under this "tr" tag
                    if (!td.text().equals("No")) { // ignore the cells that do not have departure time (i.e., No or empty strings)
                        if (!depTime.equals("")) depTime += ", ";    // separate multiple times with a comma and space
                        depTime += td.text();     // add another departure time to this string
                    }
                }
                i++;
                System.out.println("Route: " + i + "\tDeparture times: " + depTime);  // print/save the parsed data as required
            }
        }
    }
}