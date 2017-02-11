'use strict';

angular.module('app', ['ngRoute'])
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
.factory('Book', function() {
	function Book(id, title, author, isbn) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	return Book;
})
.service('Books', function(Book) {
	var books = [
	  new Book(0, 'Henryk Sienkiewicz', 'Krzyżacy', '123456789'),
      new Book(1, 'Adam Mickiewicz', 'Dziady', "1324354657"),
      new Book(2, 'Maria Konopnicka', 'Dym', "9786756453")
    ];
	this.size = function() {
		return books.length;
	}
	this.getAll = function() {
		return books;
	}
	this.get = function(index) {
		return books[index];
	}
	this.add = function(book) {
		books.push(book);
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
		vm.book.id = Books.size();
		Books.add(vm.book);
		vm.book = new Book();
	}
});