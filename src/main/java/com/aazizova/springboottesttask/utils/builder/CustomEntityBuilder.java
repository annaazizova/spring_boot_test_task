package com.aazizova.springboottesttask.utils.builder;

import com.aazizova.springboottesttask.model.entity.Product;
import com.google.code.siren4j.component.Action;
import com.google.code.siren4j.component.builder.EntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.google.code.siren4j.component.Entity;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.code.siren4j.component.builder.EntityBuilder.createEntityBuilder;

@Component
public class CustomEntityBuilder {

    @Autowired
    CustomLinkBuilder customLinkBuilder;

    @Autowired
    CustomActionBuilder customActionBuilder;

    public Entity buildErrorEntity(HttpStatus httpStatus, String message) {
        return createEntityBuilder()
                .setComponentClass("error")
                .addProperty("status", httpStatus)
                .addProperty("code", httpStatus.value())
                .addProperty("message", message)
                .build();
    }

    public Entity buildProductEntity(Product product, HttpServletRequest request) {
        return EntityBuilder.newInstance().setRelationship("product")
                .addProperty(Product.FIELD_ID, product.getId())
                .addProperty(Product.FIELD_NAME, product.getName())
                .addProperty(Product.FIELD_BRAND, product.getBrand())
                .addProperty(Product.FIELD_PRICE, product.getPrice())
                .addProperty(Product.FIELD_QUANTITY, product.getQuantity())
                .addLink(customLinkBuilder.createProductLink(product, request))
                .build();
    }

    public Entity buildProductsEntity(List<Product> products, HttpServletRequest request, String type) {
        final List<Entity> productsEntities = products.stream().map(product -> buildProductEntity(product, request)).collect(Collectors.toList());
        return EntityBuilder.newInstance()
                .setComponentClass(type)
                .addSubEntities(productsEntities)
                .addActions(customActionBuilder.buildActions())
                .build();
    }
}
