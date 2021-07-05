
    alter table if exists genres_book drop constraint if exists FKmhavpyl0x9gcu2db3r2vxmrcn;

    alter table if exists genres_book drop constraint if exists FK5dxgw5tdenyr67t02i855ggwh;

    drop table if exists book cascade;
    drop table if exists genre;
    drop table if exists genres_book cascade;
    drop table if exists users cascade;
    drop sequence if exists hibernate_sequence;

    create sequence hibernate_sequence start 1 increment 1;

    create table book (
        id int8 not null,
        author varchar(255) not null,
        title varchar(255) not null,
        primary key (id));

    create table genre (
        id int8 not null,
        name varchar(255) not null,
        primary key (id));

    create table genres_book (
        book_id int8 not null,
        genre_id int8 not null,
        primary key (book_id, genre_id));

    create table users (
        id int8 not null,
        name varchar(255) not null,
        password varchar(255) not null,
        primary key (id));

    alter table if exists users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name);
    alter table if exists genres_book add constraint FKmhavpyl0x9gcu2db3r2vxmrcn foreign key (genre_id) references genre;
    alter table if exists genres_book add constraint FK5dxgw5tdenyr67t02i855ggwh foreign key (book_id) references book;