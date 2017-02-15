angular.module('app')
.controller('NewController', function(Books, Book) {
	var vm = this;
	vm.book = new Book();
	vm.saveBook = function() {
		Books.add(vm.book);
		vm.book = new Book();
	}
});