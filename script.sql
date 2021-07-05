insert into Book values(1,'Chyngyz Aitmatov','Jamila');
insert into Book values(2,'Herbert Schildt','Java 8');
insert into Book values(3,'Daniel Carnegie','How to won friends and influence people');

insert into genre values(1,'Drama');
insert into genre values(2,'Scientist');
insert into genre values(3,'Self developing');


create table users (
                       id int8 not null,
                       name varchar(255) not null,
                       password varchar(255) not null,
                       primary key (id));

alter table if exists users
    add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name);


create table book (
                      id int8 not null,
                      author varchar(255) not null,
                      title varchar(255) not null,
                      user_id int8, primary key (id));

alter table if exists book
    add constraint FK9cv1tt952k857xoia51k1vj12 foreign key (user_id) references users;

create table genre (
                       id int8 not null,
                       name varchar(255) not null,
                       user_id int8,
                       primary key (id));

    alter table if exists genre
    add constraint FKfd6abe7jvsw0jiubsmge9q3hk foreign key (user_id) references users;

create table genres_book (
                             book_id int8 not null,
                             genre_id int8 not null,
                             primary key (book_id, genre_id));

alter table if exists genres_book
    add constraint FKmhavpyl0x9gcu2db3r2vxmrcn foreign key (genre_id) references genre;

alter table if exists genres_book
    add constraint FK5dxgw5tdenyr67t02i855ggwh foreign key (book_id) references book;
