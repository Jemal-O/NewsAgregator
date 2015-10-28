import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NewsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int formatting = NewsSelector.PRETTY_PRINT_INDENT_FACTOR;
		Assert.assertTrue(formatting==1);
	}

}
