-- Создаем новую БД Human_Friends
CREATE DATABASE Human_Friends;

-- Выбираем для работы созданную БД и создаем в ней таблицы с животнымиalter
USE Human_Friends;
CREATE TABLE Pets (
		ID INT AUTO_INCREMENT PRIMARY KEY,
        Name VARCHAR(100) NOT NULL,
        Type VARCHAR(50) NOT NULL,
        BirthDate DATE NOT NULL,
        Commands TEXT
);
CREATE TABLE Horses (
		ID INT AUTO_INCREMENT PRIMARY KEY,
        Name VARCHAR(100) NOT NULL,
        Type VARCHAR(50) NOT NULL,
        BirthDate DATE NOT NULL,
        Commands TEXT
);
CREATE TABLE Camels (
		ID INT AUTO_INCREMENT PRIMARY KEY,
        Name VARCHAR(100) NOT NULL,
        Type VARCHAR(50) NOT NULL,
        BirthDate DATE NOT NULL,
        Commands TEXT
);
CREATE TABLE Donkeys (
		ID INT AUTO_INCREMENT PRIMARY KEY,
        Name VARCHAR(100) NOT NULL,
        Type VARCHAR(50) NOT NULL,
        BirthDate DATE NOT NULL,
        Commands TEXT
);

-- Заполняем созданныетаблицы данными
INSERT INTO Pets (Name, Type, BirthDate, Commands)
VALUES
	('Fido', 'dog', '2020-01-01', 'Sit, Stay, Fetch'),
	('Whiskers', 'cat', '2019-05-15', 'Sit, Pounce'),
	('Hammy', 'hamster', '2021-03-10', 'Roll, Hide'),
	('Buddy', 'dog', '2018-12-10', 'Sit, Paw, Bark'),
	('Smudge', 'cat', '2020-02-20', 'Sit, Pounce, Scratch'),
	('Peanut', 'hamster', '2021-08-01', 'Roll, Spin'),
	('Bella', 'dog', '2019-11-11', 'Sit, Stay, Roll'),
	('Oliver', 'cat', '2020-06-30', 'Meow, Scratch, Jump');

INSERT INTO Horses (Name, Type, BirthDate, Commands)
VALUES 
    ('Thunder', 'horse', '2018-04-12', 'gallop, jump, stop'),
    ('Blaze', 'horse', '2019-08-30', 'trot, turn, canter'),
    ('Storm', 'horse', '2020-02-18', 'walk, stop, jump'),
    ('Star', 'horse', '2019-07-10', 'gallop, trot, turn'),
    ('Shadow', 'horse', '2017-05-14', 'canter, jump, stop'),
    ('Duke', 'horse', '2018-12-05', 'walk, trot, gallop'),
    ('Apollo', 'horse', '2021-03-22', 'jump, stop, turn'),
    ('Ranger', 'horse', '2020-11-15', 'canter, gallop, walk');
    
INSERT INTO Camels (Name, Type, BirthDate, Commands)
VALUES 
    ('Sahara', 'camel', '2017-11-25', 'walk, sit, carry load'),
    ('Dune', 'camel', '2016-05-14', 'lie down, stand up, walk'),
    ('Sandy', 'camel', '2019-09-20', 'drink, eat, rest'),
    ('Humpy', 'camel', '2018-12-05', 'carry load, walk, stop'),
    ('Desert', 'camel', '2020-03-15', 'walk, sit, drink'),
    ('Oasis', 'camel', '2021-07-10', 'rest, eat, carry load'),
    ('Mirage', 'camel', '2019-02-18', 'walk, stop, lie down'),
    ('Nomad', 'camel', '2022-01-15', 'carry load, walk, drink');

INSERT INTO Donkeys (Name, Type, BirthDate, Commands)
VALUES 
    ('Dusty', 'donkey', '2020-02-18', 'pull cart, stay, come'),
    ('Buddy', 'donkey', '2021-03-22', 'walk, carry load, stop'),
    ('Snowball', 'donkey', '2022-01-15', 'come here, stay, run'),
    ('Fluffy', 'donkey', '2021-12-10', 'run, stay, walk'),
    ('Jack', 'donkey', '2019-07-10', 'pull cart, stop, come'),
    ('Ollie', 'donkey', '2020-08-30', 'walk, carry load, stay'),
    ('Milo', 'donkey', '2021-05-14', 'run, come here, stop'),
    ('Rocky', 'donkey', '2022-03-22', 'pull cart, walk, stay');

-- Удаляем таблицу с верблюдами
DROP TABLE Camels;

-- Создаем новую таблицу для объединённых данных
CREATE TABLE PackAnimals (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Type VARCHAR(50) NOT NULL,
    BirthDate DATE NOT NULL,
    Commands TEXT
	);

-- Переносим данные из таблиц с лошадьми и ослами в новую таблицу
INSERT INTO PackAnimals (Name, Type, BirthDate, Commands)
SELECT Name, Type, BirthDate, Commands
FROM Horses;

INSERT INTO PackAnimals (Name, Type, BirthDate, Commands)
SELECT Name, Type, BirthDate, Commands
FROM Donkeys;

-- Удаляем старые таблицы лошадей и ословalter
DROP TABLE Horses;
DROP TABLE Donkeys;

-- Создаем таблицу для животных в возрасте от 1 до 3 лет и заполняем ее данным из других таблиц
CREATE TABLE young_animals (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Type VARCHAR(50) NOT NULL,
    BirthDate DATE NOT NULL,
    Age INT,
    Commands TEXT
	);

INSERT INTO young_animals (Name, Type, BirthDate, Age, Commands)
SELECT 
	Name,
    Type,
    BirthDate,
    TIMESTAMPDIFF(YEAR, BirthDate, '2024-01-01') AS Age,
    Commands
FROM PackAnimals
WHERE TIMESTAMPDIFF(YEAR, BirthDate, '2024-01-01') BETWEEN 1 AND 3;

-- Объединяем таблицы Pets и PackAnimals в одну Animals, сохраняя информацию обизначальных таблицахa
CREATE TABLE Animals (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Type VARCHAR(50) NOT NULL,
    BirthDate DATE NOT NULL,
    Age INT,
    Commands TEXT,
    SourceTable VARCHAR(50) 
);

INSERT INTO Animals (Name, Type, BirthDate, Age, Commands, SourceTable)
SELECT
	Name,
    Type,
    BirthDate,
    TIMESTAMPDIFF(YEAR, BirthDate, '2024-01-01') AS Age,
    Commands,
    'Pets' AS SourceTable
FROM Pets;

INSERT INTO Animals (Name, Type, BirthDate, Age, Commands, SourceTable)
SELECT
	Name,
    Type,
    BirthDate,
    TIMESTAMPDIFF(YEAR, BirthDate, '2024-01-01') AS Age,
    Commands,
    'PackAnimals' AS SourceTable
FROM PackAnimals;

SELECT * FROM Animals
ORDER BY Type;