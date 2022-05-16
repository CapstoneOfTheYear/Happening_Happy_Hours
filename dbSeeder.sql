USE h3_db;

INSERT INTO h3_db.businesses (id, city, location, name, postal_code, state, starting_hour, ending_hour)
values(1,'San Antonio', '2720 McCullough Ave', 'Barbaro', '78212', 'TX', '4', '6'),
      (2, 'San Antonio', '155 E Commerce St', 'The Esquire Tavern', '78205', 'TX', '3', '7'),
      (3, 'San Antonio', '5800 Broadway', 'Paloma Blanca Mexican Cuisine', '78209', 'TX', '4', '7'),
      (4, 'San Antonio', '5115 Fredricksburg Rd', 'Sangria on the Burg', '78229', 'TX', '3', '6'),
      (5, 'San Antonio', '3506 N St Marys St', 'Bombay Bicycle Club', '78212', 'TX', '4', '7'),
      (6, 'San Antonio', '709 S Alamo St', 'Azuca Nuevo Latino', '78205', 'TX', '4', '7'),
      (7, 'Newport Beach', '251 Pacific Coast Hwy', 'SOL Mexican Cocina', '92660', 'CA', '3', '6'),
      (8, 'San Clemente', '156 Avenida Del Mar', 'The Cellar', '92672', 'CA', '3', '5');


insert into h3_db.user (email, owns_business, password, username)
values ('yourMom@hoeSpace.org', 0, 'codeup', 'Foodie210'),
       ('fuckThatSoundsConfusing@gmail.com', 1, 'green', 'CharlesInCharge');

insert into reviews (body, score, business_id, user_id)
values ('Gross food, hot servers', 3, 1, 2),
       ('Nice!', 5, 2, 1),
       ('Good stuff', 4, 1, 1),
       ('hello', 3, 3, 2);

