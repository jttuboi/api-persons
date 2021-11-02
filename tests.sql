/*

para criar conexão postgres com o glassfish para fazer deploy
https://www.hildeberto.com/2010/02/creating-a-connection-pool-to-postgresql-on-glassfish-v3.html

https://www.enterprisedb.com/postgres-tutorials/how-connect-postgres-database-using-eclipse-and-netbeans

{
	"id": 1,
	"name": "jao",
	"birthday": "DD/MM/YYYY", YYYY-MM-DDThh:mm:ss.sssZ
	"gender": "f",
	"address": "rua abcd",
	"picture": "ksh987w0yt9bwu40gt9k834"
}

SELECT * FROM persons

DROP TABLE persons;

CREATE TABLE persons (
	id INTEGER PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	birthday VARCHAR(10) NOT NULL,
	gender VARCHAR(1) NOT NULL,
	address VARCHAR(255) NOT NULL,
	picture bytea
);

INSERT INTO persons (id, name, birthday, gender, address) VALUES (1, 'maria', '01/02/1999', 'f', 'rua santa');
INSERT INTO persons (id, name, birthday, gender, address) VALUES (2, 'pedro', '31/12/2000', 'm', 'rua demo');
INSERT INTO persons (id, name, birthday, gender, address) VALUES (3, 'zeca', '25/04/2000', 'm', 'rua estquina');
INSERT INTO persons (id, name, birthday, gender, address) VALUES (4, 'luisa', '13/07/2000', 'f', 'rua lateral');


DELETE FROM persons p WHERE p.id = -1;

SELECT * FROM persons;

procura pelo nome do schema
select * from pg_tables where tablename like '%persons%';

procura pelo nome da tabela
SELECT current_database();



*/
