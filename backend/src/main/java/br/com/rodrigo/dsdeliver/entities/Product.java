package br.com.rodrigo.dsdeliver.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private static  final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identificador único do Produto", required = true)
    private Long id;
    @ApiModelProperty(notes = "Identificador do nome ao qual o Produto se refere", required = true)
    private String name;
    @ApiModelProperty(notes = "Identificador de preço ao qual o Produto se refere", required = true)
    private Double price;
    @ApiModelProperty(notes = "Identificador do descrição ao qual o Produto se refere", required = true)
    private String description;
    @ApiModelProperty(notes = "Identificador do imagem ao qual o Produto se refere", required = true)
    private String imageUri;

    public Product() {
    }

    public Product(Long id, String name, Double price, String description, String imageUri) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUri = imageUri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
