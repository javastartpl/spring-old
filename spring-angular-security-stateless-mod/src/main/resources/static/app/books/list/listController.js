angular.module('app')
.controller('ListController', function(Books) {
	var vm = this;
	vm.books = Books.getAll();
	console.log('list loaded');
	console.log(vm.books)
});