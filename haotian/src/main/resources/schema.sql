drop table if exists Ingredient cascade;

create table if not exists Ingredient (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
);

drop table if exists Taco cascade;

create table if not exists Taco (
    id identity,
    name varchar(50) not null,
    created_at timestamp not null
);

drop table if exists Taco_Ingredients cascade;

create table if not exists Taco_Ingredients (
    taco_id bigint not null,
    ingredient_id varchar(4) not null
);

alter table Taco_Ingredients
    add foreign key(taco_id) references Taco(id);
alter table Taco_Ingredients
    add foreign key(ingredient_id) references Ingredient(id);

drop table if exists Taco_Order cascade;

create table if not exists Taco_Order(
    id identity,
    name varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state varchar(20) not null,
    zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cccvv varchar(3) not null,
    placed_at timestamp not null
);

drop table if exists Taco_Order_Tacos cascade;

create table if not exists Taco_Order_Tacos (
    order_id bigint not null,
    taco_id bigint not null
);

alter table Taco_Order_Tacos
    add foreign key (order_id) references Taco_Order(id);

alter table Taco_Order_Tacos
    add foreign key (taco_id) references Taco(id);