package ru.alimov.chat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatUser {
    @Id
    @GeneratedValue(generator = "chat_user_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "chat_user_id_generator", sequenceName = "Chat_user_id_generator", allocationSize = 1)
    private Long Id;
    private String name;
    private String number;
}
