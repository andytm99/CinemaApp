import org.junit.Test;

import static org.junit.Assert.*;

public class JsonCustomerTest {

    @Test
    public void getUsername() {
        JsonCustomer j = new JsonCustomer();
        j.setUsername("user");
        String username = "user";
        assertEquals(username,j.getUsername());
    }

    @Test
    public void setUsername() {
        JsonCustomer j = new JsonCustomer();
        String username = "user";
        j.setUsername(username);
        assertEquals(username,j.getUsername());
    }

    @Test
    public void getPassword() {
        JsonCustomer j = new JsonCustomer();
        j.setPassword("parola");
        String password = "parola";
        assertEquals(password,j.getPassword());
    }

    @Test
    public void setPassword() {
        JsonCustomer j = new JsonCustomer();
        String password = "parola";
        j.setPassword(password);
        assertEquals(password,j.getPassword());
    }
}