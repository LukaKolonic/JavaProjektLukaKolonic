create database JavaBaza
go

use JavaBaza
go

create table Movie (

IDMovie int constraint PK_Movie primary key identity,
Title nvarchar(250) not null,
PubDate nvarchar(100) null,
[Description]nvarchar(1200) null,
OrigTitle nvarchar(300) null,
Duration int null,
[Year] int null,
Poster nvarchar(200) null,
Rating int null,
Booking nvarchar(500) null,
[Date] nvarchar(50) null,
Trailer nvarchar(500) null,
GenreID int constraint FK_Movie_Genre foreign key references Genre(IDGenre) not null
)
go

create table FavouriteMovie (
IDFavouriteMovie int constraint PK_FavouriteMovie primary key identity,
MovieID int constraint FK_Movie_FavouriteMovie foreign key references Movie(IDMovie)
)
go


create table Genre (
IDGenre int constraint PK_Genre primary key identity,
[Name] nvarchar(250) not null
)
go

create table Person (
IDPerson int constraint PK_Person primary key identity,
[Name] nvarchar(250) not null,
Surname nvarchar(250) 
)
go


create table MoviePerson (
IDMoviePerson int constraint PK_MoviePerson primary key identity,
MovieID int constraint FK_Movie_MoviePerson foreign key references Movie(IDMovie) not null,
PersonID int constraint FK_Movie_Person foreign key references Person(IDPerson) not null,
PersonType int not null
)
go



create table [User] (
IDUser int constraint PK_User primary key identity,
Username nvarchar(250) not null,
[Password] nvarchar(250) not null,
UserType int null
)
go



--movie create

create proc createMovie
	@Title nvarchar(250),
	@PubDate nvarchar(100),
	@Description nvarchar(1200),
	@OrigTitle nvarchar(300), 
	@Duration int,
	@Year int,
	@Poster nvarchar(200),
	@Rating int,
	@Booking nvarchar(500),
	@Date nvarchar(50),
	@Trailer nvarchar(500),
	@GenreID int,
	@ID int output
as
begin 
		insert into Movie values(@Title,@PubDate,@Description,@OrigTitle,@Duration,@Year,@Poster,@Rating,@Booking,@Date,@Trailer,@GenreID)
		set @ID = SCOPE_IDENTITY()
end
go

--movie select
create proc selectMovie
	@IDMovie int
as 
begin 
	select * 
	from Movie
	where IDMovie=@IDMovie
end
go

create proc selectMovies
as
begin 
	select * 
	from Movie
end
go

create proc selectMovieByTitle
	@title nvarchar(250)
as
begin
	select * from Movie
	where Title=@title
end
go


--movie update

create proc updateMovie
	@Title nvarchar(250),
	@PubDate nvarchar(100),
	@Description nvarchar(1200),
	@OrigTitle nvarchar(300), 
	@Duration int,
	@Year int,
	@Poster nvarchar(200),
	@Rating int,
	@Booking nvarchar(500),
	@Date nvarchar(50),
	@Trailer nvarchar(500),
	@GenreID int,
	@IDMovie int 
as
begin 
	 
	update Movie set Title=@Title,PubDate=@PubDate,[Description]=@Description,OrigTitle=@OrigTitle,Duration=@Duration,[Year]=@Year,Poster=@Poster,Rating=@Rating,Booking=@Booking,[Date]=@Date,Trailer=@Trailer,GenreID=@GenreID
	where IDMovie=@IDMovie
END
GO

--movie delete

alter proc deleteMovies
as
begin
	delete from MoviePerson
	delete from Person
	delete from FavouriteMovie
	delete from Movie
	delete from Genre
end
go

create proc deleteMovie
@IDMovie int
as
begin

delete from MoviePerson
	where MovieID = @IDMovie

delete from Movie
	where IDMovie = @IDMovie

end
go

--genre create

create proc createGenre
	@Name nvarchar(250),
	@ID int output
as
begin 
	if not exists (Select IDGenre from Genre where [Name] = @Name) 
	begin
		insert into Genre values(@Name)
		set @ID = SCOPE_IDENTITY()
	end
	else
	begin
		select @ID=IDGenre 
		from Genre 
		where [Name] = @Name
	end
end
go

--genre select

create proc selectGenre
	@IDGenre int
as
begin 
	select *
	from Genre
	where IDGenre = @IDGenre
end
go

create proc selectGenres
as
begin
	select * 
	from Genre
end
go

--genre update

create proc updateGenre
	@Name nvarchar(250),
	@IDGenre int 
as
begin
	update Genre set [Name]=@Name where IDGenre = @IDGenre
end
go

--genre delete

alter proc deleteGenre
	@IDGenre int	 
as 
begin 
	delete from Movie
	where GenreID=@IDGenre
	delete from Genre
	where IDGenre = @IDGenre
end
go


--person create

create proc createPerson
	@Name nvarchar(250),
	@Surname nvarchar(250),
	@ID int output
as
begin 
	if not exists (select IDPerson from Person where [Name] = @Name and Surname = @Surname) 
	begin
		insert into Person values(@Name, @Surname)
		set @ID = SCOPE_IDENTITY()
	end
	else
	begin
		select @ID=IDPerson
		from Person
		where [Name] = @Name and Surname = @Surname
	end
end
go

--person select

create proc selectPerson
	@IDPerson int
as
begin
	select * 
	from Person
	where IDPerson = @IDPerson  
end
go

create proc selectPersons
as
begin 
	select *
	from Person
end
go


--person update

create proc updatePerson
	@Name nvarchar(250),
	@Surname nvarchar(250),
	@IDPerson int
as
begin 
	update Person set [Name]=@Name,Surname=@Surname
	where IDPerson = @IDPerson
end
go


--person delete

alter proc deletePerson
	@IDPerson int	 
as 
begin 
	delete from MoviePerson
	where PersonID=@IDPerson
	delete from Person  
	where IDPerson = @IDPerson
end
go


--user create

create proc createUser
	@Username nvarchar(250),
	@Password nvarchar(250),
	@UserType int,
	@ID int output
as
begin 
	if not exists (select IDUser from [User] where Username = @Username) 
	begin
		insert into [User] values(@Username, @Password, @UserType)
		set @ID = SCOPE_IDENTITY()
	end
	else
	begin
		select @ID=IDUser
		from [User] 
		where Username = @Username
	end
end
go

--user select

create proc selectUser
	@IDUser int
as 
begin 
	select *
	from [User]
	where IDUser = @IDUser
end
go

create proc selectUsers
as
begin 
	select *
	from [User]
end
go

create proc selectType
@username nvarchar(250),
@password nvarchar(250),
@type int output
as
begin 
	select @type=UserType
	from [User]
	where Username=@username and Password=@password
end
go



insert into [User](Username, [Password],UserType) values('Admin', 'Admin1',0)



--user update

create proc updateUser
	@Username nvarchar(250),
	@Password nvarchar(250),
	@UserType int,
	@IDUser int
	 
as
begin 
	update [User] set Username=@Username,Password=@Password,UserType=@UserType where IDUser = @IDUser
end
go

--user delete

create proc deleteUser
	@IDUser int	 
as 
begin 
	delete from [User]  
	where IDUser = @IDUser
end
go

--create MoviePerson

alter proc createMoviePerson
	@PersonID int,
	@MovieID int,
	@PersonType int,
	@ID int output
as 
begin 
	if not exists (select IDMoviePerson from MoviePerson where PersonID = @PersonID and MovieID = @MovieID and PersonType=@PersonType) 
	begin
		insert into MoviePerson values(@MovieID, @PersonID, @PersonType)
		set @ID = SCOPE_IDENTITY()
	end
	else
	begin
		select @ID=IDMoviePerson from MoviePerson where PersonID = @PersonID and MovieID = @MovieID and PersonType=@PersonType
	end
end
go

--select MoviePerson

create proc selectMoviePerson
	@IDMoviePerson int
as
begin
	select * 
	from MoviePerson
	where IDMoviePerson = @IDMoviePerson
end
go

create proc selectMoviePersons
as
begin 
	select * 
	from MoviePerson
end
go


--upate MoviePerson

create proc updateMoviePerson
	@PersonID int,
	@MovieID int,
	@PersonType int,
	@IDMoviePerson int 
	 
as
begin 
	update MoviePerson set PersonID=@PersonID,MovieID=@MovieID,PersonType=@PersonType where IDMoviePerson = @IDMoviePerson
end
go

--delete MoviePerson

create proc deleteMoviePerson
	@IDMoviePerson int	 
as 
begin 
	delete from MoviePerson  
	where IDMoviePerson = @IDMoviePerson 
end
go


create proc createFavouriteMovie
	@movieid int,
	@id int output
as
begin
	insert into FavouriteMovie values (@movieid)
	set @id = SCOPE_IDENTITY()
end
go


create proc deleteFavouriteMovies
as
begin
	delete from FavouriteMovie
end
