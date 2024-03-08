package ru.alimov.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.alimov.chat.model.ChatUser;
import java.util.*;

public interface ChatUserRepository extends JpaRepository<ChatUser,Long> {
    @Query(value = "SELECT * FROM chat_user WHERE id=?1",nativeQuery = true)
    public ChatUser getById(Long id);

    @Query(value = "SELECT * FROM chat_user WHERE id!=?1",nativeQuery = true)
    public List<ChatUser> getOtherUsers(Long id);

    @Query(value = "SELECT * FROM chat_user WHERE number=?1",nativeQuery = true)
    public ChatUser getUserByNumber(String number);
    
}
