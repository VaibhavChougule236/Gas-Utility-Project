package com.GasUtility.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_requests")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String type; // Gas Leak, New Connection, Bill Issue

    @Column(nullable = false, length = 500)
    private String details;

    @Column(nullable = false)
    private LocalDateTime submittedAt = LocalDateTime.now();

    @Column(nullable = false)
    private String status = "Pending"; // Pending, Resolved
}
