package org.woehlke.javaee7.petclinic.web;



import org.richfaces.component.SortOrder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by tw on 13.03.14.
 */
@ManagedBean
@SessionScoped
public class OwnerSortingBean implements Serializable {

    private SortOrder sortOrderName = SortOrder.unsorted;
    private SortOrder sortOrderAddress = SortOrder.unsorted;
    private SortOrder sortOrderCity = SortOrder.unsorted;
    private SortOrder sortOrderTelephone = SortOrder.unsorted;
    private SortOrder sortOrderValidatedPhone = SortOrder.unsorted;
    private SortOrder sortOrderZipcode= SortOrder.unsorted;
    private SortOrder sortOrderNumber = SortOrder.unsorted;
    private SortOrder sortOrderDistrict = SortOrder.unsorted;
    private SortOrder sortOrderState = SortOrder.unsorted;
    
    public void setSortOrderToName(){
        sortOrderAddress = SortOrder.unsorted;
        sortOrderCity = SortOrder.unsorted;
        sortOrderTelephone = SortOrder.unsorted;
        sortOrderValidatedPhone = SortOrder.unsorted;
        sortOrderZipcode = SortOrder.unsorted;
        sortOrderNumber = SortOrder.unsorted;
        sortOrderDistrict = SortOrder.unsorted;
        sortOrderState = SortOrder.unsorted;
        if(sortOrderName==SortOrder.ascending){
            sortOrderName = SortOrder.descending;
        } else {
            sortOrderName = SortOrder.ascending;
        }
    }

    public void setSortOrderToAddress(){
        sortOrderName = SortOrder.unsorted;
        sortOrderCity = SortOrder.unsorted;
        sortOrderTelephone = SortOrder.unsorted;
        sortOrderValidatedPhone = SortOrder.unsorted;
        sortOrderZipcode = SortOrder.unsorted;
        sortOrderNumber = SortOrder.unsorted;
        sortOrderDistrict = SortOrder.unsorted;
        sortOrderState = SortOrder.unsorted;
        if(sortOrderAddress == SortOrder.ascending){
            sortOrderAddress = SortOrder.descending;
        } else {
            sortOrderAddress = SortOrder.ascending;
        }
    }

    public void setSortOrderToCity(){
        sortOrderName = SortOrder.unsorted;
        sortOrderAddress = SortOrder.unsorted;
        sortOrderTelephone = SortOrder.unsorted;
        sortOrderValidatedPhone = SortOrder.unsorted;
        sortOrderZipcode = SortOrder.unsorted;
        sortOrderNumber = SortOrder.unsorted;
        sortOrderDistrict = SortOrder.unsorted;
        sortOrderState = SortOrder.unsorted;
        if(sortOrderCity == SortOrder.ascending){
            sortOrderCity = SortOrder.descending;
        } else {
            sortOrderCity = SortOrder.ascending;
        }
    }

    public void setSortOrderToTelephone(){
        sortOrderName = SortOrder.unsorted;
        sortOrderAddress = SortOrder.unsorted;
        sortOrderCity = SortOrder.unsorted;
        sortOrderZipcode = SortOrder.unsorted;
        sortOrderValidatedPhone = SortOrder.unsorted;
        sortOrderNumber= SortOrder.unsorted;
        sortOrderDistrict = SortOrder.unsorted;
        sortOrderState = SortOrder.unsorted;
        if(sortOrderTelephone == SortOrder.ascending){
            sortOrderTelephone = SortOrder.descending;
        } else {
            sortOrderTelephone = SortOrder.ascending;
        }
    }
    
    public void setSortOrderToValidatedPhone(){
        sortOrderName = SortOrder.unsorted;
        sortOrderAddress = SortOrder.unsorted;
        sortOrderCity = SortOrder.unsorted;
        sortOrderZipcode = SortOrder.unsorted;
        sortOrderTelephone = SortOrder.unsorted;
        sortOrderNumber = SortOrder.unsorted;
        sortOrderDistrict = SortOrder.unsorted;
        sortOrderState = SortOrder.unsorted;
        if(sortOrderValidatedPhone == SortOrder.ascending){
            sortOrderValidatedPhone = SortOrder.descending;
        } else {
            sortOrderValidatedPhone = SortOrder.ascending;
        }
    }
    
    public void setSortOrderToZipcode(){
        sortOrderName = SortOrder.unsorted;
        sortOrderAddress = SortOrder.unsorted;
        sortOrderCity = SortOrder.unsorted;
        sortOrderTelephone = SortOrder.unsorted;
        sortOrderValidatedPhone = SortOrder.unsorted;
        sortOrderNumber = SortOrder.unsorted;
        sortOrderDistrict = SortOrder.unsorted;
        sortOrderState = SortOrder.unsorted;
        if(sortOrderZipcode == SortOrder.ascending){
            sortOrderZipcode = SortOrder.descending;
        } else {
            sortOrderZipcode = SortOrder.ascending;
        }
    }
    
    public void setSortOrderToNumber(){
        sortOrderName = SortOrder.unsorted;
        sortOrderAddress = SortOrder.unsorted;
        sortOrderCity = SortOrder.unsorted;
        sortOrderTelephone = SortOrder.unsorted;
        sortOrderValidatedPhone = SortOrder.unsorted;
        sortOrderZipcode = SortOrder.unsorted;
        sortOrderDistrict= SortOrder.unsorted;
        sortOrderState= SortOrder.unsorted;
        if(sortOrderNumber == SortOrder.ascending){
            sortOrderNumber = SortOrder.descending;
        } else {
            sortOrderNumber = SortOrder.ascending;
        }
    }
    
    public void setSortOrderToDistrict(){
        sortOrderName = SortOrder.unsorted;
        sortOrderAddress = SortOrder.unsorted;
        sortOrderCity = SortOrder.unsorted;
        sortOrderTelephone = SortOrder.unsorted;
        sortOrderValidatedPhone = SortOrder.unsorted;
        sortOrderZipcode = SortOrder.unsorted;
        sortOrderNumber = SortOrder.unsorted;
        sortOrderState = SortOrder.unsorted;
        if(sortOrderDistrict == SortOrder.ascending){
            sortOrderDistrict = SortOrder.descending;
        } else {
            sortOrderDistrict = SortOrder.ascending;
        }
    }

    public void setSortOrderToState(){
        sortOrderName = SortOrder.unsorted;
        sortOrderAddress = SortOrder.unsorted;
        sortOrderCity = SortOrder.unsorted;
        sortOrderTelephone = SortOrder.unsorted;
        sortOrderValidatedPhone = SortOrder.unsorted;
        sortOrderZipcode = SortOrder.unsorted;
        sortOrderNumber = SortOrder.unsorted;
        sortOrderDistrict = SortOrder.unsorted;
        if(sortOrderState == SortOrder.ascending){
            sortOrderState = SortOrder.descending;
        } else {
            sortOrderState = SortOrder.ascending;
        }
    }
    
    public SortOrder getSortOrderName() {
        return sortOrderName;
    }

    public void setSortOrderName(SortOrder sortOrderName) {
        this.sortOrderName = sortOrderName;
    }

    public SortOrder getSortOrderAddress() {
        return sortOrderAddress;
    }

    public void setSortOrderAddress(SortOrder sortOrderAddress) {
        this.sortOrderAddress = sortOrderAddress;
    }

    public SortOrder getSortOrderCity() {
        return sortOrderCity;
    }

    public void setSortOrderCity(SortOrder sortOrderCity) {
        this.sortOrderCity = sortOrderCity;
    }

    public SortOrder getSortOrderTelephone() {
        return sortOrderTelephone;
    }

    public void setSortOrderTelephone(SortOrder sortOrderTelephone) {
        this.sortOrderTelephone = sortOrderTelephone;
    }
    
    public SortOrder getSortOrderValidatedPhone() {
        return sortOrderTelephone;
    }

    public void setSortOrderValidatedPhone(SortOrder sortOrderValidatedPhone) {
        this.sortOrderValidatedPhone = sortOrderValidatedPhone;
    }

    public SortOrder getSortOrderZipcode() {
        return sortOrderZipcode;
    }

    public void setSortOrderZipcode(SortOrder sortOrderZipcode) {
        this.sortOrderZipcode = sortOrderZipcode;
    }

    public SortOrder getSortOrderNumber() {
        return sortOrderNumber;
    }

    public void setSortOrderNumber(SortOrder sortOrderNumber) {
        this.sortOrderNumber = sortOrderNumber;
    }

    public SortOrder getSortOrderDistrict() {
        return sortOrderDistrict;
    }

    public void setSortOrderDistrict(SortOrder sortOrderDistrict) {
        this.sortOrderDistrict = sortOrderDistrict;
    }

    public SortOrder getSortOrderState() {
        return sortOrderState;
    }

    public void setSortOrderState(SortOrder sortOrderState) {
        this.sortOrderState = sortOrderState;
    }
}
