package IMS.BarCode;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

@RestController
@RequestMapping("/barcode")
public class BarCodeController {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> generateCode128Barcode(@PathVariable("id") String id) throws Exception {
        String timestamp = dateFormat.format(new Date());
        String barcodeData = id + "-" + timestamp;
        
        Code128Writer barcodeWriter = new Code128Writer();
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeData, BarcodeFormat.CODE_128, 300, 100);
        
        return new ResponseEntity<>(MatrixToImageWriter.toBufferedImage(bitMatrix), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAssetAndGenerateBarcode() throws Exception {
        // Logic to create asset and generate ID
        String id = "asset_id"; // Some generated asset ID
        
        // Now call the barcode generation method
        String timestamp = dateFormat.format(new Date());
        generateCode128Barcode(id + "-" + timestamp);
        
        return new ResponseEntity<>("Asset created and barcode generated", HttpStatus.CREATED);
    }
}
