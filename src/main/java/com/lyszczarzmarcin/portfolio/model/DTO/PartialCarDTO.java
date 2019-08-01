package com.lyszczarzmarcin.portfolio.model.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class PartialCarDTO {

    @Pattern(regexp = "[0-9]+", message = "Wrong value")
    private String price;

    @Pattern(regexp = "[0-9]+", message = "Wrong value")
    private String distance;

    public PartialCarDTO(String price, String distance) {
        this.price = price;
        this.distance = distance;
    }
}
