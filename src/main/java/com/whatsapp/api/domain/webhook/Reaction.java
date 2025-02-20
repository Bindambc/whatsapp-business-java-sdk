package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Reaction.
 *
 * @param emoji     The emoji used for the reaction.
 * @param messageId Specifies the wamid of the message received that contained
 *                  the reaction.
 * @param from      Specifies the id of the sender who reacted for the message.
 */
public record Reaction(

        @JsonProperty("emoji") String emoji,

                @JsonProperty("message_id") String messageId,

                @JsonProperty("from") String from

) {
}