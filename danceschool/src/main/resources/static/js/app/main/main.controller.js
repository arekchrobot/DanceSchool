'use strict';

appControllers.controller('mainController',['$scope', '$log', 'mainService', function($scope, $log, mainService){
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

    $scope.allNews = [];
    $scope.itemsPerPage = 3; //items to show per page
    $scope.currentPage = 1;  //what page to start on

    var loadNews = function() {
        mainService.loadNews()
            .then(function(data){
                $scope.allNews = data;
                $scope.totalItems = $scope.allNews.length;
                $scope.$watch('currentPage + itemsPerPage', function() {
                    var begin = (($scope.currentPage - 1) * $scope.itemsPerPage),
                        end = begin + $scope.itemsPerPage;
                    $scope.filteredNews = $scope.allNews.slice(begin, end);
                });
            },
            function(data){
                $log.error("Error getting news");
            });
    };

    for (var i=0; i<3; i++) {
        $scope.addSlide(i+1);
    }

    loadNews();
}]);