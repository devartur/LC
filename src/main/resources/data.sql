insert into feedback(id, subject, email, feedback) values
  (1, 'Jan', 'Kowalski', '90101222457'),
  (2, 'Maciej', 'Zalewski', '87112242456'),
  (3, 'Aneta', 'Korczyńska', '76061536749'),
  (4, 'Wojciech', 'Sokolik', '82010877245');

-- examles menu tree
  insert into ALL_QUESTIONS (id, FIRST_LEVEL ,SECOND_LEVEL  , THIRD_LEVEL , FOURTH_LEVEL , FIFTH_LEVEL , SIXTH_LEVEL ) values
  (1, 'Java', 'Podstawy', 'Typy proste', null, null, null),
  (2, 'Java', 'Podstawy', 'Typy proste', null, null, null),	
  (3, 'Java', 'Podstawy', 'Typy proste', null, null, null),	
  (4, 'Java', 'Podstawy', 'Typy proste', null, null, null),	
  (6, 'Java', 'Biblioteki', 'Spring', null, null, null),	
  (7, 'Java', 'Biblioteki', 'Hibernate', null, null, null),	
  (8, 'Java', 'Wzorce projetkowe', 'Fabryka', null, null, null),
  (9, 'SQL', 'Zapytania', 'Select', null, null, null),
  (10, 'Angular', 'Podstawy', 'Componenty', null, null, null); 
  
  
  -- Example question 
   INSERT INTO QUESTION  (ID, QUESTION, BASIC_ANSWER, INTERMEDIATE_ANSWER, ADVANCED_ANSWER, IS_SHOW_IN_ALL_QUESTION, ALL_QUESTIONS_ID, CREATION_BY, CREATION_TIME ) VALUES 
(1, '1 Co to int? ', ' Liczbowy typ prosty ', ' Zawiera liczby z przedziału ', ' Niezainicjalizowany przez nas automatycznie przyjmuje wartość 0 przez co nie może być null ', 
TRUE, 1,  ' Artur ',  CURRENT_TIMESTAMP),
(2, '2 Co to html? ', ' html ', ' 
<h1 style="color: #5e9ca0;">You can edit <span style="color: #2b2301;">this demo</span> text!</h1>
<ul>
<li style="color: #2e6c80;"><strong style="color: #000000; font-size: 14px;">coś ta</strong></li>
<li style="color: #2e6c80;"><strong style="color: #000000; font-size: 14px;">tu cos<br />&nbsp;</strong></li>
</ul>
', ' html 2 ', TRUE, 1,  ' Artur ',  CURRENT_TIMESTAMP),
(3, '3 Co to html? ', ' html ', ' 
<h1 style="color: #5e9ca0;">You can edit <span style="color: #2b2301;">this demo</span> text!</h1>
<ul>
<li style="color: #2e6c80;"><strong style="color: #000000; font-size: 14px;">coś ta</strong></li>
<li style="color: #2e6c80;"><strong style="color: #000000; font-size: 14px;">tu cos<br />&nbsp;</strong></li>
</ul>
', ' html 2 ', TRUE, 1,  ' Artur ',  CURRENT_TIMESTAMP),
(4, '4 Co to html? ', ' html ', ' 
<h1 style="color: red;">You can edit <span style="color: #2b2301;">this demo</span> text!</h1>
<ul>
<li style="color: #2e6c80;"><strong style="color: #000000; font-size: 14px;">coś ta</strong></li>
<li style="color: #2e6c80;"><strong style="color: #000000; font-size: 14px;">tu cos<br />&nbsp;</strong></li>
</ul>
', ' html 2 ', TRUE, 1,  ' Artur ',  CURRENT_TIMESTAMP) ;

-- examles questions lists linked with users
INSERT INTO QUESTIONS_LIST (ID, DESCRIPTION, NAME )
VALUES (1, 'Za pomocą tych pytań planuję nauczyć się podstaw JAVA do końca roku', 'JAVA podstawy');

INSERT INTO USER (ID, ACTIVE , OPEN_ID )
VALUES (1, TRUE, '50420334');
INSERT INTO USER (ID, ACTIVE , OPEN_ID )
VALUES (2, TRUE, '50420335');

INSERT INTO QUESTIONS_LIST_USERS (USERS_ID , QUESTIONS_LIST_ID )
VALUES (1, 1);











