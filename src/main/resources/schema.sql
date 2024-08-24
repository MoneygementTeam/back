-- Schema for moneygement database
-- Drop existing tables if they exist
-- 먼저 참조하는 테이블부터 삭제
# DROP TABLE IF EXISTS quiz_history;
# DROP TABLE IF EXISTS quiz;
# DROP TABLE IF EXISTS coin;
# DROP TABLE IF EXISTS monster_collection;
# DROP TABLE IF EXISTS asset;
# DROP TABLE IF EXISTS theme_invest_return;
#
# -- FK로 참조되는 테이블 삭제
# DROP TABLE IF EXISTS theme;
# DROP TABLE IF EXISTS ai_prompt;
# DROP TABLE IF EXISTS monster;
# DROP TABLE IF EXISTS `character`;
# DROP TABLE IF EXISTS user;

-- user table
CREATE TABLE IF NOT EXISTS user
(
    user_id              VARCHAR(40) NOT NULL,
    user_pw              VARCHAR(40) DEFAULT NULL,
    current_character_id VARCHAR(40) DEFAULT NULL,
    created_date         DATETIME    DEFAULT NOW(),
    updated_date         DATETIME    DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (user_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- asset table
CREATE TABLE IF NOT EXISTS asset
(
    user_id      VARCHAR(40) NOT NULL,
    asset_amount DECIMAL(19, 0) DEFAULT NULL,
    created_date DATETIME       DEFAULT NOW(),
    updated_date DATETIME       DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- monster table
CREATE TABLE IF NOT EXISTS monster
(
    monster_id        VARCHAR(40) NOT NULL,
    monster_name      VARCHAR(40)   DEFAULT NULL,
    monster_desc      VARCHAR(2000) DEFAULT NULL,
    monster_image_url VARCHAR(2083) DEFAULT NULL,
    monster_model_url VARCHAR(2083) DEFAULT NULL,
    created_date      DATETIME      DEFAULT NOW(),
    updated_date      DATETIME      DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (monster_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- character table
CREATE TABLE IF NOT EXISTS `character`
(
    character_id        BIGINT AUTO_INCREMENT NOT NULL,
    character_name      VARCHAR(40)   DEFAULT NULL,
    character_image_url VARCHAR(2083) DEFAULT NULL,
    character_model_url VARCHAR(2083) DEFAULT NULL,
    created_date        DATETIME      DEFAULT NOW(),
    updated_date        DATETIME      DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (character_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- monster_collection table
CREATE TABLE IF NOT EXISTS monster_collection
(
    user_id      VARCHAR(40) NOT NULL,
    monster_id   VARCHAR(40) NOT NULL,
    created_date DATETIME DEFAULT NOW(),
    updated_date DATETIME DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (user_id, monster_id),
    FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE NO ACTION,
    FOREIGN KEY (monster_id) REFERENCES monster (monster_id) ON DELETE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- theme table
CREATE TABLE IF NOT EXISTS theme
(
    theme_id     VARCHAR(40)   NOT NULL,
    theme_name   VARCHAR(40)   NOT NULL,
    theme_desc   VARCHAR(2000) NOT NULL,
    created_date DATETIME DEFAULT NOW(),
    updated_date DATETIME DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (theme_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE  IF NOT EXISTS theme_invest_return
(
    theme_id           VARCHAR(40) PRIMARY KEY,
    commodity_return   VARCHAR(10),
    coin_return        VARCHAR(10),
    stock_return       VARCHAR(10),
    real_estate_return VARCHAR(10)) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;;

-- ai_prompt table
CREATE TABLE IF NOT EXISTS ai_prompt
(
    ai_prompt_id    VARCHAR(40)   NOT NULL,
    ai_prompt_class VARCHAR(20)   NOT NULL,
    ai_question     VARCHAR(2000) NOT NULL,
    ai_answer       VARCHAR(2000) DEFAULT NULL,
    created_date    DATETIME      DEFAULT NOW(),
    updated_date    DATETIME      DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (ai_prompt_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- quiz table
CREATE TABLE IF NOT EXISTS quiz
(
    quiz_id      VARCHAR(40) NOT NULL,
    theme_id     VARCHAR(40) NOT NULL,
    ai_prompt_id VARCHAR(40) NOT NULL,
    priority     INT      DEFAULT 0,
    created_date DATETIME DEFAULT NOW(),
    updated_date DATETIME DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (quiz_id),
    CONSTRAINT fk_ai_prompt_id FOREIGN KEY (ai_prompt_id) REFERENCES ai_prompt (ai_prompt_id) ON DELETE NO ACTION,
    CONSTRAINT fk_theme_id FOREIGN KEY (theme_id) REFERENCES theme (theme_id) ON DELETE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- quiz_history table
CREATE TABLE IF NOT EXISTS quiz_history
(
    user_id      VARCHAR(40) NOT NULL,
    quiz_id      VARCHAR(40) NOT NULL,
    created_date DATETIME DEFAULT NOW(),
    updated_date DATETIME DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (user_id, quiz_id),
    FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE NO ACTION,
    FOREIGN KEY (quiz_id) REFERENCES quiz (quiz_id) ON DELETE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- coin table
CREATE TABLE IF NOT EXISTS coin
(
    user_id      VARCHAR(40)    NOT NULL,
    market       VARCHAR(10)    NOT NULL,
    quantity     DECIMAL(19, 8) NOT NULL,
    created_date DATETIME DEFAULT NOW(),
    updated_date DATETIME DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (user_id, market), -- 복합 기본 키 설정
    FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
