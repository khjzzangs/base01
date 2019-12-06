package emartscan.emart.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emartscan.emart.com.model.Device;
import emartscan.emart.com.repositories.DeviceRepository;
import emartscan.emart.com.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	DeviceRepository repo;
	
	@Override
	public List<Device> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
