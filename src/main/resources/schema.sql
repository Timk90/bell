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

***
***
***
// продолжить отсюда. 
CREATE TABLE IF NOT EXISTS Person_House (
    person_id   INTEGER  NOT NULL COMMENT 'Уникальный идентификатор человека',
    house_id    INTEGER  NOT NULL COMMENT 'Уникальный идентификатор дома',

    PRIMARY KEY (person_id, house_id)
);
COMMENT ON TABLE Person_House IS 'join-таблица для связи человека и дома';

CREATE INDEX IX_Person_House_Id ON Person_House (house_id);
ALTER TABLE Person_House ADD FOREIGN KEY (house_id) REFERENCES House(id);

CREATE INDEX IX_House_Person_Id ON Person_House (person_id);
ALTER TABLE Person_House ADD FOREIGN KEY (person_id) REFERENCES Person(id);

