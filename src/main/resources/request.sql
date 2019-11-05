CREATE TABLE houses
(
    id INTEGER PRIMARY KEY AUTOINCREMENT ,
    price INTEGER NOT NULL CHECK ( price > 0 ) ,
    rooms INTEGER NOT NULL CHECK ( rooms > 0 ) ,
    district TEXT NOT NULL ,
    metro TEXT NOT NULL
);

INSERT INTO houses (price, rooms, district, metro) VALUES (350000, 1, 'Maxvorstadt', 'Harthof');
INSERT INTO houses (price, rooms, district, metro) VALUES (160000, 1, 'Trudering', 'Moosach');
INSERT INTO houses (price, rooms, district, metro) VALUES (750000, 2, 'Brayton', 'Riem');
INSERT INTO houses (price, rooms, district, metro) VALUES (100000, 1, 'Glockenbach', 'Lehel');
INSERT INTO houses (price, rooms, district, metro) VALUES (950000, 3, 'Brayton', 'Riem');
INSERT INTO houses (price, rooms, district, metro) VALUES (570000, 2, 'Bogenhausen', 'Stroxo');
INSERT INTO houses (price, rooms, district, metro) VALUES (1240000, 3, 'Nymphenburg-Neuhausen', 'Nymphenburg');
INSERT INTO houses (price, rooms, district, metro) VALUES (200000, 2, 'Trudering', 'Moosach');
INSERT INTO houses (price, rooms, district, metro) VALUES (750000, 1, 'Brayton', 'Riem');
INSERT INTO houses (price, rooms, district, metro) VALUES (480000, 1, 'Maxvorstadt', 'Harthof');