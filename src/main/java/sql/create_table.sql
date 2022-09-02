create table if not exists role
(
    id          bigserial primary key,
    title       varchar(255) not null,
    description text         not null
);

create table if not exists permission
(
    id          bigserial primary key,
    role_id     int8 references role (id),
    title       varchar(255) not null,
    module      varchar(255) not null,
    description text         not null
);

create table if not exists voting
(
    id          bigserial primary key,

    type        varchar(255) not null,
    description text         not null,
    timing      varchar(255) not null,
    date        date         not null
);

create table if not exists citizen
(
    id       bigserial primary key,
    role_id  int8 references role (id),
    email    varchar(255) not null,
    name     varchar(255) not null,
    address  text         not null,
    dob      date         not null,
    phone    char(11)     not null,
    username varchar(20)  not null,
    password varchar(25)  not null,
    voter_id int8 references voting (id)
);

create table if not exists candidate
(
    id       bigserial primary key,
    role_id  int8 references role (id),
    email    varchar(255) not null,
    address  text         not null,
    name     varchar(255) not null,
    dob      date         not null,
    phone    char(11)     not null,
    username varchar(20)  not null,
    password varchar(25)  not null,
    voter_id int8 references voting (id)
);

create table if not exists polling
(
    id          bigserial primary key,
    name        varchar(255) not null,
    type        varchar(255) not null,
    description text         not null
);

create table if not exists register
(
    id           bigserial primary key,
    name         varchar(255) not null,
    candidate_id int8 references candidate (id),
    citizen_id   int8 references citizen (id),
    type         varchar(255) not null,
    description  text         not null
);

create table if not exists result
(
    id           bigserial primary key,
    candidate_id int8 references candidate (id),
    type         varchar(255) not null,
    description  text         not null,
    date         date         not null
);

alter table voting
    add candidate_id int8 references candidate (id);
alter table voting
    add citizen_id int8 references citizen (id);