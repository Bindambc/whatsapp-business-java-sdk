package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The carousel card
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarouselCard {

    @JsonProperty("card_index")
    private Integer cardIndex;

    @JsonProperty("components")
    private List<Component<?>> components;

    public CarouselCard(Integer cardIndex) {
        this.cardIndex = cardIndex;
    }

    public CarouselCard addComponent(Component<?> component) {
        if (this.components == null) {
            this.components = new ArrayList<>();
        }
        this.components.add(component);
        return this;
    }

    public CarouselCard setComponents(List<Component<?>> components) {
        this.components = components;
        return this;
    }

    public Integer getCardIndex() {
        return cardIndex;
    }

    public List<Component<?>> getComponents() {
        return components;
    }
}
