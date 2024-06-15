drop database if exists DonationProject;
create database if not exists DonationProject character set utf8mb4 collate utf8mb4_unicode_ci;
use DonationProject;
create table `role`(id int(11) auto_increment,
					primary key(`id`),
					role_name varchar(100));
create table user(id int(11)auto_increment, 
					password varchar(100),
					user_name varchar(100),
                    full_name varchar(100),
                    status int(11) default 1,
                    role_id int(11),
                    email varchar(100),
                    address varchar(255),
                    phone_number varchar(100),
                    is_active boolean default true,
                    primary key(`id`),
                    constraint `fk_user` foreign key(`role_id`) references `role`(id));
create table donation(id int(11) auto_increment,
						code varchar(100),
                        created varchar(100),
                        description varchar(255),
                        end_date varchar(100),
                        money int(11),
                        `name` varchar(100),
                        organization_name varchar(100),
                        phone_number varchar(100),
                        start_date varchar(100),
                        `status` int(11),
                        is_active boolean default true,
                        primary key(`id`));
create table user_donation(id int(11) auto_increment,
							created varchar(100),
                            money int(11),
                            `name` varchar(100),
                            `status` int(11) default 0,
                            text varchar(255),
                            donation_id int(11),
                            user_id int(11),
                            primary key(`id`),
                            constraint `fk_userdonation_donation` foreign key(`donation_id`) references `donation`(id),
                            constraint `fk_userdonation_user` foreign key(`user_id`) references `user`(id));
                        

-- Bảng `role`
INSERT INTO `role` (`role_name`) VALUES
('Admin'),
('User');

-- Bảng `user`
INSERT INTO `user` (`password`, `user_name`, `full_name`, `status`, `role_id`, `email`, `phone_number`) VALUES
('password1', 'user1', 'Quan tri', 1, 1, 'quantri@example.com','0009999101'),
('password6', 'user6', 'Người dùng Sáu', 1, 2, 'user6@example.com', '0123456789'),
('password7', 'user7', 'Người dùng Bảy', 1, 2, 'user7@example.com', '0123456788'),
('password8', 'user8', 'Người dùng Tám', 1, 2, 'user8@example.com', '0123456787'),
('password9', 'user9', 'Người dùng Chín', 1, 2, 'user9@example.com', '0123456786'),
('password10', 'user10', 'Người dùng Mười', 1, 2, 'user10@example.com', '0123456785');
SET SQL_SAFE_UPDATES = 0;
UPDATE `user`
SET `address` = 'Hà Nội'
WHERE `user_name` = 'user1';

UPDATE `user`
SET `address` = 'Hải Phòng'
WHERE `user_name` = 'user6';

UPDATE `user`
SET `address` = 'Hà Tĩnh'
WHERE `user_name` = 'user7';

UPDATE `user`
SET `address` = 'Bình Dương'
WHERE `user_name` = 'user8';

UPDATE `user`
SET `address` = 'Cần Thơ'
WHERE `user_name` = 'user9';

UPDATE `user`
SET `address` = 'Hoàng Sa'
WHERE `user_name` = 'user10';

-- Bảng `donation`
INSERT INTO `donation` (`code`, `created`, `end_date`, `money`, `name`, `organization_name`, `start_date`, `status`) VALUES
('D01', '2024-02-01', '2024-02-28', 1000, 'Donation 1', 'Organization 1', '2024-02-01', 1),
('D02', '2024-03-01', '2024-03-31', 2000, 'Donation 2', 'Organization 2', '2024-03-01', 2),
('D03', '2024-04-01', '2024-04-30', 3000, 'Donation 3', 'Organization 3', '2024-04-01', 3),
('D04', '2024-05-01', '2024-05-31', 4000, 'Donation 4', 'Organization 4', '2024-05-01', 0),
('D05', '2024-06-01', '2024-06-30', 5000, 'Donation 5', 'Organization 5', '2024-06-01', 1);

-- Bảng `user_donation`
INSERT INTO `user_donation` (`created`, `money`, `name`, `status`, `donation_id`, `user_id`) VALUES
('2024-02-01', 100, 'User Donation 1', 1, 1, 1),
('2024-03-01', 200, 'User Donation 2', 1, 2, 2),
('2024-04-01', 300, 'User Donation 3', 1, 3, 3),
('2024-05-01', 400, 'User Donation 4', 1, 4, 4),
('2024-06-01', 500, 'User Donation 5', 1, 5, 5);
