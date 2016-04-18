
DROP TABLE customer;
DROP TABLE orderlines;
DROP TABLE orders;
DROP TABLE products;
DROP TABLE dates;


CREATE TABLE customer (
    customerid integer NOT NULL,
    firstname character varying(50) NOT NULL,
    lastname character varying(50) NOT NULL,
    address1 character varying(50) NOT NULL,
    address2 character varying(50),
    city character varying(50) NOT NULL,
    state character varying(50),
    zip integer,
    country character varying(50) NOT NULL,
    region smallint NOT NULL,
    email VARCHAR(320),
    phone character varying(50),
    creditcardtype integer NOT NULL,
    creditcard character varying(50) NOT NULL,
    creditcardexpiration character varying(50) NOT NULL,
    age smallint,
    income integer,
    gender character varying(1)
);

CREATE TABLE orderlines (
    orderlineid integer NOT NULL,
    orderid integer NOT NULL,
    prod_id integer NOT NULL,
    quantity smallint NOT NULL,
    orderdateid integer NOT NULL,
		DODAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAÆ customerid
);

CREATE TABLE orders (
    orderid integer NOT NULL,
    orderdateid integer NOT NULL,
    customerid integer,
    netamount numeric(12,2) NOT NULL,
    tax numeric(12,2) NOT NULL,
    totalamount numeric(12,2) NOT NULL
);

CREATE TABLE products (
    prod_id integer NOT NULL,
    category integer NOT NULL,
    title character varying(50) NOT NULL,
    actor character varying(50) NOT NULL,
    price numeric(12,2) NOT NULL,
    special smallint
);


CREATE TABLE dates(
	date_id integer NOT NULL,
	day integer,
	month integer,
	year integer
);

ALTER TABLE customer
	ADD CONSTRAINT PK_customer PRIMARY KEY(customerid);

ALTER TABLE orders
	ADD CONSTRAINT PK_orders PRIMARY KEY(orderid);

ALTER TABLE products
	ADD CONSTRAINT PK_products PRIMARY KEY(prod_id);

	

ALTER TABLE orderlines
	ADD CONSTRAINT FK_orderlines1 FOREIGN KEY (orderid) REFERENCES orders (orderid),
	CONSTRAINT FK_orderlines2 FOREIGN KEY (prod_id) REFERENCES products (prod_id),
	CONSTRAINT PK_orderlines PRIMARY KEY (orderlineid, orderid, prod_id),
	CONSTRAINT FK_orders_dates FOREIGN KEY (orderdateid) REFERENCES dates (date_id);

ALTER TABLE orders
	ADD CONSTRAINT FK_orders_customer FOREIGN KEY (customerid) REFERENCES customer (customerid),
	CONSTRAINT FK_orders_dates FOREIGN KEY (orderdateid) REFERENCES dates (date_id);
	

ALTER TABLE dates
	ADD CONSTRAINT PK_dates PRIMARY KEY (date_id);



