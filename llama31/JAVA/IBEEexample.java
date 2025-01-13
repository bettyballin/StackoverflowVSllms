import java.lang.String;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.jpbc.PairingParameters;
import it.unisa.dia.gas.jpbc.PairingParametersGenerator;
import it.unisa.dia.gas.jpbc.PairingParametersGeneratorFactory;
import it.unisa.dia.gas.jpbc.PairingFactory;

public class IBEEexample {
    public static void main(String[] args) {
        // Generate pairing parameters
        PairingParametersGenerator pg = PairingParametersGeneratorFactory.getGenerator();
        PairingParameters params = pg.generateParameters();

        // Initialize pairing
        Pairing pairing = PairingFactory.getPairing(params);

        // Generate private key
        Element privateKey = pairing.getG1().newRandomElement();

        // Print private key
        System.out.println(privateKey);
    }
}