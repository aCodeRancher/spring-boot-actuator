package guru.springframework;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringCoreDevOpsApplicationTests {

	@Autowired
	MockMvc mockMvc;
    @Autowired
	ObjectMapper objectMapper;

	@Test
	public void chuckNorrisTest() throws Exception {
		MvcResult mvcResult =  mockMvc.perform(get("/actuator/info"))
				 .andReturn();
		String infoOutput = mvcResult.getResponse().getContentAsString();
		JsonNode jsonNode = objectMapper.readTree(infoOutput);
		String chuckNorris = jsonNode.get("Chuck Norris").asText();
		assertTrue(chuckNorris.length()>0);
	}

}
