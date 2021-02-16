INSERT INTO dictionary(id, name, type) VALUES (1, 'Bilingual J-E', 'BILINGUAL');
INSERT INTO dictionary(id, name, type) VALUES (2, 'Monolingual J-J', 'MONOLINGUAL');
INSERT INTO dictionary(id, name, type) VALUES (3, '新 Monolingual J-J', 'MONOLINGUAL');

INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (1, '食べる', 'たべる', 'to eat',1);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (2, '行く', 'いく', 'to go',1);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (3, '犬', 'いぬ', 'dog',1);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (4, '本', 'ほん', 'book',1);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (5, '本屋', 'ほんや', 'bookstore',1);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (6, '行く', 'いく', '向こうへ移動する。',2);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (7, '食べる', 'たべる', '食物をかんで、のみこむ。',2);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (8, '行く', 'いく','〈（どこカラ）どこ・なにニ（なにデ）―／どこヲ―〉 その場所から、他の場所へ△移動する（進む）。',3);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (9, 'こんにちは', 'こんにちは', 'hello', 1);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (10, 'こんにちは', 'こんにちは', '日中，人に会ったり，人を訪問した時の挨拶(アイサツ)の言葉。', 2);


