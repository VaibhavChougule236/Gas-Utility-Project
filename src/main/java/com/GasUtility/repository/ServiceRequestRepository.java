package com.GasUtility.repository;

import com.GasUtility.entity.ServiceRequest;
import com.GasUtility.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
	List<ServiceRequest> findByUserId(Long userId);
}
