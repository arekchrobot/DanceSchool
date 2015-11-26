angular.module('hello',['ngRoute','appControllers', 'smoothScroll'])
    .config(['$routeProvider',function ($routeProvider){
        $routeProvider
            .when('/',{
                templateUrl: 'main.html',
                controller: 'mainController'
            })
            .when('/activities', {
                templateUrl: 'activities.html',
                controller: 'activitiesController'  
            })
            .when('/contact', {
                templateUrl: 'contact.html',
                controller: 'contactController'
            })
            .when('/about', {
                templateUrl: 'about.html',
                controller: 'aboutController'
            })
            .when('/priceList', {
                templateUrl: 'priceList.html',
                controller: 'priceListController'
            })
            .otherwise('/');
    }]);