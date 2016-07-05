angular.module("danceSchoolManagement.filters", [])
.filter('isNotEmpty', function () {
    return function (obj) {
        return obj !== undefined || obj !== null;
        //for (field in obj) {
        //console.log(field);
        //    if (obj.hasOwnProperty(field)) {
        //        return false;
        //    }
        //}
        //return true;
    };
});