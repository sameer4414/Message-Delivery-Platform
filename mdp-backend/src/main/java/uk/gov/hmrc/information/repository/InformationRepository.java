package uk.gov.hmrc.information.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import uk.gov.hmrc.information.model.Information;

@Repository
public interface InformationRepository extends PagingAndSortingRepository<Information, Long>  {
}