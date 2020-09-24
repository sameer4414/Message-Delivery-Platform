package uk.gov.hmrc.mdp.dao;

import uk.gov.hmrc.mdp.model.Message;

import java.util.List;

public interface MessageDao {
    List<Message> getMessages();
    Message saveMessage(Message message);
}
