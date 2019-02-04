package org.springframework.samples.petclinic.anticurrouption;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VeterianMsConnector {

   @Autowired
   RestTemplate restTemplate;

   List<Vet> vetList;

   @Value(value = "${veterian_microservice.baseurl}")
   private String baseUri;


   public List<Vet> findAllVeterians(){

       String urlWithEndPoint = baseUri+"/veterian";
       UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlWithEndPoint);
       String vetResponseJson =  restTemplate.getForObject(builder.toUriString(), String.class);
       List <VetJson> vetJsonList = new ArrayList<>();


       try{
           ObjectMapper jsonMapper = new ObjectMapper();
           vetJsonList = jsonMapper.readValue(vetResponseJson, new TypeReference<List<VetJson>>(){});

       }catch(Exception e){
           e.printStackTrace();
       }


        List<Vet> vetList = new ArrayList<>();

       vetJsonList.stream().forEach(vetJson -> {

            Vet vet = new Vet();
            vet.setFirstName(vetJson.getFirstName());
            vet.setLastName(vetJson.getLastName());
            vet.setId(vetJson.getId());
            Set<Specialty> specialityList = new HashSet<>();
            vet.setSpecialtiesInternal(specialityList);

            vetJson.getSpecialties().forEach(specilityJson -> {

                Specialty speciality = new Specialty();
                speciality.setId(specilityJson.getId());
                speciality.setName(specilityJson.getName());
                specialityList.add(speciality);
            });

            vetList.add(vet);
        });


       return vetList;
   }

}
