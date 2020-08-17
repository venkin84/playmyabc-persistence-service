package com.playmyabc.persistenceservice.domain.submodels;

import org.bson.types.Binary;

public class Content {
    String name;
    ContentWrapStyle wrapStyle;
    ContentVerticalAlignment alignment;
    Binary videoContent;
    Binary soundContent;
    Binary imageContent;
    String textContent;
    String urlContent;
}
