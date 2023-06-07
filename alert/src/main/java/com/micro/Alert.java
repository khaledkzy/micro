package com.micro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Alert {
    @Id
    @SequenceGenerator(
            name = "alert_id_sequence",
            sequenceName = "alert_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "alert_id_sequence"
    )
    private Integer notificationId;
    private Integer toMemberId;
    private String toMemberEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}
