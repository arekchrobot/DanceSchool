angular.module("danceSchoolManagement.filters", [])
.filter('isNotEmpty', function () {
    return function (obj) {
        return obj != undefined || obj != null;
    };
});