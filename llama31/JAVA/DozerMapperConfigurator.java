import java.util.List;
import org.dozer.DozerMapper;

public class DozerMapperConfigurator {
    public static void main(String[] args) {
        DozerMapperConfigurator configurator = new DozerMapperConfigurator();
        configurator.configureMapper();
    }

    public void configureMapper() {
        DozerMapper mapper = new DozerMapper();
        mapper.addMapping("hbm-mapping.xml");
        List<Pojo> pojos = mapper.map(hbmFiles);
    }
}