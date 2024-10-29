package com.whatsapp.api.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.*;
import com.whatsapp.api.domain.messages.Message.MessageBuilder;
import com.whatsapp.api.domain.messages.type.ButtonSubType;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;

public class SendCarouselTemplateMessageExample {
    public static void main(String[] args) throws JsonProcessingException {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(//
                        new TemplateMessage()//
                                .setLanguage(new Language(LanguageType.EN))//
                                .setName("carousel3_tour_1")//
                                .addComponent(new CarouselComponent()
                                        .addCard(new CarouselCard(0)
                                                .addComponent(
                                                        new HeaderComponent().addParameter(
                                                                new ImageParameter().setImage(new Image().setLink("https://ik.imgkit.net/3vlqs5axxjf/TW-Asia/ik-seo/uploadedImages/Industry/Destinations(1)/AdobeStock_302223688_Editorial_Use_Only/Hear-Singapore-roar-with-its-2023-tourism-performa.jpeg"))
                                                        ))
                                                .addComponent(
                                                        new BodyComponent().addParameter(new TextParameter("Tokyo"))
                                                )
                                                .addComponent(
                                                        new ButtonComponent().setIndex(0).setSubType(ButtonSubType.QUICK_REPLY).addParameter(new ButtonPayloadParameter("product_123"))
                                                )
                                                .addComponent(
                                                        new ButtonComponent().setIndex(1).setSubType(ButtonSubType.URL).addParameter(new TextParameter("url_123"))
                                                )
                                        )
                                        .addCard(new CarouselCard(1)
                                                .addComponent(
                                                        new HeaderComponent().addParameter(
                                                                new ImageParameter().setImage(new Image().setLink("https://ik.imgkit.net/3vlqs5axxjf/TW-Asia/ik-seo/uploadedImages/Industry/Destinations(1)/AdobeStock_302223688_Editorial_Use_Only/Hear-Singapore-roar-with-its-2023-tourism-performa.jpeg"))
                                                        ))
                                                .addComponent(
                                                        new BodyComponent().addParameter(new TextParameter("China"))
                                                )
                                                .addComponent(
                                                        new ButtonComponent().setIndex(0).setSubType(ButtonSubType.QUICK_REPLY).addParameter(new ButtonPayloadParameter("product_234"))
                                                )
                                                .addComponent(
                                                        new ButtonComponent().setIndex(1).setSubType(ButtonSubType.URL).addParameter(new TextParameter("url_234"))
                                                )
                                        )
                                        .addCard(new CarouselCard(2)
                                                .addComponent(
                                                        new HeaderComponent().addParameter(
                                                                new ImageParameter().setImage(new Image().setLink("https://ik.imgkit.net/3vlqs5axxjf/TW-Asia/ik-seo/uploadedImages/Industry/Destinations(1)/AdobeStock_302223688_Editorial_Use_Only/Hear-Singapore-roar-with-its-2023-tourism-performa.jpeg"))
                                                        ))
                                                .addComponent(
                                                        new BodyComponent().addParameter(new TextParameter("Australia"))
                                                )
                                                .addComponent(
                                                        new ButtonComponent().setIndex(0).setSubType(ButtonSubType.QUICK_REPLY).addParameter(new ButtonPayloadParameter("product_456"))
                                                )
                                                .addComponent(
                                                        new ButtonComponent().setIndex(1).setSubType(ButtonSubType.URL).addParameter(new TextParameter("url_456"))
                                                )
                                        )
                                )
                );
        System.out.println(new ObjectMapper().writeValueAsString(message));

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
    }
}
