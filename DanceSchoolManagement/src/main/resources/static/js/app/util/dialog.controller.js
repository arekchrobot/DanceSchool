angular.module("danceSchoolManagement.dialogController", []).controller("dialogController", function ($scope, ngDialog) {
    $scope.close = function() {
        ngDialog.closeAll();
    };
});