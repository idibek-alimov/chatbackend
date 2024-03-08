package ru.alimov.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.alimov.chat.model.ChatMessage;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long> {
    @Query(value = "SELECT * FROM chat_message WHERE  (sender_id = ?1 AND receiver_id = ?2) OR(sender_id = ?2 AND receiver_id = ?1) ",nativeQuery = true)
    public List<ChatMessage> getBySenderAndReceiver(Long sender,Long receiver);
}
