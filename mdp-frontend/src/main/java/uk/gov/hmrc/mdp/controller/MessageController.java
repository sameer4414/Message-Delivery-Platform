package uk.gov.hmrc.mdp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import uk.gov.hmrc.mdp.model.Message;
import uk.gov.hmrc.mdp.service.MessageServiceImpl;
import uk.gov.hmrc.mdp.validator.MessageValidator;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageValidator messageValidator;

    @Autowired
    private MessageServiceImpl messageService;

    @GetMapping(value = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getMessage(){
        return messageService.getMessages();
    }

    @PostMapping(value = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Message postMessage(@Valid @RequestBody Message message){
        return messageService.saveMessage(message);
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(messageValidator);
//    }
}
