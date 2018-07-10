/**
 * FriendService
 */
app.factory('FriendService',function($http){
	var friendService={}
	
	
	friendService.getSuggestedUsers=function(){
		return $http.get("http://localhost:8055/sociaalnetworkmiddleware/suggestedusers")
		
	}	
	friendService.sendFriendRequest=function(toIdValue){// toIdValue is User object
		return $http.post("http://localhost:8055/sociaalnetworkmiddleware/addfriend",toIdValue)
		
	}	
	friendService.getPendingRequests=function(){
		return $http.get("http://localhost:8055/sociaalnetworkmiddleware/pendingrequests")
		
	}	
	friendService.updateStatus=function(updatedFriendRequest){
		return $http.put("http://localhost:8055/sociaalnetworkmiddleware/updatestatus",updatedFriendRequest)
		
	}	
	friendService.getAllFriends=function(){
		return $http.get("http://localhost:8055/sociaalnetworkmiddleware/friends")
		
	}	

	return friendService;
})

 	