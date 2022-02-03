-- CREATE DATABASE RestTest;
-- DROP TABLE IF EXISTS Registry;
DROP TABLE IF EXISTS TV;
DROP TABLE IF EXISTS Computers;
DROP TABLE IF EXISTS Fridge;
DROP TABLE IF EXISTS Smartphone;
DROP TABLE IF EXISTS VacuumCleaner;

CREATE TABLE IF NOT EXISTS TV (
    tv_id serial not null,
    tv_name varchar(64) not null,
    tv_serial_number varchar(64) not null,
    tv_color varchar(64) not null,
    tv_size varchar(64) not null,
    tv_price integer not null,
    tv_category varchar(64) not null,
    tv_technology varchar(64) not null,
    tv_availability varchar(5) not null,
    PRIMARY KEY (tv_id)
);

CREATE TABLE IF NOT EXISTS Computers (
    c_id serial not null,
    c_name varchar(64) not null,
    c_serial_number varchar(64) not null,
    c_color varchar(64) not null,
    c_size varchar(64) not null,
    c_price integer not null,
    c_memory varchar(64) not null,
    c_processor varchar(64) not null,
    c_availability varchar(5) not null,
    PRIMARY KEY (c_id)
);

CREATE TABLE IF NOT EXISTS Fridge (
    f_id serial not null,
    f_name varchar(64) not null,
    f_serial_number varchar(64) not null,
    f_color varchar(64) not null,
    f_size varchar(64) not null,
    f_price integer not null,
    f_door_quantity integer not null,
    f_camera_quantity integer not null,
    f_availability varchar(5) not null,
    PRIMARY KEY (f_id)
);

CREATE TABLE IF NOT EXISTS Smartphone (
    s_id serial not null,
    s_name varchar(64) not null,
    s_serial_number varchar(64) not null,
    s_color varchar(64) not null,
    s_size varchar(64) not null,
    s_price integer not null,
    s_memory integer not null,
    s_camera_quantity integer not null,
    s_availability varchar(5) not null,
    PRIMARY KEY (s_id)
);

CREATE TABLE IF NOT EXISTS VacuumCleaner (
    v_id serial not null,
    v_name varchar(64) not null,
    v_serial_number varchar(64) not null,
    v_color varchar(64) not null,
    v_size varchar(64) not null,
    v_price integer not null,
    v_dust_size integer not null,
    v_mode_quantity integer not null,
    v_availability varchar(5) not null,
    PRIMARY KEY (v_id)
);

-- CREATE TABLE IF NOT EXISTS Registry (
--     id serial not null,
--     Registry_tv_id integer REFERENCES TV (tv_id),
--     Registry_v_id integer REFERENCES VacuumCleaner (v_id),
--     Registry_s_id integer REFERENCES Smartphone (s_id),
--     Registry_f_id integer REFERENCES Fridge (f_id),
--     Registry_c_id integer REFERENCES Computers (c_id),
--     PRIMARY KEY (id)
-- );