CREATE TABLE `board` (
`seq`		int auto_increment primary key ,
`writer`	varchar(20) NOT NULL,
`title`		varchar(100) NOT NULL,
`content`	mediumtext ,
`pwd`		varchar(20) NOT NULL,
`hit`		decimal(5,0) NOT NULL,
`groups`	decimal(10,0) NOT NULL,
`step`		decimal(3,0) NOT NULL,
`level`		decimal(3,0) NOT NULL,
`bname`		varchar(10) NOT NULL,
`regdate`	datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=euckr;