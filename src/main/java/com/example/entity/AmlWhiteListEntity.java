package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "AML_WHITE_LIST")
public class AmlWhiteListEntity {
    @NotNull
    @Column(name = "ID", nullable = false)
    @Id
    private Long id;

    @Size(max = 16)
    @Column(name = "CUSTOMER_ID", length = 16)
    private String customerId;

    @Size(max = 16)
    @Column(name = "BANNED_USER_ID", length = 16)
    private String bannedUserId;

}