ALTER TABLE customer
	ADD CONSTRAINT PK_customer PRIMARY KEY(customerid);

ALTER TABLE orders
	ADD CONSTRAINT PK_orders PRIMARY KEY(orderid);

ALTER TABLE products
	ADD CONSTRAINT PK_products PRIMARY KEY(prod_id);

ALTER TABLE customer_hist
	ADD CONSTRAINT FK_CUSTHIST1 FOREIGN KEY (customerid) REFERENCES customer (customerid),
	CONSTRAINT FK_CUSTHIST2 FOREIGN KEY (orderid) REFERENCES orders (orderid),
	CONSTRAINT FK_CUSTHIST3 FOREIGN KEY (prod_id) REFERENCES products (prod_id);

ALTER TABLE customer_hist
	ADD ID INT IDENTITY(1,1),
	CONSTRAINT PK_CUSTHIST PRIMARY KEY (ID);


ALTER TABLE inventory
	ADD CONSTRAINT FK_inventory FOREIGN KEY (prod_id) REFERENCES products (prod_id);
	

ALTER TABLE orderlines
	ADD CONSTRAINT FK_orderlines1 FOREIGN KEY (orderid) REFERENCES orders (orderid),
	CONSTRAINT FK_orderlines2 FOREIGN KEY (prod_id) REFERENCES products (prod_id),
	CONSTRAINT PK_orderlines PRIMARY KEY (orderlineid, orderid, prod_id);

ALTER TABLE orders
	ADD CONSTRAINT FK_orders_customer FOREIGN KEY (customerid) REFERENCES customer (customerid);

ALTER TABLE dates
	ADD CONSTRAINT PK_dates PRIMARY KEY (date_id);

