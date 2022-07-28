create schema hibcourse;
set search_path to hibcourse;

create table universities (id bigserial primary key, title varchar(255));
insert into universities (title) values ('TNU'),('TGPU');

create table students (id bigserial primary key, name varchar(255), university_id bigint references universities(id));
insert into students (name, university_id) values ('Tom', 1),('Jerry', 1),('Butch', 2);

drop table if exists books cascade;
create table books (id bigserial primary key, title varchar(255));
insert into books (title) values
('Don Quixote'),
('The Adventures of Tom Sawyer'),
('Gulliver''s Travels'),
('The Hobbit, or, There and Back Again'),
('Frankenstein, or, the Modern Prometheus'),
('The Return of the King'),
('War and Peace'),
('The Little Prince'),
('Harry Potter and the Sorcerer''s Stone'),
('The Old Man and the Sea'),
('A Journey to the Center of the Earth');

drop table if exists readers cascade;
create table readers (id bigserial primary key, name varchar(255));
insert into readers (name) values
('Spike'),
('Tom'),
('Butch'),
('Jerry'),
('Tike');

drop table if exists books_readers cascade;
create table books_readers (book_id bigint, reader_id bigint, foreign key (book_id) references books (id), foreign key (reader_id) references readers (id), primary key (book_id,reader_id), unique(book_id,reader_id));
insert into books_readers (book_id,reader_id) values
(1,1),
(2,1),
(6,1),
(3,2),
(7,2),
(10,2),
(11,3),
(5,3),
(9,3),
(4,3),
(1,4),
(3,4),
(2,5),
(10,5);