package com.atacanymc.basicmoviereviewapi.Model;

import com.atacanymc.basicmoviereviewapi.Enum.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;


@Document(collection = "users")
@Data
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity{
    private @Id ObjectId id;
    private String username;
    private String password;
    private String email;
    private UserStatus status;
    @DocumentReference(collection = "reviews", lazy = true)
    private List<Review> reviews;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = UserStatus.ACTIVE;
        this.setCreatedDate(LocalDateTime.now());
        this.setUpdatedDate(LocalDateTime.now());
    }
}
