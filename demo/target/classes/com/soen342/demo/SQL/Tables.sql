CREATE TABLE timeslot(
	timeslot_id SERIAL PRIMARY KEY,
	weekday INT CHECK (weekday BETWEEN 0 AND 6),
	start_time TIME,
	end_time TIME,
	activity VARCHAR(50),
	CONSTRAINT unique_grouping UNIQUE (weekday, start_time, end_time)  -- composite primary key
);
CREATE TABLE season(
	season_id SERIAL PRIMARY KEY,
	start_date DATE,
	end_date DATE,
	timeslot_id INT,
	FOREIGN KEY(timeslot_id)
		REFERENCES timeslot(timeslot_id)
	
);
CREATE TABLE schedule(
	schedule_id SERIAL,
	season_id INT,
	opening_hours TIME,
	closing_hours TIME,
	FOREIGN KEY (season_id) REFERENCES season(season_id),
	PRIMARY KEY(schedule_id, season_id)
);

CREATE TABLE instructor(
	instructor_id SERIAL PRIMARY KEY,
	phone_number CHAR(15),
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	city_name VARCHAR(50),
	specialization_name VARCHAR(50),
	schedule_id INT,
	season_id INT,
	password char(50),
	FOREIGN KEY(schedule_id, season_id) REFERENCES schedule(schedule_id, season_id),
	CONSTRAINT unique_phoneNumber unique (phone_number)
);
CREATE TABLE location_(
	location_id SERIAL PRIMARY KEY,
	address VARCHAR(100),
	city VARCHAR(50),
	location_name VARCHAR(100),
	CONSTRAINT unique_location 	unique (address, city, location_name)
);
create table client(
	client_id SERIAL PRIMARY KEY,
	age INT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	phone_number CHAR(50),
	guardian_phone_number char(50),
	password_ char(50),
	CONSTRAINT unique_phone_number UNIQUE(phone_number),
	foreign key(guardian_phone_number) references client(phone_number)
);
create table lesson(
	lesson_id serial primary key,
	location_id INT,
	timeslot_id INT,  
	mode_ VARCHAR(25),
	status INT,
	capacity INT,
	lessonName VARCHAR(50),
	foreign key(timeslot_id) REFERENCES timeslot(timeslot_id),
	foreign key(location_id) references location_(location_id)
);
create table offering(
	offering_id SERIAL PRIMARY KEY,
	lesson_id INT,
	instructor_id INT,
	foreign key(lesson_id) references lesson(lesson_id),
	foreign key(instructor_id) references instructor(instructor_id)
	
);
create table booking(
	booking_id SERIAL PRIMARY KEY, 
	offering_id INT,
	client_id INT,
	is_available BOOLEAN DEFAULT TRUE,
	foreign key(offering_id) references offering(offering_id),
	FOREIGN KEY(client_id) references client(client_id)
);