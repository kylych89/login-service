insert into roles (name, active) values ('Супер администратор', true);
insert into roles (name, active) values ('Администратор', true);

insert into accounts (login, password) values ('sa', '12345');

insert into users (name, active, account_id, role_id) values ('Супер админ', true, 1, 1);

