USE h3_db;

INSERT INTO h3_db.businesses (city, location, name, postal_code, state, starting_hour, ending_hour)
values('San Antonio', '2720 McCullough Ave', 'Barbaro', '78212', 'TX', '4', '6'),
      ('San Antonio', '155 E Commerce St', 'The Esquire Tavern', '78205', 'TX', '3', '7'),
      ('San Antonio', '5800 Broadway #300', 'Paloma Blanca Mexican Cuisine', '78209', 'TX', '4', '7');

insert into h3_db.user (email, owns_business, password, username)
values ('yourMom@hoeSpace.org', 0, 'codeup', 'Foodie210'),
       ('fuckThatSoundsConfusing@gmail.com', 1, 'green', 'CharlesInCharge');
