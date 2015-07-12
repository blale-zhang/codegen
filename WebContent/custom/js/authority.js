/**
 * authority.js
 */
define('authority',['jquery','base','liger.all'],function(require, exports, module){
	
	
	var AuthorityUtils = {};
	
	AuthorityUtils.manager = {};
	
	AuthorityUtils.CRUD = {add:1,read:8,"delete":4, modify:2 };
	AuthorityUtils.CRUD_ENUM = {ADD:9,READ:8,"DELETE":12, MODIFY:10 }
	//temp authority
	AuthorityUtils.tempAuthority = [];
	
	AuthorityUtils.manager.clearTempAuthority = function(){
		if(AuthorityUtils.tempAuthority.length > 0){
			AuthorityUtils.tempAuthority = [];
		}
	}
	
	/**
	 * Calculat all the authority value;
	 */
	AuthorityUtils.manager.calculater = function(authority){
		
		if(authority && authority.query ){
			authority.weightValue = AuthorityUtils.CRUD.read;
			
			if(authority && authority['delete'] ){
				authority.weightValue += AuthorityUtils.CRUD['delete'];	
			}
			if(authority && authority.add ){
				authority.weightValue += AuthorityUtils.CRUD.add;
			}
			if(authority && authority.modify ){
				authority.weightValue += AuthorityUtils.CRUD.modify;	
			}
		}else{
			authority.weightValue = 0;
		}
		
		return authority;
	}
	
	module.exports = AuthorityUtils;
	
});