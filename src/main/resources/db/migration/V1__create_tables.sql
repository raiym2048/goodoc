 create table medicine (count integer, id bigserial not null, take_time_id bigint, type_id bigint, name varchar(255), primary key (id))
    ; create table medicine_type (id bigserial not null, name varchar(255), primary key (id))
    ; create table take_time (count_dose integer, day_id bigint, first_dose_time timestamp(6), id bigserial not null, primary key (id))
    ; create table take_time_day (id bigserial not null, name varchar(255), primary key (id))
    ; create table users (is_active boolean, role smallint check (role between 0 and 1), id bigserial not null, email varchar(255), password varchar(255), primary key (id))
    ; create table users_medicines (medicines_id bigint not null unique, user_id bigint not null)
    ; create table users_taken_medicine (taken_medicine_id bigint not null unique, user_id bigint not null);