import org.jsmpp.bean.DeliverSM;
import org.jsmpp.bean.DeliverSMResp;
import org.jsmpp.bean.ESMClass;
import org.jsmpp.bean.NumberingPlanIndicator;
import org.jsmpp.bean.RegisteredDelivery;
import org.jsmpp.bean.SMSCDeliveryReceipt;
import org.jsmpp.bean.TypeOfNumber;
import org.jsmpp.session.Session;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsSender {
    private Session session; // Connect to your SMSC here

    private SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyyMMddHHmmss");

    public void sendSms(String from, String destinationAddress, String message) throws Exception {
        DeliverSM deliverSM = new DeliverSM();

        deliverSM.setServiceType("CMT");
        deliverSM.setSourceAddrTon(TypeOfNumber.UNKNOWN.value());
        deliverSM.setSourceAddrNpi(NumberingPlanIndicator.UNKNOWN.value());
        deliverSM.setSourceAddr(from);
        deliverSM.setDestAddress(destinationAddress);
        deliverSM.setEsmClass(new ESMClass());
        deliverSM.setProtocolId((byte) 0);
        deliverSM.setPriorityFlag((byte) 1);
        deliverSM.setScheduleDeliveryTime(timeFormatter.format(new Date()));
        deliverSM.setRegisteredDelivery(new RegisteredDelivery(SMSCDeliveryReceipt.DEFAULT));
        deliverSM.setShortMessage(message.getBytes("ISO_8859_1"));

        DeliverSMResp deliveryMessageResponse = session.sendRequestPdu(deliverSM);
        System.out.println(deliveryMessageResponse);
    }
}