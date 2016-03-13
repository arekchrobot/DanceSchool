'use strict';

appControllers.controller('mainController',['$scope',function($scope){
    $scope.hello = "hello";

    $scope.myInterval = 5000;
    $scope.noWrapSlides = false;
    var slides = $scope.slides = [];
    $scope.addSlide = function(index) {
        slides.push({
            image: 'images/carusel' + index + '_small.png',
            text: ['Taniec','Taniec', 'Specjalne'][slides.length % 3] + ' ' +
            ['Towarzyski', 'Nowoczesny', 'Okazje'][slides.length % 3]
        });
    };
    for (var i=0; i<3; i++) {
        $scope.addSlide(i+1);
    }
}]);