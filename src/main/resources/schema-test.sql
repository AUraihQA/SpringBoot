drop table if exists account_domain CASCADE; 
drop table if exists cat_domain CASCADE; 
drop table if exists house_domain CASCADE; 
create table account_domain (id bigint generated by default as identity, account_number varchar(255) not null, name varchar(255), primary key (id));
create table cat_domain (id bigint generated by default as identity, age integer not null, name varchar(255), speech_volume integer, my_house_id bigint, primary key (id));
create table house_domain (id bigint generated by default as identity, address varchar(255), primary key (id));
alter table account_domain add constraint UK_csukq7eiroyvs4tcywvxcp2aq unique (account_number);
alter table cat_domain add constraint FKg2wia8mwluf94kesqlkqggrhq foreign key (my_house_id) references house_domain on delete cascade;