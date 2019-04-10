Application.$controller("SpreadOperatorPageController", ["$scope", function($scope) {
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
        let arr = [1, 2, 3];
        let arr2 = [4, 5];

        arr = [...arr, ...arr2];
        console.log(arr);
        $scope.Widgets.label1.caption = arr;
    };


    $scope.button2Click = function($event, $isolateScope) {
        function sumFunction(x, y, z) {
            return x + y + z;
        }
        const numbers = [1, 2, 3];

        console.log(sumFunction(...numbers));
        $scope.Widgets.label2.caption = sumFunction(...numbers)
        // expected output: 6

        console.log(sumFunction.apply(null, numbers));
        $scope.Widgets.label3.caption = sumFunction.apply(null, numbers)
        // expected output: 6
    };


    $scope.button3Click = function($event, $isolateScope) {
        var parts = ['p1', 'p2'];
        var lyrics = ['l1', ...parts, 'l3', 'l4'];
        $scope.Widgets.label4.caption = lyrics
    };

}]);