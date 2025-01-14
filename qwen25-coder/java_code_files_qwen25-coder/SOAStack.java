import java.lang.String;
public class SOAStack {
    private boolean applicationServer;
    private boolean bam;
    private boolean processServer;
    private boolean esb;
    private boolean uddiRegistry;

    public SOAStack(boolean appServer, boolean bam, boolean procServer, boolean esb, boolean uddi) {
        this.applicationServer = appServer;
        this.bam = bam;
        this.processServer = procServer;
        this.esb = esb;
        this.uddiRegistry = uddi;
    }

    public boolean isFullStack() {
        return applicationServer && bam && processServer && esb && uddiRegistry;
    }

	public static void main(String[] args) {
	}
}