package uk.gov.hmrc.mdp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import uk.gov.hmrc.mdp.model.Message;
import uk.gov.hmrc.mdp.repository.MessageRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDao{

    private static final Logger logger = LoggerFactory.getLogger(MessageDaoImpl.class);

    @Value("${informationServiceUrl}")
    private String informationServiceUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private MessageRepository messageRepository;

    private static HttpHeaders headers = new HttpHeaders();

    @Override
    public List<Message> getMessages() {

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<String> result = restTemplate.exchange(informationServiceUrl, HttpMethod.GET, entity, String.class);
        logger.info(" response from backend-service "+ result.getBody());

        //TODO information to message will happen here using CAMEL

        List<Message> messageList = new ArrayList<>();
        messageRepository.findAll().iterator().forEachRemaining(messageList::add);
        return messageList;
    }

    @Override
    public Message saveMessage(Message message) {
        //TODO message to information will happen here using CAMEL

//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>("body", headers);
//
//        ResponseEntity<String> result = restTemplate.exchange(informationServiceUrl, HttpMethod.POST, entity, String.class);

/////////////////

        // The Message model here can be information
        // call the POST endpoint on backend service passing this transformed xml message
        // the messageRepository and h2 database dependency will be at the backend service level
        // name the backend service as information service
        return messageRepository.save(message);
    }
}