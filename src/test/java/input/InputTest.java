package input;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class InputTest {

    @Rule
    public final TextFromStandardInputStream systemIn = emptyStandardInputStream();

    @Test
    public void readsInputFromKeyboard() throws Exception {
        systemIn.provideLines("*/15 0 1,15 * 1-5 /usr/bin/find");

        Input input = new Input();
        String lineContent = input.readLineFromConsole();

        assertThat(lineContent, is("*/15 0 1,15 * 1-5 /usr/bin/find"));
    }
}