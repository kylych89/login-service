package us.peaksoft.loginservice.models.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private boolean active;


}
