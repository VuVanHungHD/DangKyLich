create database Nhom7_DKLICH
use Nhom7_DKLICH
GO

create TABLE QuanLy
(
	maAdmin nvarchar(15) primary key,
	tenAdmin nvarchar(20),
	matKhau nvarchar(15)
	
)
drop table QuanLy

create table MONHOC
(
	maMon nvarchar(20) primary key,
	tenMon nvarchar(20),
	soTC int
)

create table GV
(
	maGV nvarchar(20) primary key,
	tenGV nvarchar(20),
	matKhau nvarchar(15)
)
CREATE TABLE LOP
(
	maLop nvarchar(20) primary key,
	tenLop nvarchar(15),
	maGV nvarchar(20),
	maMon nvarchar(20),
	foreign key(maGV) references GV(maGV) on update cascade on delete cascade,
	foreign key(maMon) references MONHOC(maMon) on update cascade on delete cascade,
	soLuongSV int
)

create table PHONG
(
	maPhong nvarchar(20) primary key,
	tenPhong nvarchar(25),
	heDieuHanh nvarchar(15),
	RAM nvarchar(5),
	CPU nvarchar(10),
	soMay int
)

create table LICH_PHONG
(
	maDK int not null identity primary key,
	nhom nvarchar(10),
	maLop nvarchar(20),
	tuan int,
	thu int,
	maPhong nvarchar(20),
	ca int,
	foreign key(maLop) references LOP(maLop) on update cascade on delete cascade,
	foreign key(maPhong) references PHONG(maPhong) on update cascade on delete cascade,
	unique(tuan,thu,ca,maPhong)
)
drop table LICH_PHONG
drop table PHONG
drop table GV
drop table MONHOC
drop table LOP
------------------------Lệnh insert dữ liệu------------------------
--tk quản lý
insert into QuanLy values ('Admin',N'Admin','123')
--dữ liệu giáo viên
insert into GV (maGV,tenGV,matKhau) values ('hung', N'Vũ Văn Hùng', '123')
insert into GV (maGV,tenGV,matKhau) values ('hungnm', N'Nguyễn Mạnh Hùng', '123')
insert into GV (maGV,tenGV,matKhau) values ('hungnt', N'Nguyễn Trọng Hưng', '123')

--insert Môn học
insert into MONHOC (maMon,tenMon,SoTC) values ('LTJ',N'Lập trình java',1)
insert into MONHOC (maMon,tenMon,SoTC) values ('LTW',N'Lập trình web',1)
insert into MONHOC (maMon,tenMon,SoTC) values ('TKW',N'Thiết kế web',2)
--chèn dl lop
insert into LOP(maLop,tenLop,maGV,maMon,soLuongSV) values('2','LT1','hungnt','TKW',35)
insert into LOP(maLop,tenLop,maGV,maMon,soLuongSV) values('3','LT.2','hung','LTW',35)
insert into LOP(maLop,tenLop,maGV,maMon,soLuongSV) values('4','LT.5','hungnm','LTJ',70)
--chèn dl Phong
insert into Phong values ('TH1', N'Thực hành 1', 'Windows 10','16GB','i5-10900HK',35)
insert into Phong values ('TH2', N'Thực hành 2', 'Windows 10','8GB','i5-10900HK',35)
insert into Phong values ('TH3', N'Thực hành 3', 'Windows 10','12GB','i5-10900HK',35)
--chèn dl lich_phong
insert into LICH_PHONG values('2N','4', 5,2 ,'TH1', 2)
insert into LICH_PHONG values('1N','2', 6,4 ,'TH2', 1)
insert into LICH_PHONG values('1N','3', 7,8 ,'TH3', 3)
-------------------------------------------Kết thúc chèn------------------------------------------
select * from QuanLy
select * from LOP
select * from MONHOC
select * from GV
select * from PHONG
select * from LICH_PHONG
insert into Phong values ('TH5', N'Thực hành 5', 'Windows 10','16GB','i5-10900HK',35)
insert into LICH_PHONG values('123r','2N','1','143','123',15,3,'TH5','2')
insert into LICH_PHONG values('123','2N','1','CNTT6','12',12,3,'TH5','2')
select MONHOC.maMon,PHONG.tenPhong from MONHOC inner join LICH_PHONG ON MONHOC.maMon= LICH_PHONG.maMon INNER JOIN PHONG ON LICH_PHONG.maPhong= PHONG.maPhong
insert into QuanLy values ('Admin',N'Admin','123')
select LOP.maLop,nhom,LOP.soLuongSV,MONHOC.tenMon,GV.tenGV,tuan,thu,PHONG.tenPhong,ca from LICH_PHONG inner join LOP  ON LOP.maLop= LICH_PHONG.maLop inner join MONHOC ON LOP.maMon= MONHOC.maMon inner join GV on LOP.maGV= GV.maGV inner join PHONG ON LICH_PHONG.maPhong= PHONG.maPhong

----
insert into LOP values('IT06','F001.1','1','123',74)
select * from LOP inner join GV on LOP.maGV= GV.maGV where maLop='it0'
select maLop,LOP.tenLop,MONHOC.tenMon,GV.tenGV,count(*) from LOP inner join LICH_PHONG on LOP.maLop= LICH_PHONG.maLop
inner join GV on LOP.maGV=GV.maGV inner join MONHOC on LOP.maMon= MONHOC.maMon
group by LICH_PHONG.maLop

---
select LICH_PHONG.maLop,LOP.tenLop,MONHOC.tenMon,GV.tenGV,count(*) from LOP inner join LICH_PHONG on LOP.maLop= LICH_PHONG.maLop inner join GV on LOP.maGV=GV.maGV inner join MONHOC on LOP.maMon= MONHOC.maMon group by LICH_PHONG.maLop,LOP.tenLop,MONHOC.tenMon,GV.tenGV
---
select LICH_PHONG.malop,LOP.tenLop,COUNT(*) from  LOP inner join LICH_PHONG on LOP.maLop= LICH_PHONG.maLop
inner join GV on LOP.maGV=GV.maGV inner join MONHOC on LOP.maMon= MONHOC.maMon
GROUP BY LICH_PHONG.malop,LOP.tenLop

---
