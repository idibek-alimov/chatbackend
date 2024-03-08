package ru.alimov.chat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {

    @Id
    @GeneratedValue(generator = "chat_massage_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "chat_massage_id_generator", sequenceName = "Chat_massage_id_generator", allocationSize = 1)
    private Long Id;
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChatUser receiver;
    @ManyToOne(fetch = FetchType.LAZY)
    private ChatUser sender;

    private LocalDateTime sentAt;

    @PrePersist
    void createdAt(){
        this.sentAt = LocalDateTime.now();
    }

}