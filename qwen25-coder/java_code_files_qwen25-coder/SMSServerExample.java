import java.lang.String;
import org.jsmpp.bean.AlertNotification;
import org.jsmpp.bean.BindParameter;
import org.jsmpp.bean.BindType;
import org.jsmpp.bean.DataSm;
import org.jsmpp.bean.DataSmResult;
import org.jsmpp.bean.DeliverSm;
import org.jsmpp.bean.NumberingPlanIndicator;
import org.jsmpp.bean.TypeOfNumber;
import org.jsmpp.extra.ProcessRequestException;
import org.jsmpp.extra.SessionState;
import org.jsmpp.session.SMPPSession;
import org.jsmpp.session.MessageReceiverListener;
import org.jsmpp.session.Session;
import org.jsmpp.session.SessionStateListener;
import org.jsmpp.util.AbsoluteTimeFormatter;
import org.jsmpp.util.DefaultAbsoluteTimeFormatter;

public class SMSServerExample {
    public static void main(String[] args) throws InterruptedException {
        String smppSrvHost = "your-sms-provider-host";
        int smppSrvPort = 2775; // default SMPP port
        String systemId = "system-id"; // provided by your service provider
        String password = "password"; // provided by your service provider

        SMPPSession session = new SMPPSession();
        try {
            AbsoluteTimeFormatter timeFormatter = new DefaultAbsoluteTimeFormatter();

            System.out.println("Connecting to " + smppSrvHost + ":" + smppSrvPort);

            session.connectAndBind(smppSrvHost, smppSrvPort, new BindParameter(
                BindType.BIND_RX, systemId, password, null, TypeOfNumber.UNKNOWN,
                NumberingPlanIndicator.UNKNOWN, null));

            System.out.println("Connected with session id " + session.getSessionId());

            SessionStateReceiver stateReceiver = new SessionStateReceiver(session);
            session.addSessionStateListener(stateReceiver);
            session.setMessageReceiverListener(new MessageReceiveListenerImpl());

            // Sleep to keep the main thread alive
            while (stateReceiver.isBound()) {
                Thread.sleep(1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.unbindAndClose();
        }
    }
}

class SessionStateReceiver implements SessionStateListener {
    private SessionState state = SessionState.CLOSED;
    private final SMPPSession session;

    public SessionStateReceiver(SMPPSession session) {
        this.session = session;
    }

    public boolean isBound() {
        return state.isBound();
    }

    @Override
    public void onStateChange(SessionState newState, SessionState oldState, Object source) {
        state = newState;
        System.out.println("Session state changed from " + oldState + " to " + newState);
    }
}

class MessageReceiveListenerImpl implements MessageReceiverListener {
    @Override
    public void onAcceptDeliverSm(DeliverSm deliverSm) throws ProcessRequestException {
        // Handle incoming deliver_sm
        System.out.println("Received deliver_sm: " + deliverSm);
    }

    @Override
    public void onAcceptAlertNotification(AlertNotification alertNotification) {
        // Handle incoming alert_notification
        System.out.println("Received alert_notification: " + alertNotification);
    }

    @Override
    public DataSmResult onAcceptDataSm(DataSm dataSm, Session source)
            throws ProcessRequestException {
        // Handle incoming data_sm
        System.out.println("Received data_sm: " + dataSm);
        return null;
    }
}