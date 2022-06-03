package com.ganghee.elogistics.domain.address;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@Embeddable
public class Address {

    private String city;

    private String detail_addr;

    @Builder
    public Address(String city, String detail_addr){
        this.city = city;
        this.detail_addr = detail_addr;
    }
}
