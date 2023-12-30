package jpabook.jpashop.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MembersForm {

    @NotEmpty(message = "")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
