import com.revature.Receipt;
import com.revature.ReceiptService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReceiptServiceTest {
    @Test
    public void getReceiptByReqId(){
        ReceiptService receiptService = new ReceiptService();
        Receipt receipt = receiptService.getReceiptByReqId(6);
        assertEquals(7,receipt.getReceiptId());
    }
}
