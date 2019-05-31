CREATE TABLE IF NOT EXISTS Docs (
	id               INTEGER                COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version          INTEGER       NOT NULL COMMENT 'Служебное поле hibernate',
    code             VARCHAR(50)   NOT NULL COMMENT 'Код документа',
    name             VARCHAR(150)  NOT NULL COMMENT 'Название документа'
);

COMMENT ON TABLE Docs IS 'Справочник документов';

CREATE TABLE IF NOT EXISTS Countries (
	id               INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version          INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    code             VARCHAR(50)  NOT NULL COMMENT 'Код страны',
    name             VARCHAR(50)  NOT NULL COMMENT 'Название страны / Гражданство'
);

COMMENT ON TABLE Countries IS 'Справочник стран. Коды стран: https://geo.koltyrin.ru/kody_stran_mira.php';


CREATE TABLE IF NOT EXISTS Organization (
    id               INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version          INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    name             VARCHAR(50)  NOT NULL COMMENT 'Название (сокращенное)',
    full_name        VARCHAR(50)  NOT NULL COMMENT 'Название (полное)',
    inn              VARCHAR(50)           COMMENT 'ИНН организации',
    kpp              VARCHAR(50)           COMMENT 'КПП организации',
    address          VARCHAR(50)  NOT NULL COMMENT 'Адрес',
    phone            VARCHAR(50)           COMMENT 'Номер телефона',
    is_active        BOOLEAN               COMMENT 'Активен?'
);

COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Office (
    id               INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version          INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    name             VARCHAR(50)  NOT NULL COMMENT 'Название офиса',
    address          VARCHAR(50)  NOT NULL COMMENT 'Адрес',
    phone            VARCHAR(50)           COMMENT 'Номер телефона',
    organization_id  INTEGER      NOT NULL COMMENT 'Внешний ключ на организацию',
    is_active        BOOLEAN               COMMENT 'Рабочий',
    FOREIGN KEY (organization_id) REFERENCES Organization(id) 
);

COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS User_document (
	id               INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version          INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    doc_number       VARCHAR(50)  NOT NULL COMMENT 'Номер документа сотрудника',
    doc_date         DATE         NOT NULL COMMENT 'Дата выдачи',
    doc_id           INTEGER      NOT NULL COMMENT 'Внешний ключ на тип документа',
    FOREIGN KEY (doc_id)          REFERENCES Docs(id)
);

COMMENT ON TABLE User_document IS 'Личная информация документа сотрудника';

CREATE TABLE IF NOT EXISTS User (
    id               INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version          INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    first_name       VARCHAR(50)  NOT NULL COMMENT 'Имя',
    second_name      VARCHAR(50)           COMMENT 'Фамилия',
    middle_name      VARCHAR(50)           COMMENT 'Отчество',
    position         VARCHAR(50)  NOT NULL COMMENT 'Должность',
    phone            VARCHAR(50)           COMMENT 'Номер телефона',
    personal_doc_id  INTEGER               COMMENT 'Внешний ключ на документ пользователя',
    citizenship_id   INTEGER               COMMENT 'Внешний ключ на информацию о гражданстве',
    office_id        INTEGER               COMMENT 'Внешний ключ на офис',
    is_identified    BOOLEAN               COMMENT 'Идентифицирован?',
    FOREIGN KEY (office_id)          REFERENCES Office(id),
    FOREIGN KEY (personal_doc_id)    REFERENCES User_document(id),
    FOREIGN KEY (citizenship_id)     REFERENCES Countries(id)
);

COMMENT ON TABLE User IS 'Сотрудник';

CREATE INDEX IX_Office_Organization_Id ON Office(organization_id);
CREATE INDEX IX_User_Office_Id ON User(office_id);
CREATE INDEX IX_Personal_Doc_Id ON User_document(doc_id);
CREATE INDEX IX_User_Personal_Doc_Id ON User(personal_doc_id);
CREATE INDEX IX_User_Citizenship_Id ON User(citizenship_id);



