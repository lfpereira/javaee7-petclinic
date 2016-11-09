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
    private SortOrder sortOrderCep = SortOrder.unsorted;
    private SortOrder sortOrderLogradouro = SortOrder.unsorted;
    private SortOrder sortOrderComplemento = SortOrder.unsorted;
    private SortOrder sortOrderBairro = SortOrder.unsorted;
    private SortOrder sortOrderLocalidade = SortOrder.unsorted;
    private SortOrder sortOrderUF = SortOrder.unsorted;
    
    public void setSortOrderToName(){
        sortOrderAddress = SortOrder.unsorted;
        sortOrderCity = SortOrder.unsorted;
        sortOrderTelephone = SortOrder.unsorted;
        sortOrderCep = SortOrder.unsorted;
        sortOrderLogradouro = SortOrder.unsorted;
        sortOrderComplemento = SortOrder.unsorted;
        sortOrderBairro = SortOrder.unsorted;
        sortOrderLocalidade = SortOrder.unsorted;
        sortOrderUF = SortOrder.unsorted;
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
        sortOrderCep = SortOrder.unsorted;
        sortOrderLogradouro = SortOrder.unsorted;
        sortOrderComplemento = SortOrder.unsorted;
        sortOrderBairro = SortOrder.unsorted;
        sortOrderLocalidade = SortOrder.unsorted;
        sortOrderUF = SortOrder.unsorted;
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
        sortOrderCep = SortOrder.unsorted;
        sortOrderLogradouro = SortOrder.unsorted;
        sortOrderComplemento = SortOrder.unsorted;
        sortOrderBairro = SortOrder.unsorted;
        sortOrderLocalidade = SortOrder.unsorted;
        sortOrderUF = SortOrder.unsorted;
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
        sortOrderCep = SortOrder.unsorted;
        sortOrderLogradouro = SortOrder.unsorted;
        sortOrderComplemento = SortOrder.unsorted;
        sortOrderBairro = SortOrder.unsorted;
        sortOrderLocalidade = SortOrder.unsorted;
        sortOrderUF = SortOrder.unsorted;
        if(sortOrderTelephone == SortOrder.ascending){
            sortOrderTelephone = SortOrder.descending;
        } else {
            sortOrderTelephone = SortOrder.ascending;
        }
    }
    
    public void setSortOrderToCep(){
        sortOrderName = SortOrder.unsorted;
        sortOrderAddress = SortOrder.unsorted;
        sortOrderCity = SortOrder.unsorted;
        sortOrderTelephone = SortOrder.unsorted;
        sortOrderLogradouro = SortOrder.unsorted;
        sortOrderComplemento = SortOrder.unsorted;
        sortOrderBairro = SortOrder.unsorted;
        sortOrderLocalidade = SortOrder.unsorted;
        sortOrderUF = SortOrder.unsorted;
        if(sortOrderCep == SortOrder.ascending){
            sortOrderCep = SortOrder.descending;
        } else {
            sortOrderCep = SortOrder.ascending;
        }
    }
    
    public void setSortOrderToLogradouro(){
        sortOrderName = SortOrder.unsorted;
        sortOrderAddress = SortOrder.unsorted;
        sortOrderCity = SortOrder.unsorted;
        sortOrderTelephone = SortOrder.unsorted;
        sortOrderCep = SortOrder.unsorted;
        sortOrderComplemento = SortOrder.unsorted;
        sortOrderBairro = SortOrder.unsorted;
        sortOrderLocalidade = SortOrder.unsorted;
        sortOrderUF = SortOrder.unsorted;
        if(sortOrderLogradouro == SortOrder.ascending){
            sortOrderLogradouro = SortOrder.descending;
        } else {
            sortOrderLogradouro = SortOrder.ascending;
        }
    }
    
    public void setSortOrderToComplemento(){
        sortOrderName = SortOrder.unsorted;
        sortOrderAddress = SortOrder.unsorted;
        sortOrderCity = SortOrder.unsorted;
        sortOrderTelephone = SortOrder.unsorted;
        sortOrderCep = SortOrder.unsorted;
        sortOrderLogradouro = SortOrder.unsorted;
        sortOrderBairro = SortOrder.unsorted;
        sortOrderLocalidade = SortOrder.unsorted;
        sortOrderUF = SortOrder.unsorted;
        if(sortOrderComplemento == SortOrder.ascending){
            sortOrderComplemento = SortOrder.descending;
        } else {
            sortOrderComplemento = SortOrder.ascending;
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

    public SortOrder getSortOrderCep() {
        return sortOrderCep;
    }

    public void setSortOrderCep(SortOrder sortOrderCep) {
        this.sortOrderCep = sortOrderCep;
    }

    public SortOrder getSortOrderLogradouro() {
        return sortOrderLogradouro;
    }

    public void setSortOrderLogradouro(SortOrder sortOrderLogradouro) {
        this.sortOrderLogradouro = sortOrderLogradouro;
    }

    public SortOrder getSortOrderComplemento() {
        return sortOrderComplemento;
    }

    public void setSortOrderComplemento(SortOrder sortOrderComplemento) {
        this.sortOrderComplemento = sortOrderComplemento;
    }

    public SortOrder getSortOrderBairro() {
        return sortOrderBairro;
    }

    public void setSortOrderBairro(SortOrder sortOrderBairro) {
        this.sortOrderBairro = sortOrderBairro;
    }

    public SortOrder getSortOrderLocalidade() {
        return sortOrderLocalidade;
    }

    public void setSortOrderLocalidade(SortOrder sortOrderLocalidade) {
        this.sortOrderLocalidade = sortOrderLocalidade;
    }

    public SortOrder getSortOrderUF() {
        return sortOrderUF;
    }

    public void setSortOrderUF(SortOrder sortOrderUF) {
        this.sortOrderUF = sortOrderUF;
    }
    
}
