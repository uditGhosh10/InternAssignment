
/*Creating Tables*/

create table products(
product_id int not null,
product_name varchar(50) not null,
product_category varchar(50) not null,
PRIMARY KEY (product_id)
);


/*end date is not mandatory to ensure that current price has no end date*/
create table product_price_history(
id int not null,
product_id int not null,
price double not null,
start_date date not null,
end_end date,
FOREIGN KEY (product_id) REFERENCES products(product_id)
);


/*Join Operation*/
select * from product_price_history pph ,products p where p.product_id = pph.product_id; 


/*SAMPLE OPTIONAL INSERTION QUERIES
INSERT INTO products VALUES (1, 'A','Categ');
INSERT INTO products VALUES (2, 'B','Categ');
INSERT INTO products VALUES (3, 'C','Categ');
INSERT INTO products VALUES (4, 'D','Categ');

select * from products;
INSERT INTO product_price_history VALUES (1,1,10,'1964-02-16','1964-03-16');
INSERT INTO product_price_history VALUES (2,2,100,'1965-02-16','1965-03-16');
INSERT INTO product_price_history VALUES (3,2,140,'1965-04-16','1966-03-16');
INSERT INTO product_price_history VALUES (4,1,120,'1966-02-16','1967-03-16');
INSERT INTO product_price_history VALUES (5,1,120,'1966-02-16',null);

select * from product_price_history;
*/