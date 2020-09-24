package uk.gov.hmrc.information.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.hmrc.information.dao.InformationDao;
import uk.gov.hmrc.information.model.Information;

import java.util.List;

@Service
@Slf4j
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationDao informationDao;

    @Override
    public List<Information> getInformation(){
        return informationDao.getInformation();
    }

    @Override
    public Information saveInformation(Information information){
        //TODO use camel based route here to transform the json message to xml
        return informationDao.saveInformation(information);
    }
}