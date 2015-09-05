/**
 * Created by Sandeep on 01/06/14.
 */

angular.module('movieApp.services',[]).factory('Movie',function($resource){
    var resource = $resource('http://localhost:8080/register/users/:id');
    
    var urlBase = '/api/customers';
    var dataFactory = {};

    dataFactory.getAllUsers = function (name) {    
        return resource.query();        
    };

    dataFactory.getUser = function (name) {
        return resource.get(name);
    };

    dataFactory.insertUser = function (user) {
    user = {'name': 'VIJAYA', 'phone':000888888, 'email':'email@gmail.com'};
        return resource.save(user);
    };

    dataFactory.deleteCustomer = function (id) {
        return $http.delete(urlBase + '/' + id);
    };

    dataFactory.getOrders = function (id) {
        return $http.get(urlBase + '/' + id + '/orders');
    };

    return dataFactory;
    
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});