package ru.alimov.chat.controller;


import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.alimov.chat.dto.ChatMessageDto;
import ru.alimov.chat.dto.ChatUserDto;
import ru.alimov.chat.model.ChatMessage;
import ru.alimov.chat.model.ChatUser;
import ru.alimov.chat.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class ChatController {
    @Autowired 
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private ChatService chatService;
    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessageDto chatMessage) {
        System.out.println("got here inside cotroller method processMessage");
        System.out.println(chatMessage);
        chatService.sendMessage(chatMessage);
        messagingTemplate.convertAndSendToUser(
                chatMessage.getReceiver().toString(),"/queue/messages/"+chatMessage.getSender(),
                chatMessage);
    }

    @GetMapping("/history/{sender}/{receiver}")
    public List<ChatMessageDto> getHistory(@PathVariable("sender") Long sender,@PathVariable("receiver") Long receiver){
        return chatService.getHistory(sender,receiver);
    }

    @GetMapping("/friends/{id}")
    public List<ChatUser> getFriends(@PathVariable("id") Long id){
        return chatService.getOtherUsers(id);
    }
    @GetMapping("/user/get/{id}")
    public ChatUser getUser(@PathVariable("id") Long id){
        return chatService.getUser(id);
    }

    @PostMapping("/user/register")
    public ChatUser postMethodName(@RequestBody ChatUserDto user) {
        System.out.println("the user");
        System.out.println(user);
        //TODO: process POST request
        return chatService.createUser(user);
    }
    
}