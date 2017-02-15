angular.module('app')
.controller('AuthenticationController', function($rootScope, $location, AuthenticationService) {
	var vm = this;
	vm.credentials = {};
	var loginSuccess = function() {
		$rootScope.authenticated = true;
		$location.path('/new');
	}
	vm.login = function() {
		AuthenticationService.authenticate(vm.credentials, loginSuccess);
	}
	var logoutSuccess = function() {
		$rootScope.authenticated = false;
		$location.path('/');
	}
	vm.logout = function() {
		AuthenticationService.logout(logoutSuccess);
	}
});