 
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
	username VARCHAR(255) NOT NULL,
    birth_date DATE ,
    email VARCHAR(100) NOT NULL
);

create table muscle_group(
	id SERIAL PRIMARY KEY,
	name varchar (100) NOT NULL
);

create table muscle(
	id SERIAL primary key,
	name varchar (100) NOT NULL,
	muscle_group_id INT REFERENCES muscle_group(id)
	
);

CREATE TABLE exercise (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
	description TEXT
    
);

create table exercise_muscle(
	exercise_id INT references exercise(id),
	muscle_id INT references muscle(id),
	PRIMARY KEY (exercise_id,muscle_id )
	
);

CREATE TABLE workout (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    duration INT NOT NULL
);

create table workout_exercise(
	exercise_id INT REFERENCES exercise(id),
	workout_id INT REFERENCES workout(id),
	PRIMARY KEY (exercise_id,workout_id)
);

CREATE TABLE user_progress (
    id SERIAL PRIMARY KEY,
	user_weight DECIMAL(5,2) NOT NULL,
    date DATE NOT NULL DEFAULT CURRENT_DATE,
    reps INT,
    sets INT,
    weight DECIMAL(5, 2) ,
    user_id INT REFERENCES users(id),
    workout_id INT REFERENCES workout(id),
    exercise_id INT REFERENCES exercise(id)
);



