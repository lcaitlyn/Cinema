
create schema if not exists cinema;

create table if not exists cinema.hall
(
    id    serial unique not null,
    seats integer not null
);

create table if not exists cinema.movie
(
    id           serial primary key,
    name         varchar(256),
    release_date date,
    age_limit    integer,
    description  text
);

create table if not exists cinema.moviesession
(
    id          serial primary key,
    time        timestamp,
    price       integer,
    hall_id     integer references cinema.hall (id),
    movie_id    integer references cinema.movie (id)
);