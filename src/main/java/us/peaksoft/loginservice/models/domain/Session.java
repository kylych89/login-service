package us.peaksoft.loginservice.models.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Data
@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long id;

    private String token;

    private Date startDate;

    private Date endDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
