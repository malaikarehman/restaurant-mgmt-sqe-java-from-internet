import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserInterfaceGUITest {

    private FrameFixture window;

    @BeforeEach
    public void setUp() {
        // Use GuiActionRunner to ensure that the GUI is constructed on the EDT (Event Dispatch Thread)
        UserInterface_GUI frame = GuiActionRunner.execute(() -> new UserInterface_GUI());
        // Initialize FrameFixture with the created frame
        window = new FrameFixture(frame);
        window.show(); // Ensures the GUI is visible for testing
    }

    @Test
    public void testLoginFunctionality() {
        // Simulate entering username and password
        window.textBox("usernameField").enterText("admin");
        window.textBox("passwordField").enterText("password123");

        // Simulate clicking the login button
        window.button("headBtnLogin").click();

        // Verify the login status (example: checking a label or state)
        window.label("statusLabel").requireText("Login successful");
    }

    @Test
    public void testShowMenuFunctionality() {
        // Simulate clicking the "Show Menu" button
        window.button("mainBtnShowMenu").click();

        // Verify that the menu is displayed
        window.panel("menuPanel").requireVisible();
    }

    @Test
    public void testLogoutFunctionality() {
        // Simulate logging in first
        testLoginFunctionality(); // Reusing the login test to simulate login

        // Simulate clicking the logout button
        window.button("headBtnLogout").click();

        // Verify the logout status
        window.label("statusLabel").requireText("Logged out");
    }

    @AfterEach
    public void tearDown() {
        window.cleanUp(); // Clean up resources after each test
    }
}
