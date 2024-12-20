
INSERT INTO `busstation`.`user` (`id`, `name`,`surname`,`e_mail`,`password`, `username`, `user_role`, `is_email_verified`, `token`) VALUES ('1','Nikola','Stosic','nikola@nikola' ,'$2a$10$leAXJYphj5ZuzUeI8/xF4Oe6sW7D/u8KlbVGgLFw6BkXxjrzlYWeq', 'dzoni', 'ADMIN',1, '1233');
INSERT INTO `busstation`.`user` (`id`, `name`,`surname`,`e_mail`,`password`, `username`, `user_role`, `is_email_verified`, `token`) VALUES ('2','Petar','Stosic','petar@petar' ,'$2a$10$rGFzFTHsScJ4X8SU5/9CweD07SeX67/GxRUHWnKLnUEaUPx/rgOsC', 'rope', 'USER', 1, '123');

INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('1', 'Novosadska 11', 'novisadtravel@ns.com', 'Novi Sad Travel', '018023945');
INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('2', 'Trg Slobode 2', 'jeremicTravel@jt.com', 'Jeremic Travel', '021848293');
INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('3', 'Njegoseva 22', 'nisexpress@ne.com', 'Nis express', '0238475983');

INSERT INTO `busstation`.`bus` (`capacity`, `carrier_id`, `id`, `plate_number`) VALUES ('15', '1', '1', 'NI-260-NE');
INSERT INTO `busstation`.`bus` (`capacity`, `carrier_id`, `id`, `plate_number`) VALUES ('20', '1', '2', 'NI-240-KK');
INSERT INTO `busstation`.`bus` (`capacity`, `carrier_id`, `id`, `plate_number`) VALUES ('20', '2', '3', 'BG-010-AE');
INSERT INTO `busstation`.`bus` (`capacity`, `carrier_id`, `id`, `plate_number`) VALUES ('20', '3', '4', 'NS-046-KW');


INSERT INTO `busstation`.`line` (`price`, `arrival_time`, `departure_time`, `id`, `departure`, `destination`) VALUES ('3', '2024-12-22 12:00', '2024-12-22 12:30', '1', 'Beograd', 'Beska');
INSERT INTO `busstation`.`line` (`price`, `arrival_time`, `departure_time`, `id`, `departure`, `destination`) VALUES ('3,5', '2024-12-22 12:00', '2024-12-22 12:30', '2', 'Beska', 'Beograd');
INSERT INTO `busstation`.`line` (`price`, `arrival_time`, `departure_time`, `id`, `departure`, `destination`) VALUES ('40', '2024-12-25 06:00', '2024-12-25 10:40', '3', 'Nis', 'Novi Sad');
INSERT INTO `busstation`.`line` (`price`, `arrival_time`, `departure_time`, `id`, `departure`, `destination`) VALUES ('40', '2024-12-26 18:35', '2024-12-25 23:05', '4', 'Novi Sad', 'Nis');
INSERT INTO `busstation`.`line` (`price`, `arrival_time`, `departure_time`, `id`, `departure`, `destination`) VALUES ('34', '2024-12-27 18:00', '2024-12-27 20:30', '5', 'Nis', 'Beograd');
INSERT INTO `busstation`.`line` (`price`, `arrival_time`, `departure_time`, `id`, `departure`, `destination`) VALUES ('34', '2024-12-27 13:00', '2024-12-27 15:30', '6', 'Beograd', 'Nis');

INSERT INTO `busstation`.`line_bus` (`bus_id`, `line_id`) VALUES ('1', '1');
INSERT INTO `busstation`.`line_bus` (`bus_id`, `line_id`) VALUES ('2', '2');
INSERT INTO `busstation`.`line_bus` (`bus_id`, `line_id`) VALUES ('3', '3');
INSERT INTO `busstation`.`line_bus` (`bus_id`, `line_id`) VALUES ('4', '4');
INSERT INTO `busstation`.`line_bus` (`bus_id`, `line_id`) VALUES ('2', '5');
INSERT INTO `busstation`.`line_bus` (`bus_id`, `line_id`) VALUES ('1', '6');

INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('1', '1');
INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('2', '2');
INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('3', '3');
INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('3', '4');
INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('1', '5');
INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('2', '6');
