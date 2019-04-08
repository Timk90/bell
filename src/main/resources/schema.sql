CREATE TABLE IF NOT EXISTS User (
    id               INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version          INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    first_name       VARCHAR(50)  NOT NULL COMMENT 'Имя',
    second_name      VARCHAR(50)           COMMENT 'Фамилия',
    middle_name      VARCHAR(50)           COMMENT 'Отчество',
    position         VARCHAR(50)  NOT NULL COMMENT 'Должность',
    phone            INTEGER               COMMENT 'Номер телефона',
    doc_name         VARCHAR(50)           COMMENT 'Документ',
    doc_number       INTEGER               COMMENT 'Номер документа',
    doc_date         DATE                  COMMENT 'Дата выдачи',
    citizenship_name VARCHAR(50)           COMMENT 'Гражданстно',
    citizenship_code VARCHAR(50)           COMMENT 'Код страны',
    is_identified    BOOLEAN               COMMENT 'Идентифицирован?'
);

COMMENT ON TABLE User IS 'Человек';

CREATE TABLE IF NOT EXISTS Organization (
    id               INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version          INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    name             VARCHAR(50)  NOT NULL COMMENT 'Название (сокращенное)',
    full_name        VARCHAR(50)  NOT NULL COMMENT 'Название (полное)',
    inn              INTEGER               COMMENT 'ИНН организации',
    kpp              INTEGER               COMMENT 'КПП организации',
    address          VARCHAR(50)  NOT NULL COMMENT 'Адрес',
    phone            INTEGER               COMMENT 'Номер телефона',
    is_active        BOOLEAN               COMMENT 'Активен?'
);

COMMENT ON TABLE Organization IS 'Организация';
  
CREATE TABLE IF NOT EXISTS Office (
    id               INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version          INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    name             VARCHAR(50)  NOT NULL COMMENT 'Название офиса',
    address          VARCHAR(50)  NOT NULL COMMENT 'Адрес',
    phone            INTEGER               COMMENT 'Номер телефона',
    is_active        BOOLEAN               COMMENT 'Рабочий'
);

COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS User_Office (
    user_id   INTEGER  NOT NULL COMMENT 'Уникальный идентификатор человека',
    office_id    INTEGER  NOT NULL COMMENT 'Уникальный идентификатор офиса',
    PRIMARY KEY (user_id, office_id)
);

COMMENT ON TABLE User_Office IS 'join-таблица для связи человека и офиса';

CREATE TABLE IF NOT EXISTS Office_Organization (
    office_id    INTEGER  NOT NULL COMMENT 'Уникальный идентификатор офиса',
    organization_id    INTEGER  NOT NULL COMMENT 'Уникальный идентификатор организации',
    PRIMARY KEY (office_id, organization_id)
);

COMMENT ON TABLE Office_Organization IS 'join-таблица для офиса и организации';

CREATE INDEX IX_User_Office_Id ON User_Office (user_id);
ALTER TABLE User_Office ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Office_User_Id ON User_Office (office_id);
ALTER TABLE User_Office ADD FOREIGN KEY (user_id) REFERENCES User(id);


CREATE INDEX IX_Office_Organization_Id ON Office_Organization (office_id);
ALTER TABLE Office_Organization ADD FOREIGN KEY (organization_id) REFERENCES Organization(id);

CREATE INDEX IX_Organization_Office_Id ON Office_Organization (organization_id);
ALTER TABLE Office_Organization ADD FOREIGN KEY (office_id) REFERENCES Office(id);

