create table menu_like(
	m_name varchar2(20 char) primary key,
	m_img varchar2(20 char) not null
);

create sequence menu_like_seq;

select * from menu_like;

drop table menu_like cascade constraint purge;