angular.module('app')
.controller('DetailsController', function($routeParams, Books) {
	var vm = this;
	var bookIndex = $routeParams.id;
	vm.book = Books.get(bookIndex);
});