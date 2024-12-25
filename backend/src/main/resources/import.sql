INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('1', 'Njegoseva 22', 'nstravel@gmail.com', 'NS Travel', '021 345 233');
INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('2', 'Njegoseva 28', 'nikolaTurs@gmail.com', 'Nikola turs', '018 345 443');
INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('3', 'Dositejeva 72', 'globus@gmail.com', 'Globus Travel', '011 673 233');
INSERT INTO `busstation`.`carrier` (`id`, `address`, `e_mail`, `name`, `phone_number`) VALUES ('4', 'Jovana Cvijica 2', 'nisexpres@gmail.com', 'Nis express', '018 145 233');

INSERT INTO `busstation`.`line` (`number_of_seats`, `price`, `departure_time`, `id`, `departure`, `destination`) VALUES ('33', '20', '2024-12-29 13:00', '1', 'Nis', 'Novi Sad');
INSERT INTO `busstation`.`line` (`number_of_seats`, `price`, `departure_time`, `id`, `departure`, `destination`) VALUES ('33', '20', '2024-12-29 18:00', '2', 'Novi Sad', 'Nis');
INSERT INTO `busstation`.`line` (`number_of_seats`, `price`, `departure_time`, `id`, `departure`, `destination`) VALUES ('30', '11', '2024-12-29 11:00', '3', 'Beograd', 'Novi Sad');
INSERT INTO `busstation`.`line` (`number_of_seats`, `price`, `departure_time`, `id`, `departure`, `destination`) VALUES ('53', '12', '2024-12-29 17:00', '4', 'Novi Sad', 'Beograd');

INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('1', '1');
INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('2', '2');
INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('3', '3');
INSERT INTO `busstation`.`line_carrier` (`carrier_id`, `line_id`) VALUES ('4', '4');

