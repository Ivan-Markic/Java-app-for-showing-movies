create database CinestarDB


GO

use CinestarDB
--Creating tables


create table Movie
(
IDMovie int primary key identity,
Title nvarchar(100),
OriginalTitle nvarchar(100),
Description nvarchar(1000),
Length int,
Genre nvarchar(100),
Link nvarchar(300),
PublishedDate nvarchar(100),
PathToPicture nvarchar(100),
)

GO

--Ako je 0 onda je Actor ako je 1 onda je Director

create table Person
(
IDPerson int primary key identity,
Name nvarchar(50),
Surname nvarchar(50),
Position bit,
MovieID int foreign key references Movie(IDMovie)
)

GO


create table Users
(

Username nvarchar(50) unique,
Password nvarchar(100),
Admin bit
)

GO

--Creating Admin

insert into Users
values('admin', 'admin', 1)

GO

--Creating procedures for users

create proc checkUser
	@username nvarchar(50),
	@password nvarchar(100)
as
begin
	select Username from Users
	where Username = @username and Password = @password
end

GO

create proc checkIfUsernameExists
	@username nvarchar(50)
as
begin
	select Username from Users
	where Username = @username
end

GO


create proc addUser
	@username nvarchar(50),
	@password nvarchar(100)
as
begin
	insert into Users
	values(@username, @password, 0)
end

GO 

create proc selectUser
	@username nvarchar(50)
as
begin
	select* from Users
	where Username = @username
end

GO

create proc selectUsers
as
begin
	select*
	from Users
	where Admin = 0
end

GO

create proc addAdmin
	@username nvarchar(50)
as
begin
	update Users
	set Admin = 1
	where Username = @username
end

GO

create proc deleteUser
	@username nvarchar(50)
as
begin
	delete 
	from Users
	where Username = @username
end

GO

----Creating procedures for application


create proc selectMovies
as
begin
	select m.IDMovie, m.Title, m.OriginalTitle, m.Description, m.Length, m.Genre, m.Link, m.PublishedDate, m.PathToPicture
	from Movie as m

end

GO

create proc selectMovie
	@MovieId int
as
begin
	select m.IDMovie, m.Title, m.OriginalTitle, m.Description, m.Length, m.Genre, m.Link, m.PublishedDate, m.PathToPicture
	from Movie as m
	where IDMovie = @MovieId
end

GO

create proc selectPersons
	@MovieId int
as
begin
	select* from Person as p
	where p.MovieId = @MovieID
	
end

GO

create proc addMovie
	@Title nvarchar(100),
	@OriginalTitle nvarchar(100),
	@Description nvarchar(1000),
	@Length int,
	@Genre nvarchar(100),
	@Link nvarchar(300),
	@PublishedDate nvarchar(100),
	@PathToPicture nvarchar(100),
	@MovieId int output
as
begin
	insert into Movie
	values(@Title, @OriginalTitle, @Description, @Length, @Genre, @Link, @PublishedDate, @PathToPicture)
	set @MovieId = SCOPE_IDENTITY()
end

GO

create proc updateMovie
	@Title nvarchar(100),
	@OriginalTitle nvarchar(100),
	@Description nvarchar(1000),
	@Length int,
	@Genre nvarchar(100),
	@Link nvarchar(300),
	@PublishedDate nvarchar(100),
	@PathToPicture nvarchar(100),
	@IDMovie int
as
begin
	update Movie
	set Title = @Title, OriginalTitle = @OriginalTitle, Description = @Description, Length = @Length, Genre = @Genre, Link = @Link, PublishedDate = @PublishedDate, PathToPicture = @PathToPicture
	where IDMovie = @IDMovie	
end

GO

create proc addPerson	
	@Name nvarchar(50),
	@Surname nvarchar(50),
	@Position bit,
	@MovieID int
as
begin
	insert into Person
	values(@Name, @Surname, @Position, @MovieID)
end

GO

create proc deleteMovies

as
begin
	delete from Person
	delete from Movie
	DBCC CHECKIDENT ('Person', RESEED, 0)
	DBCC CHECKIDENT ('Movie', RESEED, 0)
end

GO

create proc deleteMovie
	@MovieID int
as
begin
	delete from Person
	where MovieID = @MovieID

	delete from Movie
	where IDMovie = @MovieID
end

GO

create proc deletePerson
	@PersonID int,
	@MovieID int
as
begin
	delete from Person
	where IDPerson = @PersonID and MovieID = @MovieID
end

GO