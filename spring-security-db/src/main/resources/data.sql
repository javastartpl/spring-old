INSERT INTO accounts(username,password,enabled)
VALUES ('jan','jan123', true);

INSERT INTO accounts(username,password,enabled)
VALUES ('ania','Asdf1234', true);

INSERT INTO roles (username, authority)
VALUES ('jan', 'ROLE_USER');

INSERT INTO roles (username, authority)
VALUES ('jan', 'ROLE_ADMIN');

INSERT INTO roles (username, authority)
VALUES ('ania', 'ROLE_USER');