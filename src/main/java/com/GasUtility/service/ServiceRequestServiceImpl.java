package com.GasUtility.service;

import com.GasUtility.entity.ServiceRequest;
import com.GasUtility.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Override
    public List<ServiceRequest> getAllRequests() {
        return serviceRequestRepository.findAll();
    }


    @Override
    public void saveRequest(ServiceRequest request) {
        serviceRequestRepository.save(request);
    }

    @Override
    public void deleteRequest(Long id) {
        serviceRequestRepository.deleteById(id);
    }

    @Override
    public List<ServiceRequest> getRequestsByUserId(Long userId) {
        return serviceRequestRepository.findByUserId(userId);
    }
}
