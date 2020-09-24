package uk.gov.hmrc.information.endpoint;

import com.hmrc.springsoap.gen.GetInformationRequest;
import com.hmrc.springsoap.gen.GetInformationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import uk.gov.hmrc.information.repository.InformationRepository;

@Endpoint
public class InformationEndpoint {

    private static final String NAMESPACE_URI = "http://www.hmrc.com/springsoap/gen";

    @Autowired
    private final InformationRepository informationRepository;

    @Autowired
    public InformationEndpoint(InformationRepository countryRepository) {
        this.informationRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getInformationRequest")
    @ResponsePayload
    public GetInformationResponse getCountry(@RequestPayload GetInformationRequest request) {
        GetInformationResponse response = new GetInformationResponse();
//        response.setInformation(informationRepository.findInformation(request.getName()));

        return response;
    }
}
