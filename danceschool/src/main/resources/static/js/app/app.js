angular.module('hello', ['ngRoute', 'appControllers', 'smoothScroll'])
    .config(['$routeProvider', '$sceDelegateProvider', function ($routeProvider, $sceDelegateProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'html/main/main.html',
                controller: 'mainController'
            })
            .when('/activities', {
                templateUrl: 'html/activity/activities.html',
                controller: 'activitiesController'
            })
            .when('/contact', {
                templateUrl: 'html/contact/contact.html',
                controller: 'contactController'
            })
            .when('/about', {
                templateUrl: 'html/about/about.html',
                controller: 'aboutController'
            })
            .when('/priceList', {
                templateUrl: 'html/priceList/priceList.html',
                controller: 'priceListController'
            })
            .otherwise('/');

        $sceDelegateProvider
            .resourceUrlWhitelist([
                'self',
                'https://www.youtube.com/embed/**'
            ]);
    }]);