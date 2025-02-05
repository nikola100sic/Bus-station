INSERT INTO `busstation`.`user` (`id`, `name`,`surname`,`e_mail`,`password`, `username`, `user_role`, `is_email_verified`, `token`) VALUES ('1','Nikola','Stosic','nikola@nikola' ,'$2a$10$leAXJYphj5ZuzUeI8/xF4Oe6sW7D/u8KlbVGgLFw6BkXxjrzlYWeq', 'dzoni', 'ADMIN',1, '1233');
INSERT INTO `busstation`.`user` (`id`, `name`,`surname`,`e_mail`,`password`, `username`, `user_role`, `is_email_verified`, `token`) VALUES ('2','Petar','Stosic','petar@petar' ,'$2a$10$rGFzFTHsScJ4X8SU5/9CweD07SeX67/GxRUHWnKLnUEaUPx/rgOsC', 'rope', 'USER', 1, '123');


INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('1', 'Zeleznicka 22', 'nstravel@gmail.com', 'NS Travel', '021 345 233');
INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('2', 'Njegoseva 28', 'nikolaTurs@gmail.com', 'Nikola turs', '018 345 443');
INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('3', 'Dositejeva 72', 'globus@gmail.com', 'Globus Travel', '011 673 233');
INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('4', 'Jovana Cvijica 2', 'nisexpres@gmail.com', 'Nis express', '018 145 233');
INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('5', ' Njegoseva 12', 'barbados@gmail.com', 'Barbados', '021 781 121');
INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('6', 'Kraljevica Marka 45', 'travelend@gmail.com', 'Travelend', '018 674 234');
INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('7', 'Nikole Tesle 87', 'nntransport@gmail.com', 'Nn transport', '018 754 532');

INSERT INTO `busstation`.`line` (`number_of_seats`, `price`, `departure_time`, `id`, `departure`, `destination`) VALUES ('33', '20', '2024-12-29 13:00', '1', 'Nis', 'Novi Sad');
INSERT INTO `busstation`.`line` (`number_of_seats`, `price`, `departure_time`, `id`, `departure`, `destination`) VALUES ('33', '20', '2024-12-29 18:00', '2', 'Novi Sad', 'Nis');
INSERT INTO `busstation`.`line` (`number_of_seats`, `price`, `departure_time`, `id`, `departure`, `destination`) VALUES ('30', '11', '2024-12-29 11:00', '3', 'Beograd', 'Novi Sad');
INSERT INTO `busstation`.`line` (`number_of_seats`, `price`, `departure_time`, `id`, `departure`, `destination`) VALUES ('53', '12', '2024-12-29 17:00', '4', 'Novi Sad', 'Beograd');

INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('1', '1');
INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('2', '2');
INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('3', '3');
INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('4', '4');
INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('2', '1');


