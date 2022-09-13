-- sql

CREATE TABLE `todo` (
                        `tno`	int	NOT NULL auto_increment,
                        `title`	varchar(50)	NOT NULL,
                        `content`	varchar(200)	NOT NULL,
                        `regDate`	Datetime	NOT NULL,
                        `updateDate`	Datetime	NULL,
                        `endDate`	Datetime	NULL,
                        `del_yn`	char(1)	NULL,
                        `mno`	int	NOT NULL,
                        `uno`	int	NOT NULL,
                        primary key (tno),
                        foreign key (mno) references management(mno),
                        foreign key (uno) references user(uno)
);

CREATE TABLE `management` (
                              `mno`	int	NOT NULL auto_increment,
                              `m_name`	varchar(50)	NULL,
                              `uno`	int	NOT NULL,
                              primary key (mno),
                              foreign key (uno) references user(uno)
);

CREATE TABLE `bin` (
                       `uno`	int	NOT NULL,
                       `tno`	int	NOT NULL,
                       primary key (uno, tno),
                       foreign key (uno) references user(uno),
                       foreign key (tno) references todo(tno)

);

CREATE TABLE `user` (
                        `uno`	int	NOT NULL auto_increment,
                        `name`	varchar(50) NOT	NULL,
                        `id`	varchar(50) NOT	NULL,
                        `password`	varchar(100) NOT NULL,
                        `email`	varchar(100) NOT NULL,
                        primary key (uno)
);
