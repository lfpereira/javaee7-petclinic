package org.woehlke.javaee7.petclinic.web;

import java.io.IOException;
import java.io.InputStream;
import org.woehlke.javaee7.petclinic.dao.OwnerDao;
import org.woehlke.javaee7.petclinic.dao.PetDao;
import org.woehlke.javaee7.petclinic.dao.PetTypeDao;
import org.woehlke.javaee7.petclinic.dao.VisitDao;
import org.woehlke.javaee7.petclinic.entities.Owner;
import org.woehlke.javaee7.petclinic.entities.Pet;
import org.woehlke.javaee7.petclinic.entities.PetType;
import org.woehlke.javaee7.petclinic.entities.Visit;
import org.woehlke.javaee7.petclinic.services.OwnerService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 06.01.14
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class OwnerController implements Serializable {

    private static Logger log = Logger.getLogger(OwnerController.class.getName());

    @EJB
    private OwnerDao ownerDao;

    @EJB
    private PetDao petDao;

    @EJB
    private PetTypeDao petTypeDao;

    @EJB
    private VisitDao visitDao;

    @EJB
    private OwnerService ownerService;

    private String searchterm;

    private List<Owner> ownerList;

    private Owner owner;

    private Pet pet;

    private long petTypeId;

    private Visit visit;
    private int scrollerPage;
    
    private String codeSMS;
    
    private String insertCode;

    public String getInsertCode() {
        return insertCode;
    }

    public void setInsertCode(String insertCode) {
        this.insertCode = insertCode;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public long getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(long petTypeId) {
        this.petTypeId = petTypeId;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public String getSearchterm() {
        return searchterm;
    }

    public void setSearchterm(String searchterm) {
        this.searchterm = searchterm;
    }

    public String search(){
        if(searchterm==null || searchterm.isEmpty()){
            this.ownerList = ownerDao.getAll();
        } else {
            try {
                this.ownerList = ownerDao.search(searchterm);
            } catch (Exception e){
                this.ownerList = ownerDao.getAll();
            }
        }
        return "owners.jsf";
    }

    public String getNewOwnerForm(){
        this.owner = new Owner();
        
        this.owner.setFirstName("Luis Felipe");
        this.owner.setLastName("Pereira");
        this.owner.setAddress("Av Pernambuco");
        this.owner.setDistrict("Navegantes");
        this.owner.setCity("Porto Alegre");
        this.owner.setTelephone("5197188511");
        this.owner.setState("RS");        
        this.owner.setZipcode("90240000");
        this.owner.setAddress("Av");
        this.owner.setNumber("teste");
        
        //Não remover
        this.owner.setValidatedPhone("False");        
        return "newOwner.jsf";
    }

    public String saveNewOwner(){
        if (this.owner.getValidatedPhone() == null || !this.owner.getValidatedPhone().equals("True")) {
            this.owner.setValidatedPhone("False");
        }
        ownerDao.addNew(this.owner);
        this.ownerList = ownerDao.getAll();
        return "owners.jsf";
    }

    public String showOwner(long id){
        this.owner = ownerDao.findById(id);
        return "showOwner.jsf";
    }

    public String getEditForm(){
        return "editOwner.jsf";
    }

    public String saveEditedOwner(){
        ownerDao.update(this.owner);
        this.ownerList = ownerDao.getAll();
        return "showOwner.jsf";
    }

    public String delete(long id){
        ownerDao.delete(id);
        this.ownerList = ownerDao.getAll();
        return "owners.jsf";
    }

    public String getAddNewPetForm(){
        this.pet = new Pet();
        return "addNewPet.jsf";
    }

    public List<PetType> getAllPetTypes(){
        return petTypeDao.getAll();
    }

    public String addNewPet(){
        PetType petType = petTypeDao.findById(this.petTypeId);
        this.pet.setType(petType);
        this.owner.addPet(this.pet);
        petDao.addNew(this.pet);
        ownerDao.update(this.owner);
        return "showOwner.jsf";
    }

    public String editPetForm(long petId){
        this.pet = petDao.findById(petId);
        this.petTypeId = this.pet.getType().getId();
        return "editPet.jsf";
    }

    public String saveEditedPet(){
        PetType petType = petTypeDao.findById(this.petTypeId);
        this.pet.setType(petType);
        petDao.update(this.pet);
        long ownerId = this.owner.getId();
        this.owner = this.ownerDao.findById(ownerId);
        return "showOwner.jsf";
    }

    public String addVisitToPetForm(long petId){
        this.pet = petDao.findById(petId);
        this.petTypeId = this.pet.getType().getId();
        this.visit = new Visit();
        return "addVisitToPet.jsf";
    }

    public String saveVisit(){
        this.visit.setPet(this.pet);
        this.pet.addVisit(this.visit);
        ownerService.addNewVisit(this.visit);
        log.info("owner1: " + this.owner.toString());
        long ownerId = this.owner.getId();
        this.owner = this.ownerDao.findById(ownerId);
        log.info("owner2: "+this.owner.toString());
        return "showOwner.jsf";
    }

    public void setScrollerPage(int scrollerPage) {
        this.scrollerPage = scrollerPage;
    }

    public int getScrollerPage() {
        return scrollerPage;
    }
    
    public void buscarCEP() throws MalformedURLException, IOException{
        URL url = new URL("http://viacep.com.br/ws/" + owner.getZipcode() + "/json/");
        try (InputStream is = url.openStream();
        JsonParser parser = Json.createParser(is)) {
        while (parser.hasNext()) {
            Event e = parser.next();
            if (e == Event.KEY_NAME) {
                switch (parser.getString()) {
                    case "cep":
                        parser.next();
                        owner.setZipcode(parser.getString());
                        //System.out.print(": ");
                    break;
                    case "logradouro":
                        parser.next();
                        owner.setAddress(parser.getString());
                    break;
                    case "complemento":
                        parser.next();
                        owner.setNumber(parser.getString());
                    break;
                    case "bairro":
                        parser.next();
                        owner.setDistrict(parser.getString());
                    break;
                    case "localidade":
                        parser.next();
                        owner.setCity(parser.getString());
                    break;
                    case "uf":
                        parser.next();
                        owner.setState(parser.getString());
                    break;
                    }
                }
            }
        }
    }

    public void sendSMS() throws MalformedURLException, IOException, UnsupportedEncodingException {
        this.owner.setValidatedPhone("False");
        
        String phone = owner.getTelephone();
        Random r = new Random();
        int number = r.nextInt(100000);
        codeSMS = String.format("%05d", number);
        String Credential = URLEncoder.encode("C80B675E120C10BB03AAB71095D221C526127A8E", "UTF-8");
        String Token = URLEncoder.encode("b3fA08", "UTF-8");
        String Mobile = URLEncoder.encode("55" + phone, "UTF-8");
        String Msg = URLEncoder.encode("Seu código de validação é: " + codeSMS, "UTF-8");
        Msg = URLEncoder.encode(Msg, "UTF-8");
        String connection
                = "https://www.mpgateway.com/v_3_00/sms/smspush/enviasms.aspx?CREDENCIAL="
                + Credential + "&TOKEN=" + Token + "&PRINCIPAL_USER=NA&AUX_USER=NA&MOBILE=" + Mobile
                + "&SEND_PROJECT=N&MESSAGE=" + Msg;
        URL url = new URL(connection);
        InputStream input = url.openStream();
        
        setInsertCode("Sending SMS");
        
        byte[] b = new byte[4];
        input.read(b, 0, b.length);
        
        String RetornoMPG = new String(b);
        
        if (!this.owner.getValidatedPhone().equals("True")) {
            setInsertCode(RetornoMPG);
        }
        //Documentação
        //http://www.mobipronto.com/pt-br/SMS-MT-API/documentacao-sms-mt-api-http-get-v3-00
    }
    
    public void validatePhone() {
        if (codeSMS != null) {
            if (codeSMS.equals(insertCode)) {
                this.owner.setValidatedPhone("True");
            } else {
                this.owner.setValidatedPhone("Invalid code");
            }
        }
        else
        {
            setInsertCode("Send SMS code before");
        }
    }
}
