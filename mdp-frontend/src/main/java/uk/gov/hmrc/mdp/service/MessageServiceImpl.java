package uk.gov.hmrc.mdp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.hmrc.mdp.dao.MessageDao;
import uk.gov.hmrc.mdp.model.Message;

import java.util.List;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageDao messageDao;

    @Override
    public List<Message> getMessages(){
        //TODO Call informationServiceUrl
        return messageDao.getMessages();
    }

    @Override
    public Message saveMessage(Message message){
        //TODO use camel based route here to transform the json message to xml
        return messageDao.saveMessage(message);
    }
}