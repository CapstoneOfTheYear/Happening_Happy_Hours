USE h3_db;

insert into businesses (id, city, corn_hole, darts, dogs_allowed, ending_hour, karaoke, live_music, location,
                        name, other_games, pool, postal_code, serves_food, starting_hour, state, images)
values (1,'San Antonio', 1, 0, 1, '7', 0, 0,  '2720 McCullough Ave', 'Barbaro', 'Beer pong', 0, '78212', 1, '4', 'TX',  'https://images.squarespace-cdn.com/content/v1/56940cbc1c121086a88650cd/1600192703037-XB9I9UWBMW0V7QXXF4OP/KB2A0771.jpg?format=1500w'),
       (2, 'San Antonio',0, 1, 1, '6', 1, 0, '155 E Commerce St', 'The Esquire Tavern', 'None',1 ,'78205', 0, '3', 'TX', 'https://www.esquiretavern-sa.com/wp-content/uploads/2020/03/logo.svg'),
       (3, 'San Antonio', 1,1,0, '7', 0, 1, '5800 Broadway', 'Paloma Blanca Mexican Cuisine', 'Jenga',1, '78209', 1, '4', 'TX', 'https://1cjzwsqowz02w7k0t4ckfcmy-wpengine.netdna-ssl.com/wp-content/uploads/2020/08/New-Hi-Res-Paloma-Blanca-Logo-Vertical.jpg'),
       (4, 'San Antonio', 0, 1, 1, '6', 1, 0, '5115 Fredricksburg Rd', 'Sangria on the Burg', 'None', 0,'78229', 0, '4', 'TX', 'http://images.squarespace-cdn.com/content/v1/57659d5f37c58132dab7e5ca/1467122966751-V1UATFYGGLPKWABILYR4/Sangria+Logo+-+Color.png?format=1500w'),
       (5, 'San Antonio', 1, 1, 1, '7', 0, 0, '3506 N St Marys St', 'Bombay Bicycle Club', 'Skee ball', 0, '78212', 1, '3','TX', 'https://static.spotapps.co/web/bombaybicycleclubsa--com/custom/logo.png'),
       (6, 'San Antonio', 0, 0, 1, '6', 0, 1, '709 S Alamo St', 'Azuca Nuevo Latino', 'None', 1, '78205', 1, '4', 'TX', 'https://www.azuca.net/assets/images/logo3.png'),
       (7, 'Newport Beach', 0, 0, 0, '7', 1, 1, '251 Pacific Coast Hwy', 'SOL Mexican Cocina', 'Frog races', 0, '92660', 0, '5', 'CA', 'https://solcocina.com/wp-content/themes/sol-mexican-cocina/dist/images/logo--color.png'),
       (8, 'San Clemente', 1, 0, 1, '6', 0, 1, '156 Avenida Del Mar', 'The Cellar', 'None', 0, '92672', 0, '4','CA', 'https://thecellarsite.com/assets/media/on_page_element/cellar-logo.svg');


insert into h3_db.user (email, owns_business, password, username)
values ('you@noSpace.org', 0, 'codeup', 'Foodie210'),
       ('wowThatSoundsConfusing@gmail.com', 1, 'green', 'CharlesInCharge');

insert into reviews (body, score, business_id, user_id)
values ('Gross food, nice servers', 3, 1, 2),
       ('Nice!', 5, 2, 1),
       ('Good stuff', 4, 1, 1),
       ('Delicious-ish', 3, 3, 2),
       ('Smells like roaches in there...and tastes like them too', 2, 8, 1),
       ('Love this place, the atmosphere is perfecto!', 5, 7, 2),
       ('2pac ate here once, he had pancakes!', 5, 6, 1),
       ('The waitress tried to poison me', 1, 5, 2),
       ('The restrooms were very clean.', 4, 4, 1);


