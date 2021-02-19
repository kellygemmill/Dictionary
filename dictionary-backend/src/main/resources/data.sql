INSERT INTO dictionary(id, name, type) VALUES (1000, 'Bilingual J-E', 'BILINGUAL');
INSERT INTO dictionary(id, name, type) VALUES (2000, 'Monolingual J-J', 'MONOLINGUAL');
INSERT INTO dictionary(id, name, type) VALUES (3000, 'New Monolingual J-J', 'MONOLINGUAL');
INSERT INTO dictionary(id, name, type) VALUES (4000, 'Pitch Accent', 'MONOLINGUAL');

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
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (13000, '橋', 'はし', 'bridge',1000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (14000, '箸', 'はし', 'chopsticks',1000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (15000, '橋', 'はし', '道路・鉄道・水路などを、川や谷、また他の交通路の上などに通す際、その通路としてかける構築物。',2000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (16000, '箸', 'はし', '食物などを挟むのに用いる2本で一対の細い棒。',2000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (17000, '橋', 'はし', '発音図：ハシ↓ [2]',4000);
INSERT INTO entry (id, word, reading, definition, dictionary_id) VALUES (18000, '箸', 'はし', '発音図：ハ↓シ [1]',4000);



