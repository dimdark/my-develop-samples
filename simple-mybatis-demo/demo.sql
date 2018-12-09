use `simple_mybatis_demo`;

create table `country` (
    `id` int not null auto_increment,
    `country_name` varchar(255) null,
    `country_code` varchar(255) null,
    primary key (`id`)
);

insert country(`country_name`, `country_code`)
values ('中国', 'CN'), ('美国', 'US'), ('俄罗斯', 'RU'), ('英国', 'GB'), ('法国', 'FR');