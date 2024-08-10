package com.chatapp.chatapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;


@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authority_id")
    private UUID Id;

    private String authorityName;


    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @Override
    public String getAuthority() {
        return authorityName;
    }

    public void setName(String name) {
        this.authorityName = name;
    }
}
