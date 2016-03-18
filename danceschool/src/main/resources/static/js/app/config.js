'use strict';

var appServices = angular.module('appServices', [])
        .constant('REST_URL', 'http://localhost:8080/')
        .constant('ActivityType', {
            'MODERN': 'Nowoczesny',
            'BALLROOM': 'Towarzyski',
            'SPECIAL_OCCASION': 'Okazje specjalne'
        });
var appControllers = angular.module('appControllers', ['ui.bootstrap', 'ngAnimate', 'uiGmapgoogle-maps', 'appServices', 'LocalStorageModule', 'angular-cookie-law']);