Application.$controller("DigestPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         *
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };

    $scope.button1Click = function($event, $isolateScope) {
        debugger
        $scope.updatedtime()
    };

    $scope.currentDateTime = new Date();
    $scope.updatedtime = function() {
        debugger
        $scope.currentDateTime = new Date();
    }

    $scope.button2Click = function($event, $isolateScope) {
        //get dateTime
        $scope.currentDateTime = new Date();
        //The digest method is use to update date time forcefully.
        $scope.$digest();
    };

}]);