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

    public RequestService(String id, String codeRequest, String accountNumber, String fullName, Boolean status,
            LocalDateTime startDate, LocalDateTime endDate, String nameAssociatedService) {
        this.id = id;
        this.codeRequest = codeRequest;
        this.accountNumber = accountNumber;
        this.fullName = fullName;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nameAssociatedService = nameAssociatedService;
    }

    @Version
    private Long version;
}
