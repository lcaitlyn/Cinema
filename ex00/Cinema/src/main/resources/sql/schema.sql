
create schema if not exists cinema;

create table if not exists cinema.hall
(
    id    serial unique not null,
    seats integer not null
);

create table if not exists cinema.movie
(
    id           serial primary key,
    name         varchar(256) not null ,
    release_date date not null ,
    age_limit    integer not null ,
    movie_image_id  integer references cinema.movie_image (id) not null ,
    description  text
);

create table if not exists cinema.movie_session
(
    id          serial primary key,
    time        timestamp not null ,
    price       integer not null ,
    hall_id     integer references cinema.hall (id) not null ,
    movie_id    integer references cinema.movie (id) not null
);

create table if not exists cinema.movie_image
(
    id          varchar(256) primary key ,
    type        varchar(64) not null
)