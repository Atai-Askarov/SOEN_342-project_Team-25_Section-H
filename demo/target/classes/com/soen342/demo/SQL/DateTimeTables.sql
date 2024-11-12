CREATE TABLE timeslot(
	start_time TIME,
	end_time TIME,
	activity VARCHAR(250),
	PRIMARY KEY (start_time, end_time));
	
CREATE TABLE DaysWeek(
	weekday INT CHECK (weekday BETWEEN 0 AND 6),
	start_time TIME,
	end_time TIME,
	PRIMARY KEY (weekday, start_time, end_time),  -- composite primary key
    FOREIGN KEY (start_time, end_time) REFERENCES timeslot (start_time, end_time)
);

CREATE TABLE season(
	season_id SERIAL PRIMARY KEY,
	start_date DATE,
	end_date DATE,
	weekday INT CHECK (weekday BETWEEN 0 AND 6),
	start_time TIME,
	end_time TIME,
	FOREIGN KEY(weekday, start_time, end_time) 
		REFERENCES DaysWeek(weekday, start_time, end_time)
	
);

CREATE TABLE schedule(
	season_id INT,
	opening_hours TIME,
	closing_hours TIME,
	FOREIGN KEY (season_id) REFERENCES season(season_id)
);
