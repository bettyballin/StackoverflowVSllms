import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class QRCodeDecoder {
    public static void main(String[] args) throws Exception {
        File file = new File("path_to_your_qrcode.png");
        BufferedImage image = ImageIO.read(file);
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        HashMap<DecodeHintType, Object> hintMap = new HashMap<>();
        hintMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);

        Result result = new MultiFormatReader().decode(bitmap, hintMap);
        System.out.println("Decoded text = " + result.getText());
    }
}