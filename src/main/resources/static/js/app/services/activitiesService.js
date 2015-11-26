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

    };

    var loadSpecialOccasionDance = function() {

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
        }
    };
});