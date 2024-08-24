package com.angelhack.moneygement.user.entity;

import java.util.List;

import com.angelhack.moneygement.common.entity.BaseEntity;
import com.angelhack.moneygement.monster.entity.Monster;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
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

    @Column(name = "current_monster_id", length = 40)
    private String currentMonsterId;

    @OneToMany
    @JoinTable(
        name = "monster_collection",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "monster_id")
    )
    private List<Monster> monsterCollection;
}
