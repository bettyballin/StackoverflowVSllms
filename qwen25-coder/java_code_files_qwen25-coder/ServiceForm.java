import java.util.List;
import java.util.ArrayList;

abstract class AbstractForm {
    // Placeholder for AbstractForm class
}

class SrvDO {
    // Placeholder for SrvDO class
}

public class ServiceForm extends AbstractForm {
    private List<SrvDO> allSrv = new ArrayList<>();

    public List<SrvDO> getAllSrv() {
        return allSrv;
    }

    public void setAllSrv(List<SrvDO> allSrv) {
        this.allSrv = allSrv;
    }

    // Indexed property getters and setters
    public SrvDO getAllSrv(int index) {
        return allSrv.get(index);
    }

    public void setAllSrv(int index, SrvDO srvDO) {
        allSrv.set(index, srvDO);
    }

    public static void main(String[] args) {
    }
}