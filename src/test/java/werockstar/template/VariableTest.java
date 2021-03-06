package werockstar.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class VariableTest {

    @Test
    public void variable_evaluate_to_it_value() throws Exception {
        Map<String, String> variables = new HashMap<>();

        String name = "my name";
        String value = "my value";

        variables.put(name, value);

        assertEquals(value, new Variable(name).evaluate(variables));
    }

    @Test(expected = MissingValueException.class)
    public void missing_variable_raises_exception() throws Exception {
        String name = "My name";
        new Variable(name).evaluate(new HashMap<>());
    }
}