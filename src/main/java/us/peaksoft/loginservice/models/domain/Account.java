package us.peaksoft.loginservice.models.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String login;

    private String password;
}
