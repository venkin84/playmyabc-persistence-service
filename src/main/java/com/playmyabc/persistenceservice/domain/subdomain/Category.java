package com.playmyabc.persistenceservice.domain.subdomain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
    String name;
    List<Category> subCategories;
}
