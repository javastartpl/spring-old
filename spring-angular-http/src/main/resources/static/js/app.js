'use strict';

//Podstawowa wersja bez funkcji get() i post() usługi $http
//angular.module('app', []).controller('ProductController', function($http) {
//	var vm = this;
//	function refreshData() {
//		$http({
//			method : 'GET',
//			url : 'api/products'
//		}).then(function success(response) {
//			vm.products = response.data;
//			console.log(vm.products);
//		}, function error(response) {
//			console.log('API error ' + response.status);
//		});
//	}
//
//	vm.addProduct = function(product) {
//		$http({
//			method : 'POST',
//			url : 'api/products',
//			data : product
//		}).then(function success(response) {
//			refreshData();
//			vm.product = {};
//		}, function error(response) {
//			console.log('Data not saved ' + product);
//		});
//	}
//
//	vm.appName = 'Product Manager';
//	refreshData();
//});
angular.module('app', [])
.controller('ProductController', function($http) {
	var vm = this;
	function refreshData() {
		$http.get('api/products')
		.then(function success(response) {
			vm.products = response.data;
		}, function error(response) {
			console.log('API error ' + response.status);
		});
	}

	vm.addProduct = function(product) {
		$http.post('api/products', product)
		.then(function success(response) {
			refreshData();
			vm.product = {};
		}, function error(response) {
			console.log('Data not saved ' + product);
		});
	}
	
	vm.appName = 'Product Manager';
	refreshData();
});