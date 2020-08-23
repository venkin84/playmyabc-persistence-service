package com.playmyabc.persistenceservice.domain.subdomain;

import lombok.*;
import org.bson.types.Binary;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Content {
    // Can be defaulted by the apps while user adds a content based on the context.
    // Can also be used as alternative text as well.
    String name;

    // Useful for displaying the content as needed by the user or application context
    ContentWrapStyle wrapStyle;
    ContentVerticalAlignment alignment;

    // The content itself can be one of the following types
    Binary videoContent;
    Binary soundContent;
    Binary imageContent;
    String textContent;
    String urlContent;
}
