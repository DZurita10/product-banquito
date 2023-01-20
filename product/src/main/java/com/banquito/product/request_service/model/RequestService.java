package com.banquito.product.request_service.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "requestService")
public class RequestService {
    
    @Id
    private String id;

    @Indexed(unique = true)
    private String codeRequest;

    @Indexed(unique = true)
    private String accountNumber;

    private String fullName;
    private Boolean status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private String nameAssociatedService;

    @Version
    private Long version;
}
