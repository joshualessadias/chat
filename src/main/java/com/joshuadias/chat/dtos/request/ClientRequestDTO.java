package com.joshuadias.chat.dtos.request;

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

        @NotNull(message = "Phone number is required")
        Integer phoneNumber,

        @NotNull(message = "CPF is required")
        Integer cpf,

        @NotNull(message = "CNPJ is required")
        Integer cnpj,

        @NotBlank(message = "Firm name is required")
        @Size(max = 50, message = "Firm name must have a maximum of 50 characters")
        String firmName,

        @NotNull(message = "Payment plan is required")
        PaymentPlanEnum paymentPlan
) {
}