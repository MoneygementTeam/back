package com.angelhack.moneygement.theme.entity;

import com.angelhack.moneygement.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "theme")
public class Theme extends BaseEntity {

    @Id
    @Column(name = "theme_id", length = 40)
    private String themeId;

    @Column(name = "theme_name", length = 40)
    private String themeName;

    @Column(name = "theme_desc", length = 2000)
    private String themeDesc;
}
