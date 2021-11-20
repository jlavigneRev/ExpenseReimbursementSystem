import com.revature.Manager;
import com.revature.ManagerService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ManagerServiceTest {
    @Test
    public void addManagerTest(){
        ManagerService managerService = new ManagerService();
        Manager manager = new Manager();
        manager.setEmail("jl@gmail.com");
        manager.setPassword("password");
        manager.setFirstName("James");
        manager.setLastName("Lavigne");
        managerService.addManager(manager);
    }

    @Test
    public void getManagerByIdTest(){
        ManagerService managerService = new ManagerService();
        Manager manager = managerService.getManagerById(6);
        assertEquals("jl@gmail.com", manager.getEmail());
        assertEquals("password", manager.getPassword());
        assertEquals("James", manager.getFirstName());
        assertEquals("Lavigne", manager.getLastName());
    }

    @Test
    public void validManagerCredentialsTest(){
        ManagerService managerService = new ManagerService();
        boolean result = managerService.validManagerCredentials("jl@gmail.com", "password");
        assertEquals(true, result);
        result = managerService.validManagerCredentials("qwert@gmail.com", "secret");
        assertEquals(false, result);
    }
}
