package uk.gov.hmrc.information.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uk.gov.hmrc.information.model.Information;
import uk.gov.hmrc.information.repository.InformationRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InformationDaoImpl implements InformationDao{

    @Autowired
    private InformationRepository informationRepository;

    @Override
    public List<Information> getInformation(){
        List<Information> informationList = new ArrayList<>();
        informationRepository.findAll().iterator().forEachRemaining(informationList::add);
        return informationList;
    }

    @Override
    public Information saveInformation(Information information){
        return informationRepository.save(information);
    }
}
