package uk.gov.hmrc.mdp.service;

import uk.gov.hmrc.mdp.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> getMessages();

    Message saveMessage(Message message);
}
