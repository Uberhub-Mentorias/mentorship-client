package com.iftm.mentorship_client.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoucherDTO {

    private String id;

    @NotBlank(message="Id não informado. Informe um id para o voucher")
    @NotNull(message="Id é obrigatório")
    private String voucherCode;
    
    private boolean valid;

    @Positive(message="Quantidade inválida. A quantidade deve ser um ou maior.")
    private Integer amount;

    private LocalDateTime expiresAt;
}