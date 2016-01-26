appServices.service('activitiesService', function() {
    var teachers = [];
    var video = '';
    var danceType = {
        name: '',
        description: ''
    };
    var gallery = [];

    //MODERN
    var modernTeachers = [];
    modernTeachers[0] = {
        image: 'images/nowoczesny_instruktor1.png',
        name: 'Katarzyna Kowalska',
        description: 'Fascynuje się tańcem od dziecka. Pracuje jako instruktorka tańca nowoczesnego od czterech lat.'
    };
    modernTeachers[1] = {
        image: 'images/nowoczesny_instruktor2.png',
        name: 'Pablo Martinez',
        description: 'Wicemistrz Europy w tańcu nowoczesnym. Instruktor od siedmiu lat.'
    };
    modernTeachers[2] = {
        image: 'images/nowoczesny_instruktor3.png',
        name: 'Aleksandra Jutrzenka',
        description: 'Występowała jako tancerka w trzech edycjach "Tańca z gwiazdami", dwukrotnie przechodząc do finału. Instruktorka od dziesięciu lat.'
    };

    //Ballroom
    var ballroomTeachers = [];
    ballroomTeachers[0] = {
        image: 'images/towarzyski_instruktor1.png',
        name: 'Amanda Piasecka',
        description: 'Wielokrotna mistrzyni Polski w tango oraz walcu. Jako instruktorka wyszkoliła 3 mistrzów świata tańców towarzyskich.'
    };
    ballroomTeachers[1] = {
        image: 'images/towarzyski_instruktor2.png',
        name: 'Martin Egurrola',
        description: 'Tancerz, choreograf, sędzia międzynarodowy tańca towarzyskiego i tańca nowoczesnego. Wielokrotny mistrz Polski w tańcach latynoamerykańskich.'
    };
    ballroomTeachers[2] = {
        image: 'images/towarzyski_instruktor3.png',
        name: 'Drake Graham',
        description: 'Amerykański mistrz tańca towarzyskiego, były instruktor na Broadway w Ameryce. Instruktor od 13 lat.'
    };

    //Special Occasion
    var specialOccasionTeachers = [];
    specialOccasionTeachers[0] = {
        image: 'images/specjalne_instruktor1.png',
        name: 'Dominika Macierewicz',
        description: 'Wielkrotnie tworzyła choreografie na weselach. Pomagała przygotować pierwszy taniec wielu znanym gwiazdom.'
    };
    specialOccasionTeachers[1] = {
        image: 'images/specjalne_instruktor2.png',
        name: 'Justyna Kwak',
        description: 'Specjalizuje się w tańcach studniówkowych. Pottrafi stworzyć zapierające w dech piersiach wariacje, które zapierają dech w piersi.'
    };
    specialOccasionTeachers[2] = {
        image: 'images/specjalne_instruktor3.png',
        name: 'Tatiana Okupnik',
        description: 'Wieloletnia instruktorka, tancerka polskich tradycyjnych tańców. Jej doświadczenie pozwala jej na dostosowanie się do każdej imprezy okolicznościowej'
    };

    var loadModernDance = function() {
        teachers = modernTeachers;

        video = 'https://www.youtube.com/embed/VqRd97i8MNU';

        danceType.name = 'Taniec nowoczesny';
        danceType.description = 'Jest to zbiorcze określenie wielu gatunków i rodzajów tańca powstałych w XX i XXI wieku. Nazwa ta może być stosowana do różnych, nie powiązanych ze sobą gatunków tanecznych.';

        gallery[0] = 'images/nowoczesny1.png';
        gallery[1] = 'images/nowoczesny2.png';
        gallery[2] = 'images/nowoczesny3.png'
    };

    var loadBallroomDance = function() {
        teachers = ballroomTeachers;

        video = 'https://www.youtube.com/embed/i3vsiiRK5GU';

        danceType.name = 'Taniec towarzyski';
        danceType.description = 'Forma rozrywki wywodząca się z tańców salonowych i zabaw ludowych, uprawiana od początku XX wieku, na początku był to taniec dla klas uprzywilejowanych, natomiast tańce ludowe pozostawiano klasom niższym. To także dyscyplina zajmująca się tańcami wykonywanymi kiedyś na salach balowych, a obecnie na zawodach organizowanych przez Międzynarodowy Związek Tańców Towarzyskich.';

        gallery[0] = 'images/towarzyski1.png';
        gallery[1] = 'images/towarzyski2.png';
        gallery[2] = 'images/towarzyski3.png';
    };

    var loadSpecialOccasionDance = function() {
        teachers = specialOccasionTeachers;

        video = 'https://www.youtube.com/embed/1LI-62KERsU';

        danceType.name = 'Specjalne okazje';
        danceType.description = 'Jest to określenie na wszelkiego rodzaju wyjątkowe sytuacje jak pierwszy taniec weselny, tańce na rozpoczęcie studniówek. Zapwniamy indywidualną choreografię dostosowaną do potrzeb klienta.';

        gallery[0] = 'images/specjalne1.png';
        gallery[1] = 'images/specjalne2.png';
        gallery[2] = 'images/specjalne3.png';
    };
    return {
        loadModernDance: loadModernDance,
        loadBallroomDance: loadBallroomDance,
        loadSpecialOccasionDance: loadSpecialOccasionDance,
        getTeachers: function() {
            return teachers;
        },
        getVideo: function () {
            return video;
        },
        getDanceType: function() {
            return danceType;
        },
        getGallery: function() {
            return gallery;
        },
        getAllTeachers: function() {
            return ballroomTeachers.concat(modernTeachers, specialOccasionTeachers);
        }
    };
});