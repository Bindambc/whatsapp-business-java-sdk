package com.whatsapp.api.domain.messages;

import com.whatsapp.api.domain.messages.type.ButtonSubType;
import com.whatsapp.api.domain.templates.type.LanguageType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarouselCardTest {

    @Test
    public void testMessageBuilderWIthCarousel() {
        CarouselCard firstCard = composeCarouselCard(0, "image_media_123", "Tokyo", "product_1", "SKU_1.html");
        CarouselCard secondCard = composeCarouselCard(1, "image_media_456", "China", "product_2", "SKU_2.html");

        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.setName("carousel_card_2");
        templateMessage.setLanguage(new Language(LanguageType.EN));
        templateMessage.addComponent(new CarouselComponent().setCards(List.of(firstCard, secondCard)));

        Message message = Message.MessageBuilder.builder().buildTemplateMessage(templateMessage);

        assertEquals(1, message.getTemplateMessage().getComponents().size());
        assertInstanceOf(CarouselComponent.class, message.getTemplateMessage().getComponents().get(0));

        CarouselComponent carouselComponent = (CarouselComponent) message.getTemplateMessage().getComponents().get(0);
        assertEquals(2, carouselComponent.getCards().size());
        assertEquals(firstCard, carouselComponent.getCards().get(0));
        assertEquals(secondCard, carouselComponent.getCards().get(1));
    }

    private static CarouselCard composeCarouselCard(int cardIndex, String imageMediaId, String bodyParam, String productId, String productUrlPath) {
        CarouselCard card = new CarouselCard(cardIndex);

        HeaderComponent headerComponent = new HeaderComponent();
        headerComponent.addParameter(new ImageParameter().setImage(new Image().setId(imageMediaId)));
        card.addComponent(headerComponent);

        BodyComponent bodyComponent = new BodyComponent();
        bodyComponent.addParameter(new TextParameter(bodyParam));
        card.addComponent(bodyComponent);

        ButtonComponent replyBtnComponent = new ButtonComponent()
                .setIndex(0)
                .setSubType(ButtonSubType.QUICK_REPLY);
        replyBtnComponent.addParameter(new ButtonPayloadParameter(productId));
        card.addComponent(replyBtnComponent);

        ButtonComponent urlBtnComponent = new ButtonComponent()
                .setIndex(1)
                .setSubType(ButtonSubType.URL);
        replyBtnComponent.addParameter(new ButtonPayloadParameter(productUrlPath));
        card.addComponent(urlBtnComponent);

        return card;
    }
}
