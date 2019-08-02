package demo.ans.webservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Test
	public void contextLoads() {
		
		String m = "message";
		
		assertThat(m).isEqualTo("message");

	}
	
}
