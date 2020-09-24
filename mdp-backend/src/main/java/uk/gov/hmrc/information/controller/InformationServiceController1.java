package uk.gov.hmrc.information.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import uk.gov.hmrc.information.model.Information;
import uk.gov.hmrc.information.validator.InformationValidator;
import uk.gov.hmrc.information.service.InformationServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InformationServiceController1 {

    @Autowired
    private InformationValidator informationValidator;

    @Autowired
    private InformationServiceImpl informationService;

    @GetMapping(value = "/information1", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Information> getInformation(){
        return informationService.getInformation();
    }

    @PostMapping(value = "/information1", consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Information saveInformation(@Valid @RequestBody Information information){
        System.out.println(">>>>>>>>> "+ information);
        return informationService.saveInformation(information);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(informationValidator);
    }

}