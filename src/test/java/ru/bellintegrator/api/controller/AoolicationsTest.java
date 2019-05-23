package ru.bellintegrator.api.controller;

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

import ru.bellintegrator.api.Application;
import ru.bellintegrator.api.controller.office.OfficeController;
import ru.bellintegrator.api.daoOffice.OfficeDao;
import ru.bellintegrator.api.model.Office;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
@Transactional // After I added this LazyInitializationException disappeared
public class AoolicationsTest {

	  @MockBean
	  OfficeController officeController;
	  
	
	  @Autowired
	  private WebApplicationContext wac;
	  private MockMvc mockMvc;
	  private OfficeDao officeDao;
		
	  @Before
	  public void setup() {
	      DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
	      this.mockMvc = builder.build();
	  }
	
	@Test
	public void controller_test() throws Exception {
		   Office office = new Office();
		   
		    List<Office> offices = Arrays.asList(office);
		 
		    MockHttpServletRequestBuilder builder =
		              MockMvcRequestBuilders.get("/api/office/list").accept(MediaType.APPLICATION_JSON);
		    
		    MvcResult rt  = this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		    System.out.println(rt.getResponse().getContentAsString());
		    
		    
	}
	
}
