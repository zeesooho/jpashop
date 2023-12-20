package jpabook.jpashop.domain;


import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    // 기본 생성자는 만들긴 해야함
    protected Address() {}

    // 생성시에만 set 할 수 있도록 하고 이후로 setter 접근 못하도록
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}

