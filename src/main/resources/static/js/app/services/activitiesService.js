appServices.service('activitiesService', function() {
    var teachers = [];
    var video = '';
    var danceType = {
        name: '',
        description: ''
    };
    var gallery = [];

    var loadModernDance = function() {
        var modernTeachers = [];
        var teacher1 = {
            image: 'images/nowoczesny_instruktor1.png',
            name: 'Katarzyna Kowalska',
            description: 'Fascynuje się tańcem od dziecka. Pracuje jako instruktorka tańca nowoczesnego od czterech lat.'
        };
        var teacher2 = {
            image: 'images/nowoczesny_instruktor2.png',
            name: 'Pablo Martinez',
            description: 'Wicemistrz Europy w tańcu nowoczesnym. Instruktor od siedmiu lat.'
        };
        var teacher3 = {
            image: 'images/nowoczesny_instruktor3.png',
            name: 'Aleksandra Jutrzenka',
            description: 'Występowała jako tancerka w trzech edycjach "Tańca z gwiazdami", dwukrotnie przechodząc do finału. Instruktorka od dziesięciu lat.'
        };
        modernTeachers[0] = teacher1;
        modernTeachers[1] = teacher2;
        modernTeachers[2] = teacher3;

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