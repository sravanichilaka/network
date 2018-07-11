/**
 * FriendService
 */
app.factory('FriendService',function($http){
	var friendService={}
	
	
	friendService.getSuggestedUsers=function(){
		return $http.get("http://localhost:8055/socialnetworkmiddleware/suggestedusers")
		
	}	
	friendService.sendFriendRequest=function(toIdValue){// toIdValue is User object
		return $http.post("http://localhost:8055/socialnetworkmiddleware/addfriend",toIdValue)
		
	}	
	friendService.getPendingRequests=function(){
		return $http.get("http://localhost:8055/socialnetworkmiddleware/pendingrequests")
		
	}	
	friendService.updateStatus=function(updatedFriendRequest){
		return $http.put("http://localhost:8055/socialnetworkmiddleware/updatestatus",updatedFriendRequest)
		
	}	
	friendService.getAllFriends=function(){
		return $http.get("http://localhost:8055/socialnetworkmiddleware/friends")
		
	}	

	return friendService;
})

 	