'use strict';

angular.module('app', ['ngRoute', 'ngResource'])
.config(function ($routeProvider) {
	$routeProvider
	.when('/list', {
		templateUrl: 'partials/list.html',
		controller: 'ListController',
		controllerAs: 'listCtrl'
	})
	.when('/details/:id', {
		templateUrl: 'partials/details.html',
		controller: 'DetailsController',
		controllerAs: 'detailsCtrl'
	})
	.when('/new', {
		templateUrl: 'partials/new.html',
		controller: 'NewController',
		controllerAs: 'newCtrl'
	})
	.otherwise({
		redirectTo: '/list'
	});
})
.constant('BOOK_ENDPOINT', '/api/books/:id')
.factory('Book', function($resource, BOOK_ENDPOINT) {
	return $resource(BOOK_ENDPOINT);
})
.service('Books', function(Book) {
	this.getAll = function() {
		return Book.query();
	}
	this.get = function(index) {
		return Book.get({id: index});
	}
	this.add = function(book) {
		book.$save();
	}
})
.controller('ListController', function(Books) {
	var vm = this;
	vm.books = Books.getAll();
})
.controller('DetailsController', function($routeParams, Books) {
	var vm = this;
	var bookIndex = $routeParams.id;
	vm.book = Books.get(bookIndex);
})
.controller('NewController', function(Books, Book) {
	var vm = this;
	vm.book = new Book();
	vm.saveBook = function() {
		Books.add(vm.book);
		vm.book = new Book();
	}
});