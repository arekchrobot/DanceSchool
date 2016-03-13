'use strict';

appControllers.controller('contactController', ['$scope', '$timeout', '$location', 'contactService', '$log', function ($scope, $timeout, $location, contactService, $log) {
    var loadContact = function () {
        contactService.loadContact()
            .then(function (data) {
                $scope.contact = data;
                $scope.map = {
                    center: {
                        latitude: $scope.contact.latitude,
                        longitude: $scope.contact.longitude
                    },
                    zoom: 15
                };

                $scope.options = {scrollwheel: false};
                $scope.coordsUpdates = 0;
                $scope.dynamicMoveCtr = 0;

                $scope.marker = {
                    id: 0,
                    coords: {
                        latitude: $scope.contact.latitude,
                        longitude: $scope.contact.longitude
                    },
                    options: {draggable: true},
                    events: {
                        dragend: function (marker, eventName, args) {
                            // $log.log('marker dragend');
                            var lat = marker.getPosition().lat();
                            var lon = marker.getPosition().lng();
                            //  $log.log(lat);
                            //  $log.log(lon);

                            $scope.marker.options = {
                                draggable: true,
                                labelContent: "lat: " + $scope.marker.coords.latitude + ' ' + 'lon: ' + $scope.marker.coords.longitude,
                                labelAnchor: "100 0",
                                labelClass: "marker-labels"
                            };
                        }
                    }
                };


            },
            function (data) {
                $log.error("Error getting contact data");
            });
    };
    $scope.$watchCollection("marker.coords", function (newVal, oldVal) {
        if (_.isEqual(newVal, oldVal))
            return;
        $scope.coordsUpdates++;
    });
    $timeout(function () {
        $scope.marker.coords = {
            latitude:  $scope.contact.latitude,
            longitude: $scope.contact.longitude
        };
        $scope.dynamicMoveCtr++;
        $timeout(function () {
            $scope.marker.coords = {
                latitude: $scope.contact.latitude,
                longitude: $scope.contact.longitude
            };
            $scope.dynamicMoveCtr++;
        }, 2000);
    }, 1000);

    loadContact();

    $scope.contactData = {
        user: 'Imie i nazwisko',
        email: 'email@example.com',
        phone: '',
        message: ''
    };

    $scope.submitContactData = function () {
        alert('Dziękujemy za wysłaną wiadomość');
        $location.path('/home');
    };
}]);

