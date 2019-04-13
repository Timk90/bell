INSERT INTO User (id, version, first_name, position, doс_id, phone, personal_doc_id, sitizenship_id) VALUES (1, 0, 'Вася', 'дворник', 10, '+795092323', 1, 1);
INSERT INTO User_document (id, version, doc_number, doc_date) VALUES (1, 0, '9901 881323', 21-12-2010);

INSERT INTO User (id, version, first_name, position, doс_id, phone, personal_doc_id, sitizenship_id) VALUES (2, 0, 'Xavier', 'actor', 4, '+10495092323', 2, 10);
INSERT INTO User_document (id, version, doc_number, doc_date) VALUES (2, 0, '9901 881323', 21-12-2010);

INSERT INTO User (id, version, first_name, position, doс_id, phone, personal_doc_id, sitizenship_id) VALUES (3, 0, 'Андрей', 'сантехник', 10, '+795092323', 3, 1);
INSERT INTO User_document (id, version, doc_number, doc_date) VALUES (3, 0, '9901 881323', 11-01-2000);

INSERT INTO Office (id, version, name, address, organization_id) VALUES (1, 0, 'Головной', 'Декабристов 12-2', 1);
INSERT INTO Office (id, version, name, address, organization_id) VALUES (2, 0, 'Западный', 'Ленина 1/32', 2);
INSERT INTO Office (id, version, name, address, phone, is_active, organization_id) VALUES (3, 0, 'Восточный', 'Восстания 231', 890899, true, 3);

INSERT INTO Organization (id, version, name, full_name, address, inn, kpp) VALUES (1, 0, 'ЗАО John&CO', 'John&CO','Высокогорная 1', 88098, 789371);
INSERT INTO Organization (id, version, name, full_name, address, is_active) VALUES (2, 0, 'ООО BOSH', 'BOSH','Вавилова 10', true);
INSERT INTO Organization (id, version, name, full_name, address, phone) VALUES (3, 0, 'SIEMENS', 'ОАО SIEMENS','Партизанская 21', 7327183);

INSERT INTO Docs (id, version, code, name) VALUES (1,  0, '03', 'Свидетельство о рождении');
INSERT INTO Docs (id, version, code, name) VALUES (2,  0, '07', 'Военный билет');
INSERT INTO Docs (id, version, code, name) VALUES (3,  0, '08', 'Временное удостоверение, выданное вместо военного билета');
INSERT INTO Docs (id, version, code, name) VALUES (4,  0, '10', 'Паспорт иностранного гражданина');
INSERT INTO Docs (id, version, code, name) VALUES (5,  0, '11', 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу');
INSERT INTO Docs (id, version, code, name) VALUES (6,  0, '12', 'Вид на жительство в Российской Федерации');
INSERT INTO Docs (id, version, code, name) VALUES (7,  0, '13', 'Удостоверение беженца');
INSERT INTO Docs (id, version, code, name) VALUES (8,  0, '15', 'Разрешение на временное проживание в Российской Федерации');
INSERT INTO Docs (id, version, code, name) VALUES (9,  0, '18', 'Свидетельство о предоставлении временного убежища на территории Российской Федерации');
INSERT INTO Docs (id, version, code, name) VALUES (10, 0, '21', 'Паспорт гражданина Российской Федерации');
INSERT INTO Docs (id, version, code, name) VALUES (11, 0, '23', 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');
INSERT INTO Docs (id, version, code, name) VALUES (12, 0, '24', 'Удостоверение личности военнослужащего Российской Федерации');
INSERT INTO Docs (id, version, code, name) VALUES (13, 0, '91', 'Иные документы');

INSERT INTO Countries (id, version, code, name) VALUES (1,   0, '643', 'Российская Федерация');
INSERT INTO Countries (id, version, code, name) VALUES (2,   0, '276', 'Германия');
INSERT INTO Countries (id, version, code, name) VALUES (3,   0, '724', 'Испания');
INSERT INTO Countries (id, version, code, name) VALUES (4,   0, '840', 'США');
INSERT INTO Countries (id, version, code, name) VALUES (5,   0, '410', 'Республика Корея');
INSERT INTO Countries (id, version, code, name) VALUES (6,   0, '792', 'Турция');
INSERT INTO Countries (id, version, code, name) VALUES (7,   0, '860', 'Узбекистан');
INSERT INTO Countries (id, version, code, name) VALUES (8,   0, '112', 'Белоруссия');
INSERT INTO Countries (id, version, code, name) VALUES (9,   0, '756', 'Швейцария');
INSERT INTO Countries (id, version, code, name) VALUES (10,  0, '250', 'Франция');



