'use strict';

appControllers.controller('mainController',['$scope',function($scope){
    $scope.hello = "hello";

    $scope.myInterval = 5000;
    $scope.noWrapSlides = false;
    var slides = $scope.slides = [];
    $scope.addSlide = function() {
        var newWidth = 600 + slides.length + 1;
        slides.push({
            image: '//placekitten.com/' + newWidth + '/300',
            text: ['More','Extra','Lots of','Surplus', 'Witcher'][slides.length % 5] + ' ' +
            ['Cats', 'Kittys', 'Felines', 'Cutes', '3'][slides.length % 5]
        });
    };
    for (var i=0; i<4; i++) {
        $scope.addSlide();
    }
    slides.push({
       image: 'images/witcher_3_wild_hunt_geralt_2015-wallpaper-1920x1080.jpg',
        text: ['More','Extra','Lots of','Surplus', 'Witcher'][slides.length % 5] + ' ' +
        ['Cats', 'Kittys', 'Felines', 'Cutes', '3'][slides.length % 5]
    });
}]);