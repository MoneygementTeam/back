package com.angelhack.moneygement.user.entity;

import com.angelhack.moneygement.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @Column(name = "user_id", length = 40)
    private String userId;

    @Column(name = "user_pw", length = 40)
    private String userPw;

    @Column(name = "current_character_id", length = 40)
    private String currentCharacterId;
}
