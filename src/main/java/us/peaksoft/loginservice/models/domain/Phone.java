package us.peaksoft.loginservice.models.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Entity
@Data
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long id;

    private String phone;
}
