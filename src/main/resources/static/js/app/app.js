angular.module('hello',['ngRoute','appControllers'])
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
            .otherwise('/');
    }]);