# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table book (
  id                        bigint not null,
  name                      varchar(255),
  edition                   varchar(255),
  isbn                      bigint,
  price_new                 bigint,
  constraint pk_book primary key (id))
;

create table offer (
  id                        bigint not null,
  condition                 varchar(255),
  price                     bigint,
  student_id                bigint,
  book_id                   bigint,
  constraint pk_offer primary key (id))
;

create table request (
  id                        bigint not null,
  condition                 varchar(255),
  price                     bigint,
  student_id                bigint,
  book_id                   bigint,
  constraint pk_request primary key (id))
;

create table student (
  id                        bigint not null,
  name                      varchar(255),
  email                     varchar(255),
  constraint pk_student primary key (id))
;

create sequence book_seq;

create sequence offer_seq;

create sequence request_seq;

create sequence student_seq;

alter table offer add constraint fk_offer_student_1 foreign key (student_id) references student (id) on delete restrict on update restrict;
create index ix_offer_student_1 on offer (student_id);
alter table offer add constraint fk_offer_book_2 foreign key (book_id) references book (id) on delete restrict on update restrict;
create index ix_offer_book_2 on offer (book_id);
alter table request add constraint fk_request_student_3 foreign key (student_id) references student (id) on delete restrict on update restrict;
create index ix_request_student_3 on request (student_id);
alter table request add constraint fk_request_book_4 foreign key (book_id) references book (id) on delete restrict on update restrict;
create index ix_request_book_4 on request (book_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists book;

drop table if exists offer;

drop table if exists request;

drop table if exists student;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists book_seq;

drop sequence if exists offer_seq;

drop sequence if exists request_seq;

drop sequence if exists student_seq;

