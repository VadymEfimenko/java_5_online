insert into users (id, first_name, last_name)
values
    (1, 'vadim', 'efimenko'),
    (2, 'fedir', 'galushko'),
    (3, 'efim', 'vadimenko');

insert into accounts (id, balance, number, user_id)
values
    (1, 1000, 2486, 1),
    (2, 1000, 1234, 1),
    (3, 1000, 3321, 2),
    (4, 1000, 6435, 2),
    (5, 1000, 3424, 3),
    (6, 1000, 3433, 3);