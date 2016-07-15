angular.module("danceSchoolManagement.contactController", []).config(function ($stateProvider) {
    $stateProvider.state("contact", {
        url: "/contact",
        templateUrl: "html/contact/contact.html",
        controller:"contactController"
    });
}).controller("contactController", function ($scope, contactRestService, exceptionHandler, contactService) {

    $scope.zipCodePattern = "[0-9]{2}\-[0-9]{3}";

    contactRestService.getAll(
        function(returnedData){
            $scope.contact = returnedData[0];
        },
        exceptionHandler.handleRestError
    );

    $scope.doAction = function() {
        contactService.getLatLng($scope.contact, function(returnedData){
            $scope.contact.latitude = returnedData.results[0].geometry.location.lat;
            $scope.contact.longitude = returnedData.results[0].geometry.location.lng;
            if($scope.contact.zipCode == undefined || $scope.contact.zipCode == null || $scope.contact.zipCode == ""){
                for (var i = 0; i < returnedData.results[0].address_components.length; i++) {
                    if(returnedData.results[0].address_components[i].types[0].equals("postal_code")) {
                        $scope.contact.zipCode = returnedData.results[0].address_components[i].long_name;
                    }
                }
            }
            contactRestService.save($scope.contact,
                function(returnedData){
                    $scope.contact = returnedData;
                },
                exceptionHandler.handleRestError
            );
        });
    };
});