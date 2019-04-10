INSERT INTO User (id, version, first_name, second_name, position, phone) VALUES (1, 0, 'Вася', 'Пупкин', 'менеджер', 95098231);
INSERT INTO User (id, version, first_name, position, doc_name, doc_number, doc_date) VALUES (2, 0, 'Вася', 'дворник','паспорт', 95092323, '2010-03-15');
INSERT INTO User (id, version, first_name, middle_name, position, phone) VALUES (3, 0, 'Иван','Иванович', 'сантехник', 95098231);

INSERT INTO Office (id, version, name, address) VALUES (1, 0, 'Головной', 'Декабристов 12-2');
INSERT INTO Office (id, version, name, address) VALUES (2, 0, 'Западный', 'Ленина 1/32');
INSERT INTO Office (id, version, name, address, phone, is_active) VALUES (3, 0, 'Восточный', 'Восстания 231', 890899, true);

INSERT INTO Organization (id, version, name, full_name, address, inn, kpp) VALUES (1, 0, 'ЗАО John&CO', 'John&CO','Высокогорная 1', 88098, 789371);
INSERT INTO Organization (id, version, name, full_name, address, is_active) VALUES (2, 0, 'ООО BOSH', 'BOSH','Вавилова 10', true);
INSERT INTO Organization (id, version, name, full_name, address, phone) VALUES (3, 0, 'SIEMENS', 'ОАО SIEMENS','Партизанская 21', 7327183);

