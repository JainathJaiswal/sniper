package com.jai.world;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.jai.world.repository.jpadomain.Task;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SniperApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getAllTasks() throws Exception {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("/tasks/", String.class);
		int status = responseEntity.getStatusCodeValue();
		Assert.assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
	}

	@Test
	public void addTask() {
		Task task = new Task();
		task.setName("lallu");
		ResponseEntity<Task> responseEntity = restTemplate.postForEntity("/tasks", task, Task.class);
		int status = responseEntity.getStatusCodeValue();
		Task resultEmployee = responseEntity.getBody();
		Assert.assertEquals("Incorrect Response Status", HttpStatus.CREATED.value(), status);
		Assert.assertNotNull(resultEmployee);
		Assert.assertNotNull(resultEmployee.getId().longValue());
	}

	@Test
	public void updateTask() {
		Task task = new Task();
		task.setId(149l);
		task.setName("U r u ");
		HttpEntity<Task> requestEntity = new HttpEntity<Task>(task);
		ResponseEntity<Task> responseEntity = restTemplate.exchange("/tasks/" + "{id}", HttpMethod.PUT, requestEntity,
				Task.class, new Long(149));
		int status = responseEntity.getStatusCodeValue();
		Assert.assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
	}

	@Test
	public void deleteTask() {
		ResponseEntity<Void> responseEntity = restTemplate.exchange("/tasks/" + "{id}", HttpMethod.DELETE, null,
				Void.class, new Long(148));
		int status = responseEntity.getStatusCodeValue();
		Assert.assertEquals("Incorrect Response Status", HttpStatus.GONE.value(), status);
	}

	@Test
	public void getTaskById() {
		ResponseEntity<Task> responseEntity = restTemplate.getForEntity("/tasks/" + "{id}", Task.class, new Long(148));
		int status = responseEntity.getStatusCodeValue();
		Task task = responseEntity.getBody();
		Assert.assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
		Assert.assertNotNull(task);
		Assert.assertEquals(148l, task.getId().longValue());
	}
}
