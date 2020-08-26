create table work_order (
    id bigint not null auto_increment,
    customer_id bigint not null,
    description text not null,
    cost decimal(10,2) not null,
    status varchar(20) not null,
    date_open datetime not null,
    date_finished datetime,
    primary key (id)
);

alter table work_order add constraint fk_work_order_customer
foreign key (customer_id) references customer (id);