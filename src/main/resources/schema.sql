CREATE TABLE IF NOT EXISTS Office (
    id               INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version          INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    name             VARCHAR(50)  NOT NULL COMMENT 'Название офиса',
    address          VARCHAR(50)  NOT NULL COMMENT 'Адрес',
    phone            VARCHAR(50)           COMMENT 'Номер телефона',
    is_active        BOOLEAN               COMMENT 'Рабочий'
);

COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS User (
    id               INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version          INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    first_name       VARCHAR(50)  NOT NULL COMMENT 'Имя',
    second_name      VARCHAR(50)           COMMENT 'Фамилия',
    middle_name      VARCHAR(50)           COMMENT 'Отчество',
    position         VARCHAR(50)  NOT NULL COMMENT 'Должность',
    phone            VARCHAR(50)           COMMENT 'Номер телефона',
    doc_name         VARCHAR(50)           COMMENT 'Документ',
    doc_number       INTEGER               COMMENT 'Номер документа',
    doc_date         DATE                  COMMENT 'Дата выдачи',
    citizenship_name VARCHAR(50)           COMMENT 'Гражданстно',
    citizenship_code VARCHAR(50)           COMMENT 'Код страны',
    is_identified    BOOLEAN               COMMENT 'Идентифицирован?',
    office_id        INTEGER               COMMENT 'внешний ключ',
    FOREIGN KEY (office_id) REFERENCES Office(id) 
);

COMMENT ON TABLE User IS 'Человек';

CREATE TABLE IF NOT EXISTS Organization (
    id               INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version          INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    name             VARCHAR(50)  NOT NULL COMMENT 'Название (сокращенное)',
    full_name        VARCHAR(50)  NOT NULL COMMENT 'Название (полное)',
    inn              VARCHAR(50)           COMMENT 'ИНН организации',
    kpp              VARCHAR(50)           COMMENT 'КПП организации',
    address          VARCHAR(50)  NOT NULL COMMENT 'Адрес',
    phone            VARCHAR(50)           COMMENT 'Номер телефона',
    is_active        BOOLEAN               COMMENT 'Активен?',
    office_id        INTEGER               COMMENT 'внешний ключ',
    FOREIGN KEY (office_id) REFERENCES Office(id) 
);

COMMENT ON TABLE Organization IS 'Организация';



