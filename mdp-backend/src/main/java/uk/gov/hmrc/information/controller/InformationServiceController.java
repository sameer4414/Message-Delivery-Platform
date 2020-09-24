package uk.gov.hmrc.information.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import uk.gov.hmrc.information.model.Information;
import uk.gov.hmrc.information.service.InformationServiceImpl;
import uk.gov.hmrc.information.validator.InformationJsonValidator;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InformationServiceController {

    @Autowired
    private InformationJsonValidator informationJsonValidator;

    @Autowired
    private InformationServiceImpl informationService;

    @GetMapping(value = "/information", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Information> getInformation(){
        return informationService.getInformation();
    }

    @PostMapping(value = "/information", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Information saveInformation(@Valid @RequestBody Information information){
        return informationService.saveInformation(information);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(informationJsonValidator);
    }

}