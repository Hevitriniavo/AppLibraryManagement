	---- psql -d library_management -a -f create_table_library_management.sql
	CREATE TABLE IF NOT EXISTS  "author" (
	    id SERIAL PRIMARY KEY,
	    name VARCHAR(255) NOT NULL,
	    sex CHAR(1) CHECK(sex IN ('M', 'F')) NOT NULL
	);

	CREATE TABLE IF NOT EXISTS  "book" (
	    id SERIAL 	PRIMARY KEY,
	    book_name VARCHAR(255) NOT NULL,
	    page_numbers INT NOT NULL,
	    release_date DATE NOT NULL,
	    author_id INT REFERENCES "author"(id)
	);

	CREATE TABLE IF NOT EXISTS  "topic" (
	    id SERIAL PRIMARY KEY,
	    book_id INT REFERENCES "book"(id),
	    topic VARCHAR(50) CHECK(topic IN ('ROMANCE', 'COMEDY', 'OTHER')) NOT NULL
	);

	CREATE TABLE IF NOT EXISTS  "subscriber" (
	    id SERIAL PRIMARY KEY,
	    name VARCHAR(255) NOT NULL,
	    reference VARCHAR(255) NOT NULL	
	);

	CREATE TABLE IF NOT EXISTS  "administrator" (
	    id SERIAL PRIMARY KEY,
	    name VARCHAR(255) NOT NULL,
	    role VARCHAR(50) DEFAULT 'ADMIN',
	    email VARCHAR(255) UNIQUE,
	    password VARCHAR(255) NOT NULL,
	    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	);

	CREATE TABLE IF NOT EXISTS  "borrowing" (
	    id SERIAL PRIMARY KEY,
	    subscriber_id INT REFERENCES "subscriber"(id),
	    book_id INT REFERENCES "book"(id),
	    borrowing_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	    return_date TIMESTAMP,
	    administrator_id INT REFERENCES "administrator"(id)
	    CONSTRAINT check_return_date CHECK (return_date IS NULL OR return_date >= borrowing_date)
	);
