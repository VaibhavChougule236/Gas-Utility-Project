package com.GasUtility.service;

import com.GasUtility.entity.ServiceRequest;
import java.util.List;

public interface ServiceRequestService {
    List<ServiceRequest> getAllRequests();
    List<ServiceRequest> getRequestsByUserId(Long userId);
    void saveRequest(ServiceRequest request);
    void deleteRequest(Long id);
}
