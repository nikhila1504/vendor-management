package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.entity.Vendor;
import com.cts.repository.VendorRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class VendorService {
	
	@Autowired
	VendorRepository repo;
	@Autowired
	RestTemplate template;


	
	public List<Vendor> getAll() {
		return (List<Vendor>) repo.findAll();
	}


	public void addVendor(Vendor vendor) {
		repo.save(vendor);
		
	}

	public void deleteVendorById(long vendorId) {
		repo.deleteById(vendorId);
		
	}

	public void updateVendor(Vendor vendor,long vendorId) {
		repo.save(vendor);
		
	}

	public Optional<Vendor> getVendorById(long vendorId) {
		return repo.findById(vendorId);
	}
	@HystrixCommand(fallbackMethod = "fallback")
	public String getProducts(Long vendorId) {
		String urlOfProducts = "http://localhost:8081/products/vendor/" + Long.toString(vendorId);
		return template.getForObject(urlOfProducts, String.class);

	}

	public String fallback(Long vendorId) {
		return "The server is down, please try after sometime.";
	}

}