angular.module('app')
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
});