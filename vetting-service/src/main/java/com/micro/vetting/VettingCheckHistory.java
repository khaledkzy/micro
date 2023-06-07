package com.micro.vetting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VettingCheckHistory {
     @Id
    @SequenceGenerator(
            name = "vetting_id_sequence",
            sequenceName = "vetting_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vetting_id_sequence"
    )
    private Integer id;
    private Boolean isValid;
    private String memberId;
    private LocalDateTime createdAt;
}
