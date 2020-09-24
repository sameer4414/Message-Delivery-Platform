package uk.gov.hmrc.information.dao;

import uk.gov.hmrc.information.model.Information;

import java.util.List;

public interface InformationDao {

    List<Information> getInformation();

    Information saveInformation(Information information);
}