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
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
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
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
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
        this.owner.setBairro("Navegantes");
        this.owner.setCity("Porto Alegre");
        this.owner.setLocalidade("localidade");
        this.owner.setTelephone("5197188511");
        this.owner.setUf("RS");        
        this.owner.setCep("90240000");
        this.owner.setLogradouro("Av");
        this.owner.setComplemento("teste");
        
        this.owner.setValidatedPhone("False");
        
        return "newOwner.jsf";
    }

    public String saveNewOwner(){
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
    
    public void buscarCEP() throws MalformedURLException, IOException, NoSuchAlgorithmException, KeyManagementException{
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }

        } };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) { return true; }
        };
        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        URL urlDoWebService = new URL("http://viacep.com.br/ws/" + owner.getCep() + "/json/");
        InputStream streamParaLeitura = urlDoWebService.openStream();

        
        // Cria o nosso leitor
        // O Stream informado se refere a uma URL, mas poderíamos estar lendo de um arquivo, por ex.
        JsonReader leitorDeObjeto = Json.createReader(streamParaLeitura);

        //Faz a leitura e retorna o nosso objeto
        JsonObject ceps = leitorDeObjeto.readObject();

        //Construindo um Objeto da nossa aplicação com as informações de ISBN
        //Isbn isbn = new Isbn();

        //Ajusta os valores, lendo a informação do JSON.
        owner.setCep(ceps.getJsonObject("cep").getString("cep"));
        owner.setLogradouro(ceps.getJsonObject("logradouro").getString("logradouro"));
    }
    
    public void buscarCEP2() throws MalformedURLException, IOException{
        URL url = new URL("http://viacep.com.br/ws/" + owner.getCep() + "/json/");
        try (InputStream is = url.openStream();
        JsonParser parser = Json.createParser(is)) {
        while (parser.hasNext()) {
            Event e = parser.next();
            if (e == Event.KEY_NAME) {
                switch (parser.getString()) {
                    case "cep":
                        parser.next();
                        owner.setCep(parser.getString());
                        System.out.print(": ");
                    break;
                    case "logradouro":
                        parser.next();
                        owner.setLogradouro(parser.getString());
                    break;
                    }
                }
            }
        }
    }

    public void validatePhone() throws MalformedURLException, IOException, UnsupportedEncodingException {
        String phone = owner.getTelephone();
        Random r = new Random();
        int number = r.nextInt(100000);
        String code = String.format("%05d", number);
        String Credential = URLEncoder.encode("C80B675E120C10BB03AAB71095D221C526127A8E", "UTF-8");
        String Token = URLEncoder.encode("b3fA08", "UTF-8");
        String Mobile = URLEncoder.encode("55" + phone, "UTF-8");
        String Msg = URLEncoder.encode("Seu código de validação é: " + code, "UTF-8");
        Msg = URLEncoder.encode(Msg, "UTF-8");
        String connection
                = "https://www.mpgateway.com/v_3_00/sms/smspush/enviasms.aspx?CREDENCIAL="
                + Credential + "&TOKEN=" + Token + "&PRINCIPAL_USER=NA&AUX_USER=NA&MOBILE=" + Mobile
                + "&SEND_PROJECT=N&MESSAGE=" + Msg;
        URL url = new URL(connection);
        InputStream input = url.openStream();
        byte[] b = new byte[4];
        input.read(b, 0, b.length);
        String RetornoMPG = new String(b);
        //http://www.mobipronto.com/pt-br/SMS-MT-API/documentacao-sms-mt-api-http-get-v3-00

        int t = 0;
    }

}
