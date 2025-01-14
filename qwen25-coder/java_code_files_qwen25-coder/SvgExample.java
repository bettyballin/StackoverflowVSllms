public interface EntryPoint {
    void onModuleLoad();
}

class RootPanel {
    public static RootPanel get(String id) {
        return new RootPanel();
    }

    public Element getElement() {
        return new Element();
    }
}

class Element {
    public void setInnerHTML(String html) {
        // Stub method for setInnerHTML
    }
}

public class SvgExample implements EntryPoint {

    public void onModuleLoad() {
        // Create an SVG element that we will insert into the DOM
        String svgContent = "<svg xmlns='http://www.w3.org/2000/svg' version='1.1' id='mySvg'"
                         + " width='100' height='100'>"
                         + "  <circle cx='50' cy='50' r='30' stroke='black' stroke-width='3' fill='red'/>"
                         + "</svg>";

        // Get the container element where we want to insert our SVG
        Element svgContainer = RootPanel.get("svgContainer").getElement();

        // Insert the SVG using innerHTML
        svgContainer.setInnerHTML(svgContent);

        // Use JSNI to add a circle programmatically and handle mouse events
        addCircleAndEvents();
    }

    private native void addCircleAndEvents();
    
    public static void main(String[] args) {
        SvgExample example = new SvgExample();
        example.onModuleLoad();
    }
}