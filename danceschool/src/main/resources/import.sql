
INSERT INTO activity(id, name_, description, video_url, version) VALUES (0,'Taniec nowoczesny', 'Jest to zbiorcze określenie wielu gatunków i rodzajów tańca powstałych w XX i XXI wieku. Nazwa ta może być stosowana do różnych, nie powiązanych ze sobą gatunków tanecznych.', 'https://www.youtube.com/embed/VqRd97i8MNU', 1);
INSERT INTO activity(id, name_, description, video_url, version) VALUES (1,'Taniec towarzyski', 'Forma rozrywki wywodząca się z tańców salonowych i zabaw ludowych, uprawiana od początku XX wieku, na początku był to taniec dla klas uprzywilejowanych, natomiast tańce ludowe pozostawiano klasom niższym. To także dyscyplina zajmująca się tańcami wykonywanymi kiedyś na salach balowych, a obecnie na zawodach organizowanych przez Międzynarodowy Związek Tańców Towarzyskich.', 'https://www.youtube.com/embed/i3vsiiRK5GU', 1);
INSERT INTO activity(id, name_, description, video_url, version) VALUES (2,'Specjalne okazje', 'Jest to określenie na wszelkiego rodzaju wyjątkowe sytuacje jak pierwszy taniec weselny, tańce na rozpoczęcie studniówek. Zapwniamy indywidualną choreografię dostosowaną do potrzeb klienta.', 'https://www.youtube.com/embed/1LI-62KERsU', 1);

INSERT INTO gallery(activity_id, photo_location) VALUES ((SELECT id FROM activity WHERE name_ = 'Taniec nowoczesny'), 'nowoczesny1.png');
INSERT INTO gallery(activity_id, photo_location) VALUES ((SELECT id FROM activity WHERE name_ = 'Taniec nowoczesny'), 'nowoczesny2.png');
INSERT INTO gallery(activity_id, photo_location) VALUES ((SELECT id FROM activity WHERE name_ = 'Taniec nowoczesny'), 'nowoczesny3.png');

INSERT INTO gallery(activity_id, photo_location) VALUES ((SELECT id FROM activity WHERE name_ = 'Taniec towarzyski'), 'towarzyski1.png');
INSERT INTO gallery(activity_id, photo_location) VALUES ((SELECT id FROM activity WHERE name_ = 'Taniec towarzyski'), 'towarzyski2.png');
INSERT INTO gallery(activity_id, photo_location) VALUES ((SELECT id FROM activity WHERE name_ = 'Taniec towarzyski'), 'towarzyski3.png');

INSERT INTO gallery(activity_id, photo_location) VALUES ((SELECT id FROM activity WHERE name_ = 'Specjalne okazje'), 'specjalne1.png');
INSERT INTO gallery(activity_id, photo_location) VALUES ((SELECT id FROM activity WHERE name_ = 'Specjalne okazje'), 'specjalne2.png');
INSERT INTO gallery(activity_id, photo_location) VALUES ((SELECT id FROM activity WHERE name_ = 'Specjalne okazje'), 'specjalne3.png');

INSERT INTO instructor(id, name_, description, image, activity_id, version) VALUES (0, 'Katarzyna Kowalska', 'Fascynuje się tańcem od dziecka. Pracuje jako instruktorka tańca nowoczesnego od czterech lat.', 'nowoczesny_instruktor1.png', (SELECT id FROM activity WHERE name_ = 'Taniec nowoczesny'), 1);
INSERT INTO instructor(id, name_, description, image, activity_id, version) VALUES (1, 'Pablo Martinez', 'Wicemistrz Europy w tańcu nowoczesnym. Instruktor od siedmiu lat.', 'nowoczesny_instruktor2.png', (SELECT id FROM activity WHERE name_ = 'Taniec nowoczesny'), 1);
INSERT INTO instructor(id, name_, description, image, activity_id, version) VALUES (2, 'Aleksandra Jutrzenka', 'Występowała jako tancerka w trzech edycjach "Tańca z gwiazdami", dwukrotnie przechodząc do finału. Instruktorka od dziesięciu lat.', 'nowoczesny_instruktor3.png', (SELECT id FROM activity WHERE name_ = 'Taniec nowoczesny'), 1);

INSERT INTO instructor(id, name_, description, image, activity_id, version) VALUES (3, 'Amanda Piasecka', 'Wielokrotna mistrzyni Polski w tango oraz walcu. Jako instruktorka wyszkoliła 3 mistrzów świata tańców towarzyskich.', 'towarzyski_instruktor1.png', (SELECT id FROM activity WHERE name_ = 'Taniec towarzyski'), 1);
INSERT INTO instructor(id, name_, description, image, activity_id, version) VALUES (4, 'Martin Egurrola', 'Tancerz, choreograf, sędzia międzynarodowy tańca towarzyskiego i tańca nowoczesnego. Wielokrotny mistrz Polski w tańcach latynoamerykańskich.', 'towarzyski_instruktor2.png', (SELECT id FROM activity WHERE name_ = 'Taniec towarzyski'), 1);
INSERT INTO instructor(id, name_, description, image, activity_id, version) VALUES (5, 'Drake Graham', 'Amerykański mistrz tańca towarzyskiego, były instruktor na Broadway w Ameryce. Instruktor od 13 lat.', 'towarzyski_instruktor3.png', (SELECT id FROM activity WHERE name_ = 'Taniec towarzyski'), 1);

INSERT INTO instructor(id, name_, description, image, activity_id, version) VALUES (6, 'Dominika Macierewicz', 'Wielokrotnie tworzyła choreografie na weselach. Pomagała przygotować pierwszy taniec wielu znanym gwiazdom.', 'specjalne_instruktor1.png', (SELECT id FROM activity WHERE name_ = 'Specjalne okazje'), 1);
INSERT INTO instructor(id, name_, description, image, activity_id, version) VALUES (7, 'Justyna Kwak', 'Specjalizuje się w tańcach studniówkowych. Pottrafi stworzyć zapierające w dech piersiach wariacje, które zapierają dech w piersi.', 'specjalne_instruktor2.png', (SELECT id FROM activity WHERE name_ = 'Specjalne okazje'), 1);
INSERT INTO instructor(id, name_, description, image, activity_id, version) VALUES (8, 'Tatiana Okupnik', 'Wieloletnia instruktorka, tancerka polskich tradycyjnych tańców. Jej doświadczenie pozwala jej na dostosowanie się do każdej imprezy okolicznościowej', 'specjalne_instruktor3.png', (SELECT id FROM activity WHERE name_ = 'Specjalne okazje'), 1);

INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (0, 'MONDAY', '17:00',(SELECT id FROM instructor WHERE name_ = 'Pablo Martinez'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (1, 'TUESDAY', '18:00',(SELECT id FROM instructor WHERE name_ = 'Katarzyna Kowalska'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (2, 'WEDNESDAY', '17:00',(SELECT id FROM instructor WHERE name_ = 'Pablo Martinez'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (3, 'WEDNESDAY', '16:00',(SELECT id FROM instructor WHERE name_ = 'Aleksandra Jutrzenka'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (4, 'THURSDAY', '18:00',(SELECT id FROM instructor WHERE name_ = 'Katarzyna Kowalska'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (5, 'FRIDAY', '16:00',(SELECT id FROM instructor WHERE name_ = 'Aleksandra Jutrzenka'), 1);

INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (6, 'MONDAY', '17:00',(SELECT id FROM instructor WHERE name_ = 'Martin Egurrola'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (7, 'TUESDAY', '18:00',(SELECT id FROM instructor WHERE name_ = 'Amanda Piasecka'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (8, 'WEDNESDAY', '17:00',(SELECT id FROM instructor WHERE name_ = 'Martin Egurrola'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (9, 'WEDNESDAY', '16:00',(SELECT id FROM instructor WHERE name_ = 'Drake Graham'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (10, 'THURSDAY', '18:00',(SELECT id FROM instructor WHERE name_ = 'Amanda Piasecka'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (11, 'FRIDAY', '16:00',(SELECT id FROM instructor WHERE name_ = 'Drake Graham'), 1);

INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (12, 'MONDAY', '17:00',(SELECT id FROM instructor WHERE name_ = 'Justyna Kwak'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (13, 'TUESDAY', '18:00',(SELECT id FROM instructor WHERE name_ = 'Dominika Macierewicz'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (14, 'WEDNESDAY', '17:00',(SELECT id FROM instructor WHERE name_ = 'Justyna Kwak'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (15, 'WEDNESDAY', '16:00',(SELECT id FROM instructor WHERE name_ = 'Tatiana Okupnik'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (16, 'THURSDAY', '18:00',(SELECT id FROM instructor WHERE name_ = 'Dominika Macierewicz'), 1);
INSERT INTO lesson(id, week_day, hour_, instructor_id, version) VALUES (17, 'FRIDAY', '16:00',(SELECT id FROM instructor WHERE name_ = 'Tatiana Okupnik'), 1);

INSERT INTO news(id, title, description, image, version) VALUES (0, 'Nowe zajęcia z tańca nowoczesnego', 'Od stycznia 2016 roku oferta tańca nowoczesnego zostanie powiększona. Będzie więcej zajęć dla zaawansowanych oraz możliwość wzięcia udziału w warsztatch ze światowej sławy tancerzami - nawet z samego Brooklynu!', 'aktualnosci1.jpg', 1);
INSERT INTO news(id, title, description, image, version) VALUES (1, 'Zwycięstwo w międzynarodowych zawodach juniorów w tańcu towarzyskim', 'Dnia 25.10.2015 para z naszej szkoły wygrała międzynarodowe zawody tańca towarzyskiego w kategorii junirów. Pokonali oni wiele znakomitych par. Przygotowania prowadził {IMIE}, natomiast choregorafią zajęła się {IMIE}. Serdecznie gratulujemy naszej parze! Oby tak dalej.', 'aktualnosci2.jpg', 1);

INSERT INTO contact(id, address, zip_code, city, phone, email, version) VALUES (0, 'Wólczańska 256', '95-111', 'Łódź', '+48 42 234 34 45', 'szkolatanca@taniec.com',1);

INSERT INTO opening_hours(contact_id, opening_hour) VALUES ((SELECT id FROM contact WHERE email = 'szkolatanca@taniec.com'), 'Poniedziałek - Piątek: 9:00 - 21:00');