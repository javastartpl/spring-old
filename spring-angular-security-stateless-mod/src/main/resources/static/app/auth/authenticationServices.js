angular.module('app')
.constant('LOGIN_ENDPOINT', '/login')
.service('AuthenticationService', function($http, LOGIN_ENDPOINT) {
	this.authenticate = function(credentials, successCallback) {
		var authHeader = {Authorization: 'Basic ' + btoa(credentials.username+':'+credentials.password)};
		var config = {headers: authHeader};
		$http
		.post(LOGIN_ENDPOINT, {}, config)
		.then(function success(value) {
			$http.defaults.headers.post.Authorization = authHeader.Authorization;
			successCallback();
		}, function error(reason) {
			console.log('Login error');
			console.log(reason);
		});
	}
	this.logout = function(successCallback) {
		delete $http.defaults.headers.post.Authorization;
		successCallback();
	}
});