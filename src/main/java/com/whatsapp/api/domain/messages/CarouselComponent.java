package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ComponentType;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Carousel component, to send template messages
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/guides/send-message-templates/media-card-carousel-templates">Api reference</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarouselComponent extends Component<CarouselComponent> {

    @JsonProperty("cards")
    public List<CarouselCard> cards;

    /**
     * Instantiates a new Carousel component, to send template messages
     */
    public CarouselComponent() {
        super(ComponentType.CAROUSEL);
    }

    public CarouselComponent setCards(List<CarouselCard> cards) {
        this.cards = cards;
        return this;
    }

    public CarouselComponent addCard(CarouselCard card) {
        if (this.cards == null) {
            this.cards = new ArrayList<>();
        }
        this.cards.add(card);
        return this;
    }

    public List<CarouselCard> getCards() {
        return cards;
    }
}
