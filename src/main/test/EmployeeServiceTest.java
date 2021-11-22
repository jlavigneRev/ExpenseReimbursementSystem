import com.revature.Employee;
import com.revature.EmployeeService;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EmployeeServiceTest {
    @Test
    public void addEmployeeTest(){
        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee();
        employee.setEmail("wp@gmail.com");
        employee.setFirstName("Will");
        employee.setLastName("Peters");
        employee.setPassword("wpdemo");
        employeeService.addEmployee(employee);
    }

    @Test
    public void getEmployeeByIdTest(){
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.getEmployeeById(1);
        assertEquals("gw@gmail.com", employee.getEmail());
        assertEquals("George", employee.getFirstName());
        assertEquals("Walter", employee.getLastName());
        assertEquals("root", employee.getPassword());
    }

    @Test
    public void validEmployeeCredential(){
        EmployeeService employeeService = new EmployeeService();
        boolean result = employeeService.validEmployeeCredentials("gw@gmail.com", "root");
        assertEquals(true, result);
        result = employeeService.validEmployeeCredentials("12345", "12345");
        assertEquals(false, result);
    }
}
