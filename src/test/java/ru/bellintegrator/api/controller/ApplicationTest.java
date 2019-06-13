package ru.bellintegrator.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.bellintegrator.api.Application;
import ru.bellintegrator.api.controller.office.OfficeController;
import ru.bellintegrator.api.daoOffice.OfficeDao;
import ru.bellintegrator.api.model.Office;
import ru.bellintegrator.api.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class })
@Transactional // After I added this LazyInitializationException disappeared
public class ApplicationTest {

	  @MockBean
	  OfficeController officeController;
	  
	
	  @Autowired
	  private WebApplicationContext wac;
	  
	  private MockMvc mockMvc;
		
	  @Before
	  public void setup() {
//	      DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
//	      this.mockMvc = builder.build();
		  mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	  }
	  
	  protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	   protected <T> T mapFromJson(String json, Class<T> clazz)
	      throws JsonParseException, JsonMappingException, IOException {
	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, clazz);
	   }
	
	@Test
	public void TestControllerGetUsers() throws Exception {
		
		String uri = "/api/user/list";
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
		//List<User> users = this.mapFromJson(content, List.class);
		//assertTrue(users.size()>0);
		//System.out.println(users);
		    
		    
	}
	
}
