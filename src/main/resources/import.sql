
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