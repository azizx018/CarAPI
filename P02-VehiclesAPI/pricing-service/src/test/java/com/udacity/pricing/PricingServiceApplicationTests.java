package com.udacity.pricing;

import com.udacity.pricing.domain.price.PriceRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingServiceApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private PriceRepository priceRepository;
	private TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getAllPrices() throws Exception {
		ResponseEntity<String> response = this.testRestTemplate.getForEntity("https://localhost:" + port + "/prices", String.class);
		assertThat(String.valueOf(response.getStatusCode()), equals(HttpStatus.OK));
	}


}
