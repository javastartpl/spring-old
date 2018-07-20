INSERT INTO accounts(username,password,enabled)
VALUES ('jan','{noop}jan123', true);

INSERT INTO accounts(username,password,enabled)
VALUES ('ania','{noop}Asdf1234', true);

INSERT INTO roles (username, authority)
VALUES ('jan', 'ROLE_USER');

INSERT INTO roles (username, authority)
VALUES ('jan', 'ROLE_ADMIN');

INSERT INTO roles (username, authority)
VALUES ('ania', 'ROLE_USER');