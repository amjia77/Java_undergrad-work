/*Lingjia Zhang
INSY4305-001*/



DROP DATABASE IF EXISTS networks;

CREATE DATABASE networks;

USE networks;

CREATE TABLE Actors
(
   Title varchar(50) NOT NULL,
   Name varchar(30) NOT NULL,
   Age int NOT NULL
);

CREATE TABLE Shows
(
   Network varchar(20) NOT NULL,
   Title varchar(50) NOT NULL,
   Producer varchar(20) NOT NULL,
   Type varchar(20) NOT NULL,
   AvailableCommercialTime int NOT NULL
);

CREATE TABLE PublicNetworks
(
   Name varchar(20) NOT NULL,
   President varchar(20) NOT NULL,
   Headquarters varchar(100) NOT NULL,
   Sponsor varchar(20) NOT NULL
);

CREATE TABLE CommercialNetworks
(
   Name varchar(20) NOT NULL,
   President varchar(20) NOT NULL,
   Headquarters varchar(100) NOT NULL,
   Owner varchar(20) NOT NULL,
   ParentCompany varchar(20) NOT NULL
);

INSERT INTO Actors VALUES ('Big Bang Theory', 'Johnny Galecki', 28);
INSERT INTO Actors VALUES ('Big Bang Theory', 'Jim Parsons', 30);
INSERT INTO Actors VALUES ('Big Bang Theory', 'Kaley Cuoco', 26);
INSERT INTO Actors VALUES ('Hawaii Five O', 'Alex O Loughlin', 35);
INSERT INTO Actors VALUES ('Hawaii Five O', 'Scott Caan', 33);
INSERT INTO Actors VALUES ('Hawaii Five O', 'Daniel Kim', 36);
INSERT INTO Actors VALUES ('Hawaii Five O', 'Grace Park', 32);
INSERT INTO Actors VALUES ('ABC World News', 'Diane Sawyer', 60);
INSERT INTO Actors VALUES ('ABC World News', 'David Muir', 45);
INSERT INTO Actors VALUES ('CEO', 'Cullum', 58);

INSERT INTO Shows VALUES ('CBS', 'Big Bang Theory', 'Lorre', 'Comedy', 300);
INSERT INTO Shows VALUES ('CBS', 'Hawaii Five O', 'Kurtzman', 'Drama', 600);
INSERT INTO Shows VALUES ('ABC', 'ABC World News', 'Arlidge', 'News', 250);
INSERT INTO Shows VALUES ('PBS', 'CEO', 'Cullum', 'News', 150);

INSERT INTO PublicNetworks VALUES('PBS', 'Paula Kerger', '2100 Chrystal Drive,Arlington,Virginia,22202', 'Public Radio');

INSERT INTO CommercialNetworks VALUES('CBS', 'Leslie Moonves', '51 West 52nd Street,New York,New York,10019', 'Philippe Dauman', 'Viacom');
INSERT INTO CommercialNetworks VALUES('ABC', 'Ben Sherwood', '54 West 67th Street,New York,New York,10017', 'Ed Noble', 'Disney');
INSERT INTO CommercialNetworks VALUES('NBC', 'Jeff Zucker', '30 Rockefeller Center,New York,New York,10112', 'Burke Cox', 'General Electric');




