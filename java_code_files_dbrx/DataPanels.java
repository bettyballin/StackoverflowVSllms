public class DataPanels {
    Object data;
    DisplayPanel dPnl = new DisplayPanel(data);  // assuming a constructor that takes this parameter
    ControlPanel cPnl = new ControlPanel(data);  // assuming a constructor that takes this parameter

    public static void main(String[] args) {
    }
}

class DisplayPanel {
    public DisplayPanel(Object data) {
    }
}

class ControlPanel {
    public ControlPanel(Object data) {
    }
}