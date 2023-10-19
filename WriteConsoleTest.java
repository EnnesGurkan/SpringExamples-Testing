import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class WriteConsoleTest {

   @Spy
   private PrintStream out = System.out;

   @InjectMocks
   private WriteConsole writeConsole;

   @Value("${greeting.salutation}")
   private String greetingSalutation;

   @Test
   public void testWriteConsole() {
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      System.setOut(new PrintStream(output));
      ReflectionTestUtils.setField(writeConsole, "greetingSalutation", greetingSalutation);
      writeConsole.writeConsole();

      // Verify that the captured output is equal to the greeting salutation
      assertEquals("Hello", output.toString().trim());

      // Verify that the greeting salutation is equal to the expected value
      assertEquals("Hello", greetingSalutation);
   }
}
