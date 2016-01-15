var app = angular.module('blog', [ ]);

app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
  $scope.helloWorld = 'Aplicatii Web cu suport Java!';

  $scope.persoane = [];
  $scope.keys = [];

  $scope.person = {};
  $scope.editPerson = {};
/////////////
  $scope.carti = [];
  $scope.keys = [];

  $scope.carte = {};
  $scope.editCarte = {};
  /////////////
  $scope.produse = [];
  $scope.keys = [];

  $scope.produs = {};
  $scope.editProdus = {};
   /////////////
  $scope.bauturi = [];
  $scope.keys = [];

  $scope.bautura = {};
  $scope.editBautura = {};


  $http.get('http://localhost:8080/persoana').then(
    function successCallback(response) {

    $scope.persoane = response;
    $scope.keys = Object.keys(response.data[0]);
  });

$http.get('http://localhost:8080/carte').then(
    function successCallback(response) {

    $scope.carti = response;
    $scope.keys = Object.keys(response.data[0]);
  });

$http.get('http://localhost:8080/produs').then(
    function successCallback(response) {

    $scope.produse = response;
    $scope.keys = Object.keys(response.data[0]);
  });

$http.get('http://localhost:8080/bautura').then(
    function successCallback(response) {

    $scope.bauturi = response;
    $scope.keys = Object.keys(response.data[0]);
  });
  $scope.addPersoana = function(person) {
    $scope.persoane.data.push(person);
    $http.post('http://localhost:8080/persoana', person);
    $scope.person = {};
  };

  $scope.addCarte = function(carte) {
    $scope.carti.data.push(carte);
    $http.post('http://localhost:8080/carte', carte);
    $scope.carte = {};
  };

  $scope.addProdus = function(produs) {
    $scope.produse.data.push(produs);
    $http.post('http://localhost:8080/produs', produs);
    $scope.produs = {};
  };

   $scope.addBautura = function(bautura) {
    $scope.bauturi.data.push(bautura);
    $http.post('http://localhost:8080/bautura', bautura);
    $scope.bautura = {};
  };

  $scope.setUpdatePerson = function(person) {
    $scope.editPerson = person;
  };
  $scope.setUpdateCarte = function(carte) {
    $scope.editCarte = carte;
  };

  $scope.setUpdateProdus = function(produs) {
    $scope.editProdus = produs;
  };

$scope.setUpdateBautura = function(bautura) {
    $scope.editBautura = bautura;
  };
  $scope.updatePerson = function() {
    $http.put('http://localhost:8080/persoana', $scope.editPerson);
    $scope.editPerson = {};
  };
  $scope.updateCarte = function() {
    $http.put('http://localhost:8080/carte', $scope.editCarte);
    $scope.editCarte = {};
  };
  $scope.updateProdus = function() {
    $http.put('http://localhost:8080/produs', $scope.editProdus);
    $scope.editProdus = {};
  };
  $scope.updateBautura = function() {
    $http.put('http://localhost:8080/bautura', $scope.editBautura);
    $scope.editBautura = {};
  };
  $scope.deletePersoana = function(id) {
    $http.delete('http://localhost:8080/persoana/' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };

$scope.deleteCarte = function(id) {
    $http.delete('http://localhost:8080/carte/' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };

  $scope.deleteProdus = function(id) {
    $http.delete('http://localhost:8080/produs/' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };
  $scope.deleteBautura = function(id) {
    $http.delete('http://localhost:8080/bautura/' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };

  $scope.myArray = ['Elem 1', 'Elem 2', 'Elem 3', 'Elem 4'];
}]);