/*
 * Decompiled with CFR 0.152.
 */
public class TerminalConfigurator {
    int defaultColumns = 60;
    int defaultRows = 12;
    Terminal terminal = new Terminal(this.defaultColumns, this.defaultRows);

    public static void main(String[] stringArray) {
        TerminalConfigurator terminalConfigurator = new TerminalConfigurator();
        System.out.println("Terminal size: " + terminalConfigurator.terminal.columns + "x" + terminalConfigurator.terminal.rows);
    }
}
