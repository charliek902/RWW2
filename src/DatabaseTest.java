import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void testCreateAccount() {
        Database db = new Database();
        assertTrue(db.createAccount("user1", "pass1"));
        for (int i = 2; i <= 10; i++) {
            assertTrue(db.createAccount("user" + i, "pass" + i));
        }
        assertFalse(db.createAccount("user11", "pass11"));
    }

    @Test
    void testLogin() {
        Database db = new Database();
        db.createAccount("user1", "pass1");
        db.createAccount("user2", "pass2");
        assertTrue(db.login("user1", "pass1"));
        assertTrue(db.login("user2", "pass2"));
        assertFalse(db.login("user3", "pass3"));
        assertFalse(db.login("user1", "wrongpass"));
    }

    @Test
    void testCaseInsensitivity() {
        Database db = new Database();
        db.createAccount("User1", "Pass1");
        assertTrue(db.login("user1", "Pass1"));
        assertFalse(db.login("user1", "pass1"));
    }

    @Test
    void testEmptyDatabaseLogin() {
        Database db = new Database();
        assertFalse(db.login("user1", "pass1"));
    }

    @Test
    void testOverwritingUsernames() {
        Database db = new Database();
        db.createAccount("user1", "pass1");
        assertTrue(db.login("user1", "pass1"));
        assertFalse(db.login("user1", "wrongpass"));
    }

    @Test
    void testInvalidUserName() {
        Database db = new Database();
        assertTrue(db.inValidUserName(""), "Empty username should be considered invalid.");
        assertFalse(db.inValidUserName("validUser"), "Non-empty username should be considered valid.");
    }

    @Test
    void testInvalidPassword() {
        Database db = new Database();
        assertTrue(db.inValidPassword(""), "Empty password should be considered invalid.");
        assertFalse(db.inValidPassword("validPassword"), "Non-empty password should be considered valid.");
    }

    @Test
    void testInvalidUserNameAndPasswordIntegration() {
        Database db = new Database();
        assertFalse(db.createAccount("", "validPassword"), "Account creation should fail with an empty username.");
        assertFalse(db.createAccount("validUser", ""), "Account creation should fail with an empty password.");
        assertTrue(db.createAccount("validUser", "validPassword"), "Account creation should succeed with valid username and password.");
    }
}
