--liquibase formatted sql
--changeset allan:04
--comment: inserts on table movie and movie theater
INSERT INTO VTE.MOVIE_THEATER(NAME, STREET, CITY, STATE) VALUES('Cinemark West Plaza', 'Av. Antártica, 408 - Água Branca',  'São Paulo', 'SP');
INSERT INTO VTE.MOVIE_THEATER(NAME, STREET, CITY, STATE) VALUES('Espaço Itaú de Cinema - Pompéia', 'Rua Palestra Itália, 500 - Água Branca',  'São Paulo', 'SP');
INSERT INTO VTE.MOVIE_THEATER(NAME, STREET, CITY, STATE) VALUES('Cinemark Shopping Cidade São Paulo', 'Avenida Paulista, 1230 - Bela Vista',  'São Paulo', 'SP');
--rollback DELETE FROM VTE.MOVIE_THEATER;