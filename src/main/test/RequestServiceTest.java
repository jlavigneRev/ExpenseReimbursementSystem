import com.revature.Request;
import com.revature.RequestService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RequestServiceTest {
    @Test
    public void getAllRequestsTest(){
        RequestService requestService = new RequestService();
        List<Request> requests = requestService.getAllRequest();
        assertEquals(true, requests.size() > 0);
        assertEquals(12.34, requests.get(0).getAmount());
    }
}
