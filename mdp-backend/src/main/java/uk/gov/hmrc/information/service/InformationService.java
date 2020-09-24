package uk.gov.hmrc.information.service;

import uk.gov.hmrc.information.model.Information;

import java.util.List;

public interface InformationService {

    List<Information> getInformation();

    Information saveInformation(Information information);
}
