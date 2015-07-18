/**
 * main.js
 */

define('main',['jquery','base',,'liger.all'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	require("liger.all")($);
	var ctx = Base.common.utils.getContextPath();
	
	initLayout();
	
	function initLayout(){
		 $.ligerMethos.Accordion.reload = function (html) {
             this.accordion.html(html);
             this._render();
         };
		 $("#accordion").ligerAccordion(
	                {
	                    height: 500,
	                    changeHeightOnResize:true
	                })
		 $("#layout").ligerLayout({ leftWidth: 200});
		
		 $("#center").ligerTab({height:'100%',width:'100%', onBeforeAddTabItem:function(aaa){
			 console.log(aaa);}
		 });
		 
		 
	     $.ajax({
			url: ctx+ '/auth/loadNavigation.do',
			type : 'POST',
			dataType : 'json',
			data : {parentId:0,type:0},
			success : function(backData) {
				var html = [];
				for(var i = 0 ; i < backData.length; i ++){
					html.push('<div title="' + backData[i].name + '" id="tree' + backData[i].id + '" weightValue = "'
							+ backData[i].weight_value +'">'+ ctx + backData[i].url+'</div>')
				}
				$("#accordion").ligerAccordion('reload', html.join(''));
				
				for(var i = 0 ; i < backData.length; i ++){
					$("#tree"+backData[i].id).ligerTree({
				            nodeWidth: 60,
				            url:  ctx+ '/auth/loadNavigation.do?parentId=' + backData[i].id+"&type=2",
				            textFieldName:'name',
				            checkbox:false,
				            single:true,
				            parentIcon:'folder',
				            childIcon:'leaf',
				            isLeaf : function(data)
				            {
				                if (data && data.sonNodeNum ) return false;
				                return true;
				            },
				            delay: function(e)
				            {
				            	 var data = e.data;
				            	 if(data.sonNodeNum){
				            		 return { url: ctx + '/auth/loadNavigation.do?parentId=' + data.id+"&type=2"};
				            	 }
				            	 return false;
	                             
				            },
				            checkbox: true,
				            idFieldName: 'id', 
				            slide: false,
				            onClick:function(data){
				            	addTab(ctx + data.data.url,data.data.name);
				            }
				        });
				}
			}
	    });
		
	}
	
	function addTab(url,name){
		
		var navTab =  $("#center").ligerGetTabManager();
		var tabId = { url: url,text:name ,tabid:name,tabId:name};
		if(!navTab.isTabItemExist(tabId.text)){
			navTab.addTabItem(tabId);
		}else{
			navTab.selectTabItem(tabId.tabId);
		}
		
	}
});


