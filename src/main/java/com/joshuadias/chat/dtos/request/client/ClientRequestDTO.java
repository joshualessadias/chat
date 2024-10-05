package com.joshuadias.chat.dtos.request.client;

import com.joshuadias.chat.enums.PaymentPlanEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record ClientRequestDTO(

        @NotBlank(message = "Name is required")
        @Size(max = 50, message = "Name must have a maximum of 50 characters")
        String name,

        @NotBlank(message = "Email is required")
        @Size(max = 50, message = "Email must have a maximum of 50 characters")
        String email,

        @NotBlank(message = "Phone number is required")
        @Size(min = 11, max = 11, message = "Phone number must have 11 characters")
        String phoneNumber,

        @NotBlank(message = "CPF is required")
        @Size(min = 11, max = 11, message = "CPF must have 11 characters")
        String cpf,

        @NotBlank(message = "CNPJ is required")
        @Size(min = 14, max = 14, message = "CNPJ must have 14 characters")
        String cnpj,

        @NotBlank(message = "Firm name is required")
        @Size(max = 50, message = "Firm name must have a maximum of 50 characters")
        String firmName,

        @NotNull(message = "Payment plan is required")
        PaymentPlanEnum paymentPlan
) {
}