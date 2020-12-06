insert into feedback(id, subject, email, feedback) values
  (1, 'Jan', 'Kowalski', '90101222457'),
  (2, 'Maciej', 'Zalewski', '87112242456'),
  (3, 'Aneta', 'Korczyńska', '76061536749'),
  (4, 'Wojciech', 'Sokolik', '82010877245');

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
  
  
  
   INSERT INTO QUESTION  (ID, QUESTION, BASIC_ANSWER, INTERMEDIATE_ANSWER, ADVANCED_ANSWER, IS_SHOW_IN_ALL_QUESTION, ALL_QUESTIONS_ID, CREATION_BY, CREATION_TIME ) VALUES 
(1, ' Co to int? ', ' Liczbowy typ prosty ', ' Zawiera liczby z przedziału ', ' Niezainicjalizowany przez nas automatycznie przyjmuje wartość 0 przez co nie może być null ', TRUE, 1,  ' Artur ',  CURRENT_TIMESTAMP) ;