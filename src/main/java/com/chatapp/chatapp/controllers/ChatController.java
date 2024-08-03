package com.chatapp.chatapp.controllers;

import com.chatapp.chatapp.entities.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class ChatController {

    public class Response {
        private String message;
        public Response(String message)
        {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public Message hello(Message message) throws Exception {
        return message;
    }
}
