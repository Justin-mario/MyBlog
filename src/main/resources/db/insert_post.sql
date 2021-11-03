set foreign_key_checks=0;

truncate table post;
truncate table comment;


insert into post(`id`, `title`, `body`)
values(10, 'first post', 'testing my blog'),
      (11, 'welcome', 'welcome to my blog');



set foreign_key_checks=1;