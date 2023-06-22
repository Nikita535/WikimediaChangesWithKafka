package com.kafka;


import lombok.*;

import javax.persistence.*;

@Table(name ="event")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String WikimediaData;

}
