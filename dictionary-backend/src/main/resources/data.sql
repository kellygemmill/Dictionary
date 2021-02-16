INSERT INTO dictionary(id, name, type) VALUES (1, 'Bilingual J-E', 'BILINGUAL');
INSERT INTO dictionary(id, name, type) VALUES (2, 'Monolingual J-J', 'MONOLINGUAL');

INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (1, '食べる', 'たべる', 'to eat',1);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (2, '行く', 'いく', 'to go',1);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (3, '犬', 'いぬ', 'dog',1);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (4, '本', 'ほん', 'book',1);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (5, '本屋', 'ほんや', 'bookstore',1);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (6, '行く', 'いく', '向こうへ移動する。',2);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (7, '食べる', 'たべる', '食物をかんで、のみこむ。',2);


