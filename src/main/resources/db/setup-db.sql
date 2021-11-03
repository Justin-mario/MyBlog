create database blogdb;

create user 'admin_user'@'localhost' identified by 'admin123';
grant all privileges on blogdb.* to 'admin_user'@'localhost';
flush privileges;