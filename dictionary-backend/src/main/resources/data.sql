INSERT INTO dictionary(id, name, type) VALUES (1000, 'Bilingual J-E', 'BILINGUAL');
INSERT INTO dictionary(id, name, type) VALUES (2000, 'Monolingual J-J', 'MONOLINGUAL');
INSERT INTO dictionary(id, name, type) VALUES (3000, '新 Monolingual J-J', 'MONOLINGUAL');
INSERT INTO dictionary(id, name, type) VALUES (4000, 'Pitch Accent 辞典', 'MONOLINGUAL');

INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (1000, '食べる', 'たべる', 'to eat',1000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (2000, '行く', 'いく', 'to go',1000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (3000, '犬', 'いぬ', 'dog',1000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (4000, '本', 'ほん', 'book',1000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (5000, '本屋', 'ほんや', 'bookstore',1000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (6000, '行く', 'いく', '向こうへ移動する。',2000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (7000, '食べる', 'たべる', '食物をかんで、のみこむ。',2000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (8000, '行く', 'いく','〈（どこカラ）どこ・なにニ（なにデ）―／どこヲ―〉 その場所から、他の場所へ△移動する（進む）。',3000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (9000, 'こんにちは', 'こんにちは', 'hello', 1000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (10000, 'こんにちは', 'こんにちは', '日中，人に会ったり，人を訪問した時の挨拶(アイサツ)の言葉。', 2000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (11000, '食べる', 'たべる', '発音図：タベ↓ル [2]', 4000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (12000, '行く', 'いく', '発音図：イク [0]', 4000);


