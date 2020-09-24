package uk.gov.hmrc.mdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String informationSender;
    private String informationReceiver;
    private String informationText;
    private Boolean acknowledgementRequired;
}
