package ru.alimov.chat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alimov.chat.dto.ChatMessageDto;
import ru.alimov.chat.dto.ChatUserDto;
import ru.alimov.chat.model.ChatMessage;
import ru.alimov.chat.model.ChatUser;
import ru.alimov.chat.repository.ChatMessageRepository;
import ru.alimov.chat.repository.ChatUserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatUserRepository chatUserRepository;
    private final ChatMessageRepository chatMessageRepository;

    private ChatUser findUserByNumber(ChatUser user){
        return chatUserRepository.getUserByNumber(user.getNumber());
    }

    private void saveMessage(ChatMessageDto message){
        chatMessageRepository.save(DtoToMessage(message));
    }
    public ChatUser createUser(ChatUserDto userDto){
        ChatUser user = dtoToUser(userDto);
        ChatUser foundUser = findUserByNumber(user);
        if(foundUser != null){
            System.out.println("this is the found user");
            System.out.println(foundUser);
            return foundUser;
        }
        else{
            return chatUserRepository.save(user);
        }
    }
    public ChatUser getUser(Long id){
        ChatUser user = chatUserRepository.getById(id);
        if(user != null || user.getId() != 0){
            return user;
        }
        return null;
    }

    public void sendMessage(ChatMessageDto messageDto){
        saveMessage(messageDto);
    }

    public List<ChatMessageDto> getHistory(Long sender,Long receiver){
        return chatMessageRepository.getBySenderAndReceiver(sender,receiver).stream().map(this::messageToDto).toList();
    }
    public List<ChatUser> getOtherUsers(Long id){
        return chatUserRepository.getOtherUsers(id);
    }


    private ChatMessage DtoToMessage(ChatMessageDto chatMessageDto){
        ChatUser sender = chatUserRepository.getById(chatMessageDto.getSender());
        ChatUser receiver = chatUserRepository.getById(chatMessageDto.getReceiver());
        return ChatMessage.builder()
                .sender(sender)
                .message(chatMessageDto.getMessage())
                .receiver(receiver)
                .build();
    }



    private ChatMessageDto messageToDto(ChatMessage message){
        return ChatMessageDto.builder()
                .message(message.getMessage())
                .receiver(message.getSender().getId())
                .sender(message.getSender().getId())
                .build();
    }

    private ChatUser dtoToUser(ChatUserDto user){
        return ChatUser.builder()
        .name(user.getName())
        .number(user.getNumber())
        .build();
    }
}
