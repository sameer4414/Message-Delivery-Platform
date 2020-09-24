package uk.gov.hmrc.mdp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import uk.gov.hmrc.mdp.model.Message;

@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {
}