package com.playmyabc.persistenceservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document (collection = "database_sequences")
public class Sequencer {
    @Id
    private String id;

    private long seq;
}
