'use strict';

appControllers.controller('mainController',['$scope',function($scope){
    $scope.hello = "hello";

    $scope.myInterval = 5000;
    $scope.noWrapSlides = false;
    var slides = $scope.slides = [];
    $scope.addSlide = function(index) {
        var newWidth = 600 + slides.length + 1;
        slides.push({
            image: 'images/carusel' + index + '_small.png',
            text: ['Taniec','Taniec', 'Specjalne'][slides.length % 3] + ' ' +
            ['Towarzyski', 'Nowoczesny', 'Okazje'][slides.length % 3]
        });
    };
    for (var i=0; i<3; i++) {
        $scope.addSlide(i+1);
    }
    //slides.push({
    //   image: 'images/witcher_3_wild_hunt_geralt_2015-wallpaper-1920x1080.jpg',
    //    text: ['More','Extra','Lots of','Surplus', 'Witcher'][slides.length % 5] + ' ' +
    //    ['Cats', 'Kittys', 'Felines', 'Cutes', '3'][slides.length % 5]
    //});
}]);