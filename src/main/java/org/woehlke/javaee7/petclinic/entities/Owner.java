package org.woehlke.javaee7.petclinic.entities;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Digits;

import java.util.*;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 01.01.14
 * Time: 21:08
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "owners")
@Indexed
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    @NotEmpty
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String lastName;

//INICIO DA MODIFICAÇÃO - 04/11    
    @Column(name = "zipcode")
    @NotEmpty
    private String zipcode;
    
    @Column(name = "address")
    @NotEmpty
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String address;
    
    @Column(name = "number")
    private String number;
    
    @Column(name = "district")
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String district;
    
    @Column(name = "city")
    @NotEmpty
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String city;
    
    @Column(name = "state")
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String state;
// MODIFICADO ATÉ AQUI!!!
    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 11)
    private String telephone;
    
    @Column(name = "validated_phone")
    @NotEmpty
    private String validatedPhone;

    @IndexedEmbedded
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner",fetch = FetchType.EAGER)
    private Set<Pet> pets = new TreeSet<Pet>();

    public void addPet(Pet pet){
        pets.add(pet);
        pet.setOwner(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String getValidatedPhone() {
        return validatedPhone;
    }

    public void setValidatedPhone(String validatedPhone) {
        this.validatedPhone = validatedPhone;
    }

    public List<Pet> getPets() {
        List<Pet> list = new ArrayList<>();
        for(Pet pet:pets){
            list.add(pet);
        }
        Collections.sort(list);
        return list;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;

        Owner owner = (Owner) o;

        if (address != null ? !address.equals(owner.address) : owner.address != null) return false;
        if (city != null ? !city.equals(owner.city) : owner.city != null) return false;
        if (firstName != null ? !firstName.equals(owner.firstName) : owner.firstName != null) return false;
        if (id != null ? !id.equals(owner.id) : owner.id != null) return false;
        if (lastName != null ? !lastName.equals(owner.lastName) : owner.lastName != null) return false;
        if (pets != null ? !pets.equals(owner.pets) : owner.pets != null) return false;
        if (telephone != null ? !telephone.equals(owner.telephone) : owner.telephone != null) return false;
        if (validatedPhone != null ? !validatedPhone.equals(owner.validatedPhone) : owner.validatedPhone != null) return false;
//        if (validatedPhone != owner.validatedPhone) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (pets != null ? pets.hashCode() : 0);
        result = 31 * result + (validatedPhone != null ? validatedPhone.hashCode() : 0);
//         result = 31 * result + String.valueOf(validatedPhone).hashCode();
       
        return result;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", validatedPhone='" + validatedPhone + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pets=" + pets +
                '}';
    }
}
